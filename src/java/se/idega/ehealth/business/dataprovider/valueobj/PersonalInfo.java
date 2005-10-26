package se.idega.ehealth.business.dataprovider.valueobj;

/**
 * 
 * <p>
 * TODO Maris_O Describe Type PersonalInfo
 * </p>
 *  Last modified: $Date: 2005/10/26 18:30:48 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris.Orbidans@idega.lv">Maris.Orbidans</a>
 * @version $Revision: 1.2 $
 */
public class PersonalInfo
{

    private String firstname;
    private String surname;
    private String middlename;
    private String postcode;
    private String city;
    private String personalId;
    private String address;

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String name)
    {
        this.firstname = name;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getMiddlename()
    {
        return middlename;
    }

    public void setMiddlename(String middlename)
    {
        this.middlename = middlename;
    }

    public String getPersonalId()
    {
        return personalId;
    }

    public void setPersonalId(String personalId)
    {
        this.personalId = personalId;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    
    public String getAddress()
    {
        return address;
    }

    
    public void setAddress(String address)
    {
        this.address = address;
    }
}
