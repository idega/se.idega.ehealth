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
        ReferralsValueObject vo1 = new ReferralsValueObject();
        vo1.setDate("zzzzzzzzzzz");
        vo1.setProvider("prov1");
        vo1.setUnit("unit1");
        ReferralsValueObject vo2 = new ReferralsValueObject();
        vo2.setDate("aaaaaaaaaa");
        vo2.setProvider("prov2");
        vo2.setUnit("unit2");
        referrals = new ArrayList();
        referrals.add(vo1);
        referrals.add(vo2);
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
