package se.idega.ehealth.presentation.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.component.html.HtmlOutputText;
import se.idega.ehealth.presentation.valueobjects.ContactsValueObject;
import se.idega.ehealth.presentation.valueobjects.ReferralsValueObject;

import se.idega.ehealth.business.dataprovider.DataProvider;
import se.idega.ehealth.business.dataprovider.DataProviderFactory;

import se.idega.ehealth.presentation.lib.Utils;
import se.idega.ehealth.presentation.lib.ValueObjectComparator;

public class ContactsBean
{
    private DataProvider provider;
    
    private String sort = "date";
    private boolean ascending = true;
    private ContactsValueObject[] elements;

    public boolean getAscending()
    {
        return ascending;
    }

    public void setAscending(boolean ascending)
    {
        this.ascending = ascending;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public ContactsBean()
    {
        DataProviderFactory f = new DataProviderFactory();
        provider = f.createDataProvider();                
    }

    public ContactsValueObject[] getElements()
    {
        String personId = Utils.readPersonId();
        
        elements = provider.readContacts(personId);
        
        String sortCol = sort;
        
        if (sort.equals("strDate"))
        {
            sortCol = "date";
        }
        
        ValueObjectComparator cmp = new ValueObjectComparator(sortCol,ascending);
        Arrays.sort(elements,cmp);
        
        return elements;
    }

    public void setElements(ContactsValueObject[] referrals)
    {
        this.elements = referrals;
    }
}
