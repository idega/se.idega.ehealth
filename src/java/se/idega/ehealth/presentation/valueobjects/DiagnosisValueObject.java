package se.idega.ehealth.presentation.valueobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import se.idega.ehealth.presentation.constants.EhealthConstants;


public class DiagnosisValueObject
{
    private String name;
    private Date date;
    private String doctor;
    private String unit;
    
    public String getStrDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(EhealthConstants.DATE_FORMAT_SHORT);
        return sdf.format(date);        
    }
    
    
    public void setStrDate(String strDate)
    {        
    }    
    
    public Date getDate()
    {
        return date;
    }
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public String getDoctor()
    {
        return doctor;
    }
    
    public void setDoctor(String doctor)
    {
        this.doctor = doctor;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
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
