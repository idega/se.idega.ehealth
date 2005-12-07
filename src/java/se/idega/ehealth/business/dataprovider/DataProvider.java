package se.idega.ehealth.business.dataprovider;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import se.carelink.webservices.npo.ArrayOfKuvert;
import se.carelink.webservices.npo.HamtaVarddokumentIndexReply;
import se.carelink.webservices.npo.Kuvert;
import se.idega.ehealth.business.dataprovider.valueobj.PersonalInfo;
import se.idega.ehealth.presentation.valueobjects.ContactsValueObject;

/**
 * 
 * <p>
 * TODO Maris_O Describe Type DataProvider
 * </p>
 * Last modified: $Date: 2005/12/07 16:29:38 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris.Orbidans@idega.lv">Maris.Orbidans</a>
 * @version $Revision: 1.4 $
 */
public interface DataProvider
{
    public Object readReferalls(String personId, String contactId);
    public ContactsValueObject[] readContacts(String personId);
    public PersonalInfo readPersonalInfo(String personId);
}
