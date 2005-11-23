package se.idega.ehealth.presentation.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlOutputText;


public class ReferralsBean
{
    
    private List referrals;
    
    
    public ReferralsBean()
    {
        
        HtmlOutputText t1 = new HtmlOutputText();
        t1.setValue("1111111111");
        HtmlOutputText t2 = new HtmlOutputText();
        t2.setValue("22222222222");
        HtmlOutputText t3 = new HtmlOutputText();
        t3.setValue("3333333333");
        HtmlOutputText t4 = new HtmlOutputText();
        t4.setValue("4444444444");
        HtmlOutputText t5 = new HtmlOutputText();
        t5.setValue("5555555555");
        HtmlOutputText t6 = new HtmlOutputText();
        t6.setValue("66666666666");
        
        referrals = new ArrayList();
        
        referrals.add(t1);
        referrals.add(t2);
        referrals.add(t3);
        referrals.add(t4);
        referrals.add(t5);
        referrals.add(t6);
        
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
