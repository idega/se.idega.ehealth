package se.idega.ehealth.presentation.valueobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import se.idega.ehealth.presentation.constants.EhealthConstants;


public class ReferralsValueObject
{
    private Date date;
    private String unit="";
    private String provider="";
    private String type="";
    
    public String getStrDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(EhealthConstants.DATE_FORMAT_SHORT);
        return sdf.format(date);        
    }
    
    
    public void setStrDate(String strDate)
    {        
    }    
    
    
    public String getType()
    {
        return type;
    }

    
    public void setType(String type)
    {
        this.type = type;
    }

    
    public Date getDate()
    {
        return date;
    }
    
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public String getProvider()
    {
        return provider;
    }
    
    public void setProvider(String provider)
    {
        this.provider = provider;
    }
    
    public String getUnit()
    {
        return unit;
    }
    
    public void setUnit(String unit)
    {
        this.unit = unit;
    }
    
    
}
