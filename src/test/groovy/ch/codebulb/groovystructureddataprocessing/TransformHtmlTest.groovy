package ch.codebulb.groovystructureddataprocessing

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import static org.junit.Assert.*
import groovy.transform.CompileStatic
import groovy.xml.MarkupBuilder

class TransformHtmlTest {
    @Test
    public void testFlipTable() {
        assert FLIP_TABLE_HTML_OUTPUT == TransformHtml.flipTable(FLIP_TABLE_HTML_INPUT)
    }
    
    @Test
    public void testBuildSimpleHtmlStrucutre() {
        assert SIMPLE_HTML_OUTPUT == buildSomeHtml()
    }
    
    private static String buildSomeHtml() {
        Writer writer = new StringWriter()
        MarkupBuilder xmlBuilder = new MarkupBuilder(writer)
        
        xmlBuilder.html {
            body {
                div(id: 'myDiv') {
                    mkp.yield('My Text')
                }
            }
        }
        
        return writer.toString()
    }
    
    // "Current OPEC members table" from https://en.wikipedia.org/wiki/OPEC#Current_members
    private static final String FLIP_TABLE_HTML_INPUT = """<table class="wikitable sortable">
<tbody><tr>
<th style="width:200px;">Country</th>
<th style="width:100px;">Region</th>
<th style="width:120px;">Joined OPEC<sup class="reference" id="cite_ref-Who_are_OPEC_Member_70-0"><a href="#cite_note-Who_are_OPEC_Member-70"><span>[</span>70<span>]</span></a></sup></th>
<th style="width:150px;">Population<br>
<small>(July 2012)</small><sup class="reference" id="cite_ref-CIA_Population_71-0"><a href="#cite_note-CIA_Population-71"><span>[</span>71<span>]</span></a></sup></th>
<th style="width:150px;">Area (km²)<sup class="reference" id="cite_ref-CIA_Area_72-0"><a href="#cite_note-CIA_Area-72"><span>[</span>72<span>]</span></a></sup></th>
<th style="width:150px;"><a title="List of countries by oil production" href="/wiki/List_of_countries_by_oil_production">Production</a> (<a title="Barrel (unit)" href="/wiki/Barrel_(unit)">bbl</a>/day)</th>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="15" data-file-height="600" data-file-width="900" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/35px-Flag_of_Algeria.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/45px-Flag_of_Algeria.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/23px-Flag_of_Algeria.svg.png" alt="">&nbsp;</span><a title="Algeria" href="/wiki/Algeria">Algeria</a></td>
<td><a title="Africa" href="/wiki/Africa">Africa</a></td>
<td>1969</td>
<td align="right">37,367,226</td>
<td align="right">2,381,740</td>
<td align="right"><span class="sortkey" style="display:none;">02125000 !</span><span class="sorttext">2,125,000</span> (16th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="15" data-file-height="300" data-file-width="450" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/35px-Flag_of_Angola.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/45px-Flag_of_Angola.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/23px-Flag_of_Angola.svg.png" alt="">&nbsp;</span><a title="Angola" href="/wiki/Angola">Angola</a></td>
<td><a title="Africa" href="/wiki/Africa">Africa</a></td>
<td>2007</td>
<td align="right">18,056,072</td>
<td align="right">1,246,700</td>
<td align="right"><span class="sortkey" style="display:none;">01948000 !</span><span class="sorttext">1,948,000</span> (17th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="15" data-file-height="960" data-file-width="1440" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Flag_of_Ecuador.svg/35px-Flag_of_Ecuador.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Flag_of_Ecuador.svg/45px-Flag_of_Ecuador.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Flag_of_Ecuador.svg/23px-Flag_of_Ecuador.svg.png" alt="">&nbsp;</span><a title="Ecuador" href="/wiki/Ecuador">Ecuador</a></td>
<td><a title="South America" href="/wiki/South_America">South America</a></td>
<td>(1973) 2007<sup class="reference" id="cite_ref-Ecuador_73-0"><a href="#cite_note-Ecuador-73"><span>[</span>A 1<span>]</span></a></sup></td>
<td align="right">15,223,680</td>
<td align="right">283,560</td>
<td align="right"><span class="sortkey" style="display:none;">00485700 !</span><span class="sorttext">485,700</span> (30th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="15" data-file-height="800" data-file-width="1200" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/35px-Flag_of_Indonesia.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/45px-Flag_of_Indonesia.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/23px-Flag_of_Indonesia.svg.png" alt="">&nbsp;</span><a title="Indonesia" href="/wiki/Indonesia">Indonesia</a></td>
<td><a title="Asia" href="/wiki/Asia">Asia</a> (<a class="mw-redirect" title="South East Asia" href="/wiki/South_East_Asia">South East Asia</a>)</td>
<td>1960<sup class="reference" id="cite_ref-Founder_74-0"><a href="#cite_note-Founder-74"><span>[</span>A 2<span>]</span></a></sup></td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="13" data-file-height="360" data-file-width="630" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/35px-Flag_of_Iran.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/46px-Flag_of_Iran.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/23px-Flag_of_Iran.svg.png" alt="">&nbsp;</span><a title="Iran" href="/wiki/Iran">Iran</a></td>
<td><a title="Middle East" href="/wiki/Middle_East">Middle East</a> (<a title="Western Asia" href="/wiki/Western_Asia">Western Asia</a>)</td>
<td>1960<sup class="reference" id="cite_ref-Founder_74-1"><a href="#cite_note-Founder-74"><span>[</span>A 2<span>]</span></a></sup></td>
<td align="right">78,868,711</td>
<td align="right">1,648,000</td>
<td align="right"><span class="sortkey" style="display:none;">04172000 !</span><span class="sorttext">6,172,000</span> (4th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="15" data-file-height="274" data-file-width="411" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Flag_of_Iraq.svg/35px-Flag_of_Iraq.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Flag_of_Iraq.svg/45px-Flag_of_Iraq.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Flag_of_Iraq.svg/23px-Flag_of_Iraq.svg.png" alt="">&nbsp;</span><a title="Iraq" href="/wiki/Iraq">Iraq</a></td>
<td><a title="Middle East" href="/wiki/Middle_East">Middle East</a> (<a title="Western Asia" href="/wiki/Western_Asia">Western Asia</a>)</td>
<td>1960<sup class="reference" id="cite_ref-Founder_74-2"><a href="#cite_note-Founder-74"><span>[</span>A 2<span>]</span></a></sup></td>
<td align="right">31,129,225</td>
<td align="right">437,072</td>
<td align="right"><span class="sortkey" style="display:none;">03200000 !</span><span class="sorttext">3,200,000</span> (7th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="12" data-file-height="600" data-file-width="1200" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/35px-Flag_of_Kuwait.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/46px-Flag_of_Kuwait.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/23px-Flag_of_Kuwait.svg.png" alt="">&nbsp;</span><a title="Kuwait" href="/wiki/Kuwait">Kuwait</a></td>
<td><a title="Middle East" href="/wiki/Middle_East">Middle East</a> (<a title="Western Asia" href="/wiki/Western_Asia">Western Asia</a>)</td>
<td>1960<sup class="reference" id="cite_ref-Founder_74-3"><a href="#cite_note-Founder-74"><span>[</span>A 2<span>]</span></a></sup></td>
<td align="right">2,646,314</td>
<td align="right">17,820</td>
<td align="right"><span class="sortkey" style="display:none;">02494000 !</span><span class="sorttext">4,500,000</span> (5th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="12" data-file-height="480" data-file-width="960" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Libya.svg/35px-Flag_of_Libya.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Libya.svg/46px-Flag_of_Libya.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Libya.svg/23px-Flag_of_Libya.svg.png" alt="">&nbsp;</span><a title="Libya" href="/wiki/Libya">Libya</a></td>
<td><a title="Africa" href="/wiki/Africa">Africa</a></td>
<td>1962</td>
<td align="right">5,613,380</td>
<td align="right">1,759,540</td>
<td align="right"><span class="sortkey" style="display:none;">02210000 !</span><span class="sorttext">2,210,000</span> (15th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="12" data-file-height="1200" data-file-width="2400" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/35px-Flag_of_Nigeria.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/46px-Flag_of_Nigeria.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/23px-Flag_of_Nigeria.svg.png" alt="">&nbsp;</span><a title="Nigeria" href="/wiki/Nigeria">Nigeria</a></td>
<td><a title="Africa" href="/wiki/Africa">Africa</a></td>
<td>1971</td>
<td align="right">170,123,740</td>
<td align="right">923,768</td>
<td align="right"><span class="sortkey" style="display:none;">02211000 !</span><span class="sorttext">2,211,000</span> (14th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="9" data-file-height="550" data-file-width="1400" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Qatar.svg/35px-Flag_of_Qatar.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Qatar.svg/46px-Flag_of_Qatar.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Qatar.svg/23px-Flag_of_Qatar.svg.png" alt="">&nbsp;</span><a title="Qatar" href="/wiki/Qatar">Qatar</a></td>
<td><a title="Middle East" href="/wiki/Middle_East">Middle East</a> (<a title="Western Asia" href="/wiki/Western_Asia">Western Asia</a>)</td>
<td>1961</td>
<td align="right">1,951,591</td>
<td align="right">11,437</td>
<td align="right"><span class="sortkey" style="display:none;">01213000 !</span><span class="sorttext">1,213,000</span> (21st)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="15" data-file-height="500" data-file-width="750" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/35px-Flag_of_Saudi_Arabia.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/45px-Flag_of_Saudi_Arabia.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png" alt="">&nbsp;</span><a title="Saudi Arabia" href="/wiki/Saudi_Arabia">Saudi Arabia</a></td>
<td><a title="Middle East" href="/wiki/Middle_East">Middle East</a> (<a title="Western Asia" href="/wiki/Western_Asia">Western Asia</a>)</td>
<td>1960<sup class="reference" id="cite_ref-Founder_74-4"><a href="#cite_note-Founder-74"><span>[</span>A 2<span>]</span></a></sup></td>
<td align="right">26,534,504</td>
<td align="right">2,149,690</td>
<td align="right"><span class="sortkey" style="display:none;">12500000 !</span><span class="sorttext">12,500,000</span> (2nd)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="12" data-file-height="600" data-file-width="1200" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/35px-Flag_of_the_United_Arab_Emirates.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/46px-Flag_of_the_United_Arab_Emirates.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/23px-Flag_of_the_United_Arab_Emirates.svg.png" alt="">&nbsp;</span><a title="United Arab Emirates" href="/wiki/United_Arab_Emirates">United Arab Emirates</a></td>
<td><a title="Middle East" href="/wiki/Middle_East">Middle East</a> (<a title="Western Asia" href="/wiki/Western_Asia">Western Asia</a>)</td>
<td>1967</td>
<td align="right">5,314,317</td>
<td align="right">83,600</td>
<td align="right"><span class="sortkey" style="display:none;">02798000 !</span><span class="sorttext">2,798,000</span> (8th)</td>
</tr>
<tr>
<td><span class="flagicon"><img width="23" height="15" data-file-height="600" data-file-width="900" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Venezuela.svg/35px-Flag_of_Venezuela.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Venezuela.svg/45px-Flag_of_Venezuela.svg.png 2x" class="thumbborder" src="//upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Venezuela.svg/23px-Flag_of_Venezuela.svg.png" alt="">&nbsp;</span><a title="Venezuela" href="/wiki/Venezuela">Venezuela</a></td>
<td><a title="South America" href="/wiki/South_America">South America</a></td>
<td>1960<sup class="reference" id="cite_ref-Founder_74-5"><a href="#cite_note-Founder-74"><span>[</span>A 2<span>]</span></a></sup></td>
<td align="right">28,047,938</td>
<td align="right">912,050</td>
<td align="right"><span class="sortkey" style="display:none;">02472000 !</span><span class="sorttext">2,472,000</span> (11th)</td>
</tr>
<tr class="sortbottom">
<th colspan="3">Total</th>
<th>369,368,429</th>
<th>11,854,977 km²</th>
<th>33,327,700 bbl/day</th>
</tr>
</tbody></table>"""
    
