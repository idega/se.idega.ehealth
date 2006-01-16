package se.idega.ehealth.presentation.valueobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import se.idega.ehealth.presentation.constants.EhealthConstants;


public class MedicinesValueObject
{
    private String name;
    private String dose;
    private Date startDate;
    private String doctor;
    private String unit;
    
    
    public String getStrStartDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(EhealthConstants.DATE_FORMAT_SHORT);
        return sdf.format(startDate);        
    }
    
    
    public void setStrStartDate(String strDate)
    {        
    }    
    
    public String getDoctor()
    {
        return doctor;
    }
    
    public void setDoctor(String doctor)
    {
        this.doctor = doctor;
    }
    
    public String getDose()
    {
        return dose;
    }
    
    public void setDose(String dose)
    {
        this.dose = dose;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
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
