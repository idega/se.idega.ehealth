package se.idega.ehealth.business.dataprovider;


/**
 * 
 * <p>
 * TODO Maris_O Describe Type DataProviderFactory
 * </p>
 * Last modified: $Date: 2005/10/27 14:14:08 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:Maris.Orbidans@idega.lv">Maris.Orbidans</a>
 * @version $Revision: 1.4 $
 */
public class DataProviderFactory
{

    public DataProvider createDataProvider()
    {
    		try {
				return (DataProvider)Class.forName("se.idega.ehealth.npo.dataprovider.NPODataProvider").newInstance();
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
    }
}