    private static final String FLIP_TABLE_HTML_OUTPUT = """<table class='wikitable sortable'>
  <tbody>
    <tr>
      <th colspan='1' rowspan='1' style='width:200px;'>Country</th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='15' data-file-height='600' data-file-width='900' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/35px-Flag_of_Algeria.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/45px-Flag_of_Algeria.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/23px-Flag_of_Algeria.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Algeria' href='/wiki/Algeria'>Algeria</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='15' data-file-height='300' data-file-width='450' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/35px-Flag_of_Angola.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/45px-Flag_of_Angola.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/23px-Flag_of_Angola.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Angola' href='/wiki/Angola'>Angola</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='15' data-file-height='960' data-file-width='1440' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Flag_of_Ecuador.svg/35px-Flag_of_Ecuador.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Flag_of_Ecuador.svg/45px-Flag_of_Ecuador.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Flag_of_Ecuador.svg/23px-Flag_of_Ecuador.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Ecuador' href='/wiki/Ecuador'>Ecuador</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='15' data-file-height='800' data-file-width='1200' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/35px-Flag_of_Indonesia.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/45px-Flag_of_Indonesia.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/23px-Flag_of_Indonesia.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Indonesia' href='/wiki/Indonesia'>Indonesia</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='13' data-file-height='360' data-file-width='630' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/35px-Flag_of_Iran.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/46px-Flag_of_Iran.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/23px-Flag_of_Iran.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Iran' href='/wiki/Iran'>Iran</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='15' data-file-height='274' data-file-width='411' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Flag_of_Iraq.svg/35px-Flag_of_Iraq.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Flag_of_Iraq.svg/45px-Flag_of_Iraq.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Flag_of_Iraq.svg/23px-Flag_of_Iraq.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Iraq' href='/wiki/Iraq'>Iraq</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='12' data-file-height='600' data-file-width='1200' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/35px-Flag_of_Kuwait.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/46px-Flag_of_Kuwait.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/23px-Flag_of_Kuwait.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Kuwait' href='/wiki/Kuwait'>Kuwait</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='12' data-file-height='480' data-file-width='960' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Libya.svg/35px-Flag_of_Libya.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Libya.svg/46px-Flag_of_Libya.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Libya.svg/23px-Flag_of_Libya.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Libya' href='/wiki/Libya'>Libya</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='12' data-file-height='1200' data-file-width='2400' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/35px-Flag_of_Nigeria.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/46px-Flag_of_Nigeria.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/23px-Flag_of_Nigeria.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Nigeria' href='/wiki/Nigeria'>Nigeria</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='9' data-file-height='550' data-file-width='1400' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Qatar.svg/35px-Flag_of_Qatar.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Qatar.svg/46px-Flag_of_Qatar.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Qatar.svg/23px-Flag_of_Qatar.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Qatar' href='/wiki/Qatar'>Qatar</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='15' data-file-height='500' data-file-width='750' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/35px-Flag_of_Saudi_Arabia.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/45px-Flag_of_Saudi_Arabia.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Saudi Arabia' href='/wiki/Saudi_Arabia'>Saudi Arabia</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='12' data-file-height='600' data-file-width='1200' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/35px-Flag_of_the_United_Arab_Emirates.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/46px-Flag_of_the_United_Arab_Emirates.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/23px-Flag_of_the_United_Arab_Emirates.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='United Arab Emirates' href='/wiki/United_Arab_Emirates'>United Arab Emirates</a>
      </th>
      <th colspan='1' rowspan='1'>
        <span class='flagicon'>
          <img class='thumbborder' width='23' height='15' data-file-height='600' data-file-width='900' srcset='//upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Venezuela.svg/35px-Flag_of_Venezuela.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Venezuela.svg/45px-Flag_of_Venezuela.svg.png 2x' src='//upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Venezuela.svg/23px-Flag_of_Venezuela.svg.png' alt='' /> <!--
        --></span>
        <a shape='rect' title='Venezuela' href='/wiki/Venezuela'>Venezuela</a>
      </th>
      <th colspan='1' rowspan='3'>Total</th>
    </tr>
    <tr>
      <th colspan='1' rowspan='1' style='width:100px;'>Region</th>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Africa' href='/wiki/Africa'>Africa</a>
      </td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Africa' href='/wiki/Africa'>Africa</a>
      </td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='South America' href='/wiki/South_America'>South America</a>
      </td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Asia' href='/wiki/Asia'>Asia</a> (<!--
        --><a shape='rect' class='mw-redirect' title='South East Asia' href='/wiki/South_East_Asia'>South East Asia</a>)<!--
      --></td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Middle East' href='/wiki/Middle_East'>Middle East</a> (<!--
        --><a shape='rect' title='Western Asia' href='/wiki/Western_Asia'>Western Asia</a>)<!--
      --></td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Middle East' href='/wiki/Middle_East'>Middle East</a> (<!--
        --><a shape='rect' title='Western Asia' href='/wiki/Western_Asia'>Western Asia</a>)<!--
      --></td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Middle East' href='/wiki/Middle_East'>Middle East</a> (<!--
        --><a shape='rect' title='Western Asia' href='/wiki/Western_Asia'>Western Asia</a>)<!--
      --></td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Africa' href='/wiki/Africa'>Africa</a>
      </td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Africa' href='/wiki/Africa'>Africa</a>
      </td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Middle East' href='/wiki/Middle_East'>Middle East</a> (<!--
        --><a shape='rect' title='Western Asia' href='/wiki/Western_Asia'>Western Asia</a>)<!--
      --></td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Middle East' href='/wiki/Middle_East'>Middle East</a> (<!--
        --><a shape='rect' title='Western Asia' href='/wiki/Western_Asia'>Western Asia</a>)<!--
      --></td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='Middle East' href='/wiki/Middle_East'>Middle East</a> (<!--
        --><a shape='rect' title='Western Asia' href='/wiki/Western_Asia'>Western Asia</a>)<!--
      --></td>
      <td colspan='1' rowspan='1'>
        <a shape='rect' title='South America' href='/wiki/South_America'>South America</a>
      </td>
    </tr>
    <tr>
      <th colspan='1' rowspan='1' style='width:120px;'>Joined OPEC<!--
        --><sup class='reference' id='cite_ref-Who_are_OPEC_Member_70-0'>
          <a shape='rect' href='#cite_note-Who_are_OPEC_Member-70'>
            <span>[</span>70<!--
            --><span>]</span>
          </a>
        </sup>
      </th>
      <td colspan='1' rowspan='1'>1969</td>
      <td colspan='1' rowspan='1'>2007</td>
      <td colspan='1' rowspan='1'>(1973) 2007<!--
        --><sup class='reference' id='cite_ref-Ecuador_73-0'>
          <a shape='rect' href='#cite_note-Ecuador-73'>
            <span>[</span>A 1<!--
            --><span>]</span>
          </a>
        </sup>
      </td>
      <td colspan='1' rowspan='1'>1960<!--
        --><sup class='reference' id='cite_ref-Founder_74-0'>
          <a shape='rect' href='#cite_note-Founder-74'>
            <span>[</span>A 2<!--
            --><span>]</span>
          </a>
        </sup>
      </td>
      <td colspan='1' rowspan='1'>1960<!--
        --><sup class='reference' id='cite_ref-Founder_74-1'>
          <a shape='rect' href='#cite_note-Founder-74'>
            <span>[</span>A 2<!--
            --><span>]</span>
          </a>
        </sup>
      </td>
      <td colspan='1' rowspan='1'>1960<!--
        --><sup class='reference' id='cite_ref-Founder_74-2'>
          <a shape='rect' href='#cite_note-Founder-74'>
            <span>[</span>A 2<!--
            --><span>]</span>
          </a>
        </sup>
      </td>
      <td colspan='1' rowspan='1'>1960<!--
        --><sup class='reference' id='cite_ref-Founder_74-3'>
          <a shape='rect' href='#cite_note-Founder-74'>
            <span>[</span>A 2<!--
            --><span>]</span>
          </a>
        </sup>
      </td>
      <td colspan='1' rowspan='1'>1962</td>
      <td colspan='1' rowspan='1'>1971</td>
      <td colspan='1' rowspan='1'>1961</td>
      <td colspan='1' rowspan='1'>1960<!--
        --><sup class='reference' id='cite_ref-Founder_74-4'>
          <a shape='rect' href='#cite_note-Founder-74'>
            <span>[</span>A 2<!--
            --><span>]</span>
          </a>
        </sup>
      </td>
      <td colspan='1' rowspan='1'>1967</td>
      <td colspan='1' rowspan='1'>1960<!--
        --><sup class='reference' id='cite_ref-Founder_74-5'>
          <a shape='rect' href='#cite_note-Founder-74'>
            <span>[</span>A 2<!--
            --><span>]</span>
          </a>
        </sup>
      </td>
    </tr>
    <tr>
      <th colspan='1' rowspan='1' style='width:150px;'>Population<!--
        --><br clear='none' />
        <small>(July 2012)</small>
        <sup class='reference' id='cite_ref-CIA_Population_71-0'>
          <a shape='rect' href='#cite_note-CIA_Population-71'>
            <span>[</span>71<!--
            --><span>]</span>
          </a>
        </sup>
      </th>
      <td align='right' colspan='1' rowspan='1'>37,367,226</td>
      <td align='right' colspan='1' rowspan='1'>18,056,072</td>
      <td align='right' colspan='1' rowspan='1'>15,223,680</td>
      <td />
      <td align='right' colspan='1' rowspan='1'>78,868,711</td>
      <td align='right' colspan='1' rowspan='1'>31,129,225</td>
      <td align='right' colspan='1' rowspan='1'>2,646,314</td>
      <td align='right' colspan='1' rowspan='1'>5,613,380</td>
      <td align='right' colspan='1' rowspan='1'>170,123,740</td>
      <td align='right' colspan='1' rowspan='1'>1,951,591</td>
      <td align='right' colspan='1' rowspan='1'>26,534,504</td>
      <td align='right' colspan='1' rowspan='1'>5,314,317</td>
      <td align='right' colspan='1' rowspan='1'>28,047,938</td>
      <th colspan='1' rowspan='1'>369,368,429</th>
    </tr>
    <tr>
      <th colspan='1' rowspan='1' style='width:150px;'>Area (km²)<!--
        --><sup class='reference' id='cite_ref-CIA_Area_72-0'>
          <a shape='rect' href='#cite_note-CIA_Area-72'>
            <span>[</span>72<!--
            --><span>]</span>
          </a>
        </sup>
      </th>
      <td align='right' colspan='1' rowspan='1'>2,381,740</td>
      <td align='right' colspan='1' rowspan='1'>1,246,700</td>
      <td align='right' colspan='1' rowspan='1'>283,560</td>
      <td />
      <td align='right' colspan='1' rowspan='1'>1,648,000</td>
      <td align='right' colspan='1' rowspan='1'>437,072</td>
      <td align='right' colspan='1' rowspan='1'>17,820</td>
      <td align='right' colspan='1' rowspan='1'>1,759,540</td>
      <td align='right' colspan='1' rowspan='1'>923,768</td>
      <td align='right' colspan='1' rowspan='1'>11,437</td>
      <td align='right' colspan='1' rowspan='1'>2,149,690</td>
      <td align='right' colspan='1' rowspan='1'>83,600</td>
      <td align='right' colspan='1' rowspan='1'>912,050</td>
      <th colspan='1' rowspan='1'>11,854,977 km²</th>
    </tr>
    <tr>
      <th colspan='1' rowspan='1' style='width:150px;'>
        <a shape='rect' title='List of countries by oil production' href='/wiki/List_of_countries_by_oil_production'>Production</a> (<!--
        --><a shape='rect' title='Barrel (unit)' href='/wiki/Barrel_(unit)'>bbl</a>/day)<!--
      --></th>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>02125000 !</span>
        <span class='sorttext'>2,125,000</span> (16th)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>01948000 !</span>
        <span class='sorttext'>1,948,000</span> (17th)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>00485700 !</span>
        <span class='sorttext'>485,700</span> (30th)<!--
      --></td>
      <td />
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>04172000 !</span>
        <span class='sorttext'>6,172,000</span> (4th)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>03200000 !</span>
        <span class='sorttext'>3,200,000</span> (7th)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>02494000 !</span>
        <span class='sorttext'>4,500,000</span> (5th)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>02210000 !</span>
        <span class='sorttext'>2,210,000</span> (15th)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>02211000 !</span>
        <span class='sorttext'>2,211,000</span> (14th)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>01213000 !</span>
        <span class='sorttext'>1,213,000</span> (21st)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>12500000 !</span>
        <span class='sorttext'>12,500,000</span> (2nd)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>02798000 !</span>
        <span class='sorttext'>2,798,000</span> (8th)<!--
      --></td>
      <td align='right' colspan='1' rowspan='1'>
        <span class='sortkey' style='display:none;'>02472000 !</span>
        <span class='sorttext'>2,472,000</span> (11th)<!--
      --></td>
      <th colspan='1' rowspan='1'>33,327,700 bbl/day</th>
    </tr>
  </tbody>
</table>"""
    
    private static final String SIMPLE_HTML_OUTPUT = """<html>
  <body>
    <div id='myDiv'>My Text</div>
  </body>
</html>"""
}
