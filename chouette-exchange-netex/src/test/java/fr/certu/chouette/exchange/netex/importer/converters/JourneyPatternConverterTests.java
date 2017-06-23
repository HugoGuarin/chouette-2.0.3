package fr.certu.chouette.exchange.netex.importer.converters;

import com.vividsolutions.jts.util.Assert;
import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;
import fr.certu.chouette.model.neptune.JourneyPattern;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@ContextConfiguration(locations = {"classpath:testContext.xml"})
@SuppressWarnings("unchecked")
public class JourneyPatternConverterTests extends AbstractTestNGSpringContextTests {

    private JourneyPatternConverter journeyPatternConverter;
    private AutoPilot autoPilot;
    private VTDNav nav;

    @BeforeClass
    protected void setUp() throws Exception {
        File f = FileUtils.getFile("src","test", "resources", "line2_test.xml");;
        FileInputStream fis = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        fis.read(b);
        
        VTDGen vg = new VTDGen();
        vg.setDoc(b);
        vg.parse(true); // set namespace awareness to true

        nav = vg.getNav();
        autoPilot = new AutoPilot(nav);
        autoPilot.declareXPathNameSpace("netex","http://www.netex.org.uk/netex");        
        
        journeyPatternConverter = new JourneyPatternConverter(nav);
    }

    @Test(groups = {"NeptuneConverter"}, description = "Must return journey patterns")
    public void verifyJourneyPatternConverter() throws XPathEvalException, NavException, XPathParseException, ParseException {
        List<JourneyPattern> journeyPatterns = journeyPatternConverter.convert();
        
        int result = -1;
        autoPilot.selectXPath("//netex:ServicePattern//netex:Name");
        int counter = 0;
        
        while( (result = autoPilot.evalXPath()) != -1 )
        {       
             int position = nav.getText();                    
             Assert.equals(nav.toNormalizedString(position), journeyPatterns.get(counter).getName());
             counter++;
        }
        
        
    }

}
