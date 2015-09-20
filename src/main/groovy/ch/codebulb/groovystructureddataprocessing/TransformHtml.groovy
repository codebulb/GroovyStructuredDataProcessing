package ch.codebulb.groovystructureddataprocessing

import groovy.xml.MarkupBuilder
import groovy.xml.QName
import org.ccil.cowan.tagsoup.Parser

class TransformHtml {
    /**
     * Flips an HTML table by 90 degrees, i.e. runs rows into columns and vice versa.
     */
    public static String flipTable(String htmlString) {
        Parser parser = new Parser()
        def html = new XmlParser(parser).parseText(htmlString)
        
        Writer writer = new StringWriter()
        MarkupBuilder xmlBuilder = new MarkupBuilder(writer)
        
        return formatHtml(flipTable(html))
    }
    
    protected static String flipTable(def html) {
        Writer writer = new StringWriter()
        MarkupBuilder xmlBuilder = new MarkupBuilder(writer)
        
        Map rows = [:].withDefault{[]}
        
        // 1. Implement row / column flip
        html.body.table.tbody.tr.eachWithIndex { _tr, _tr_i ->
            // for each row
            _tr.'*'.eachWithIndex { cell, cellNo ->
                // for each cell in row
                if (rows[cellNo][_tr_i] == null) {
                    rows[cellNo][_tr_i] = cell
                }
                else {
                    // if its place is already occupied that means that it was filled by a previous cell
                    // with colspan/rowspan > 1. Search for the new free place in the same row
                    rows[searchNextFreeSpace(rows, cellNo, _tr_i)][_tr_i] = cell
                }
                int rowspan = cell.@rowspan.toInteger()
                if (rowspan > 1) {
                    (rowspan-1).times { i ->
                        // mark all cells consumed by the ROWspan as "occupied" by inserting a value there
                        rows[cellNo] << false
                    }
                }
                int colspan = cell.@colspan.toInteger()
                if (colspan > 1) {
                    (colspan-1).times { i ->
                        // mark all cells consumed by the COLspan as "occupied" by inserting a value there
                        rows[cellNo+i+1] << false
                        if (rowspan > 1) {
                            (rowspan-1).times {
                                // mark all cells consumed by the ROWspan as "occupied" by inserting a value there
                                rows[cellNo+i+1] << false
                            }
                        }
                    }
                }
                
            }
        }
        
        // 2. Build new table
        xmlBuilder.table(html.body.table[0].attributes()) {
            tbody {
                rows.each { rowIndex, tuples ->
                    tr {
                        tuples.each { tuple ->
                            if (tuple == null) {
                                // this cell was originally not present. Insert an empty one
                                td()
                            }
                            else if (tuple in Boolean) {
                                // this cell is marked as "jump over" due to previous colspan/rowspan > 1
                            }
                            else {
                                // insert the whole XML tree
                                copy(flipCell(tuple, rowIndex), xmlBuilder)
                            }
                        }
                    }
                }
            }
        }
        
        return writer.toString()
    }
    
    /**
     * Searches for the next non-empy cell in the row / column matrix provided, strting with the rowNo / colNo provided
     */
    private static int searchNextFreeSpace(Map rows, rowNo, colNo) {
        def value = rows[rowNo][colNo]
        while (value != null) {
            rowNo++
            value = rows[rowNo][colNo]
        }
        return rowNo
    }
    
    /**
     * Deep-copies the XML node structure provided using the builder provided.
     */
    protected static copy(node, builder) {
        if (node in String) {
            builder.mkp.yield(node)
        }
        else {
            builder."${node.name().localPart}"(node.attributes()) {
                node.children().each { child ->
                    copy(child, builder)
                }
            }
        }
    }
    
    /**
     * Does the necessary transformations to every single cell which is part of a {@link #flipTable(Object)} transformation.
     */
    private static Node flipCell(originalNode, int index) {
        def attributes = originalNode.attributes().collectEntries { attr ->
            if (attr.key == 'colspan') {
                return [(attr.key): originalNode.attributes().rowspan]
            }
            else if (attr.key == 'rowspan') {
                return [(attr.key): originalNode.attributes().colspan]
            }
            else {
                return attr
            }
        }
        // change td nodes to th nodes if they are in the first row
        QName name = new QName(originalNode.name().namespaceURI, index == 0 ? "th" : originalNode.name().localPart)
        return new Node(originalNode.parent(), name, attributes, originalNode.value())
    }
    
    /**
     * Pretty-formats HTML such that problems with rendering inner texts are prevented (http://stackoverflow.com/a/5078297/1399395)
     */
    protected static String formatHtml(String html) {
        return html.replaceAll($/([^>])\n(\s*)</$, { all, lineEnd, space ->
            // text, followed by EOL, followed by a tag
            "${lineEnd}<!--\n${space}--><"
            // insert comment between EOL and tag
        })
    }
}

