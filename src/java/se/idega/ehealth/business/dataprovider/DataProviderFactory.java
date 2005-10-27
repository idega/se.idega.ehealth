package se.idega.ehealth.business.dataprovider;


/**
 * 
 * <p>
 * TODO Maris_O Describe Type DataProviderFactory
 * </p>
 * Last modified: $Date: 2005/10/27 12:39:55 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris.Orbidans@idega.lv">Maris.Orbidans</a>
 * @version $Revision: 1.3 $
 */
public class DataProviderFactory
{

    public DataProvider createDataProvider()
    {
        return new se.idega.ehealth.npo.dataprovider.NPODataProvider();
    }
}
