package se.idega.ehealth.presentation.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlOutputText;
import se.idega.ehealth.presentation.valueobjects.ReferralsValueObject;

public class ReferralsBean
{

    private String sort = "date";
    private boolean ascending = true;
    private List referrals;

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

    public ReferralsBean()
    {
        
    }

    public List getReferrals()
    {
        return referrals;
    }

    public void setReferrals(List referrals)
    {
        this.referrals = referrals;
    }
}
