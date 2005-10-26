package se.idega.ehealth.business.dataprovider;

import se.idega.ehealth.business.dataprovider.implementations.NPODataProvider;

/**
 * 
 * <p>
 * TODO Maris_O Describe Type DataProviderFactory
 * </p>
 * Last modified: $Date: 2005/10/26 18:10:16 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris.Orbidans@idega.lv">Maris.Orbidans</a>
 * @version $Revision: 1.1 $
 */
public class DataProviderFactory
{

    public DataProvider createDataProvider()
    {
        return new NPODataProvider();
    }
}
