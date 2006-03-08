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
    
    private String receivingUnit="";
    private String analysisType="";
    private String analysisResult="";
    private String refInterval="";
    private String sendingUnit="";
    private String status="";
    private String comments="";    
    
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


    
    public String getAnalysisResult()
    {
        return analysisResult;
    }


    
    public void setAnalysisResult(String analysisResult)
    {
        this.analysisResult = analysisResult;
    }


    
    public String getAnalysisType()
    {
        return analysisType;
    }


    
    public void setAnalysisType(String analysisType)
    {
        this.analysisType = analysisType;
    }


    
    public String getComments()
    {
        return comments;
    }


    
    public void setComments(String comments)
    {
        this.comments = comments;
    }


    
    public String getReceivingUnit()
    {
        return receivingUnit;
    }


    
    public void setReceivingUnit(String receivingUnit)
    {
        this.receivingUnit = receivingUnit;
    }


    
    public String getRefInterval()
    {
        return refInterval;
    }


    
    public void setRefInterval(String refInterval)
    {
        this.refInterval = refInterval;
    }


    
    public String getSendingUnit()
    {
        return sendingUnit;
    }


    
    public void setSendingUnit(String sendingUnit)
    {
        this.sendingUnit = sendingUnit;
    }


    
    public String getStatus()
    {
        return status;
    }


    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    
}
