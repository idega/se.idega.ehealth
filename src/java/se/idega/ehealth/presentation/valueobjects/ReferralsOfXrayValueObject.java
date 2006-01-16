package se.idega.ehealth.presentation.valueobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import se.idega.ehealth.presentation.constants.EhealthConstants;


public class ReferralsOfXrayValueObject
{
    private String typeOfExamination;
    private String expertOpinion;
    private String textOfRequest;
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
    
    public String getExpertOpinion()
    {
        return expertOpinion;
    }
    
    public void setExpertOpinion(String expertOpinion)
    {
        this.expertOpinion = expertOpinion;
    }
    
    public String getTextOfRequest()
    {
        return textOfRequest;
    }
    
    public void setTextOfRequest(String textOfRequest)
    {
        this.textOfRequest = textOfRequest;
    }
    
    public String getTypeOfExamination()
    {
        return typeOfExamination;
    }
    
    public void setTypeOfExamination(String typeOfExamination)
    {
        this.typeOfExamination = typeOfExamination;
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
