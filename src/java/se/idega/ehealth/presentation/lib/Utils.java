package se.idega.ehealth.presentation.lib;

import javax.faces.context.FacesContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.idega.presentation.IWContext;


public class Utils
{
    private static Log log = LogFactory.getLog(Utils.class);
    public final static String DEFAULT_PERSON_ID = "191212121212";
    
    public static String readPersonId()
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
        return personId == null ? DEFAULT_PERSON_ID : personId;
    }
}
