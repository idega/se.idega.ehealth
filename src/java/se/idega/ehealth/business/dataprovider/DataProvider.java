package se.idega.ehealth.business.dataprovider;

import se.idega.ehealth.business.dataprovider.valueobj.PersonalInfo;

/**
 * 
 * <p>
 * TODO Maris_O Describe Type DataProvider
 * </p>
 * Last modified: $Date: 2005/10/26 18:30:48 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris.Orbidans@idega.lv">Maris.Orbidans</a>
 * @version $Revision: 1.2 $
 */
public interface DataProvider
{

    public PersonalInfo readPersonalInfo(String personId);
}