package se.idega.ehealth.presentation;

import javax.faces.context.FacesContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import se.idega.ehealth.business.dataprovider.DataProvider;
import se.idega.ehealth.business.dataprovider.DataProviderFactory;
import se.idega.ehealth.business.dataprovider.valueobj.PersonalInfo;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.IWContext;
import com.idega.presentation.text.Break;
import com.idega.presentation.text.Strong;
import com.idega.presentation.text.Text;

;
/**
 * 
 * <p>
 * TODO Maris_O Describe Type PersonalInformation
 * </p>
 *  Last modified: $Date: 2005/11/15 13:34:36 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris_O@idega.com">Maris_O</a>
 * @version $Revision: 1.5 $
 */
public class PersonalInformation extends IWBaseComponent
{

    private static Log log = LogFactory.getLog(PersonalInformation.class);
    
    protected static final String IW_BUNDLE_IDENTIFIER = "se.idega.ehealth";


    public void initializeContent()
    {
        DataProviderFactory f = new DataProviderFactory();
        DataProvider p = f.createDataProvider();
        String personId = readPersonId();
        if (personId == null)
        {
            // for testing purposes and for development environment we will use id 191212121212
            personId = "191212121212";
           // personId = "188803099368";
        }
        PersonalInfo i = p.readPersonalInfo(personId);
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        IWContext iwContext = IWContext.getIWContext(context);
        
        IWResourceBundle iwrb = iwContext.getIWMainApplication().getBundle(IW_BUNDLE_IDENTIFIER).getResourceBundle(iwContext);
        String personIdLabel = iwrb.getLocalizedString("label.person_id", "Person ID");
        
        Text t = new Text();
        t.addToText("<div class=\"form-left\">");
        add(t);        
        Strong s = new Strong();
        s.add(i.getFirstname() + " " + i.getSurname());
        add(s);
        add(new Break());
        t = new Text();
        t.addToText(i.getAddress());
        add(t);
        add(new Break());
        t = new Text();
        t.addToText(i.getPostcode() + " " + i.getCity());
        add(t);
        add(new Break());
        s = new Strong();
        s.add(personIdLabel);
        add(s);
        add(new Break());
        s = new Strong();
        s.add(i.getPersonalId());
        add(s);
        t = new Text();
        t.addToText("</div>");
        add(t);        
    }

    private String readPersonId()
    {
        String personId = null;
        try
        {
            FacesContext context = FacesContext.getCurrentInstance();
            IWContext iwContext = IWContext.getIWContext(context);
            personId = iwContext.getCurrentUser().getPersonalID();
        }
        catch (Throwable ex)
        {
            log.warn("Unable to read Personal Id from IWContext", ex);
        }
        return personId;
    }
    
   
}
