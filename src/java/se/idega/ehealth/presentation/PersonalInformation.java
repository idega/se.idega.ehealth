package se.idega.ehealth.presentation;

import javax.faces.context.FacesContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import se.idega.ehealth.business.dataprovider.DataProvider;
import se.idega.ehealth.business.dataprovider.DataProviderFactory;
import se.idega.ehealth.business.dataprovider.valueobj.PersonalInfo;
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
 *  Last modified: $Date: 2005/10/27 12:39:55 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris_O@idega.com">Maris_O</a>
 * @version $Revision: 1.3 $
 */
public class PersonalInformation extends IWBaseComponent
{

    private static Log log = LogFactory.getLog(PersonalInformation.class);

    public void initializeContent()
    {
        DataProviderFactory f = new DataProviderFactory();
        DataProvider p = f.createDataProvider();
        String personId = readPersonId();
        if (personId == null)
        {
            // for testing purposes and for development environment we will use id 191212121212
            personId = "191212121212";
        }
        PersonalInfo i = p.readPersonalInfo(personId);
        Strong s = new Strong();
        s.add(i.getFirstname() + " " + i.getSurname());
        add(s);
        add(new Break());
        Text t = new Text();
        t.addToText(i.getAddress());
        add(t);
        add(new Break());
        t = new Text();
        t.addToText(i.getPostcode() + " " + i.getCity());
        add(t);
        add(new Break());
        s = new Strong();
        s.add("Personnummer:");
        add(s);
        add(new Break());
        s = new Strong();
        s.add(i.getPersonalId());
        add(s);
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
