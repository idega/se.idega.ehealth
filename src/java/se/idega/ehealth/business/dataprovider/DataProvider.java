package se.idega.ehealth.business.dataprovider;

import se.idega.ehealth.business.dataprovider.valueobj.PersonalInfo;
import se.idega.ehealth.presentation.valueobjects.ContactsValueObject;
import se.idega.ehealth.presentation.valueobjects.DiagnosisValueObject;
import se.idega.ehealth.presentation.valueobjects.MedicinesValueObject;
import se.idega.ehealth.presentation.valueobjects.ReferralsOfXrayValueObject;
import se.idega.ehealth.presentation.valueobjects.ReferralsValueObject;

/**
 * 
 * <p>
 * TODO Maris_O Describe Type DataProvider
 * </p>
 * Last modified: $Date: 2006/03/06 16:43:39 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris.Orbidans@idega.lv">Maris.Orbidans</a>
 * @version $Revision: 1.5 $
 */
public interface DataProvider
{
    public ContactsValueObject[] readContacts(String personId);
    public ReferralsValueObject[] readReferralsOfClinical(String personId);    
    public ReferralsOfXrayValueObject[] readReferralsOfXray(String personId);
    public MedicinesValueObject[] readMedicines(String personId);
    public DiagnosisValueObject[] readDiagnosis(String personId) ;   
    public PersonalInfo readPersonalInfo(String personId);
}
