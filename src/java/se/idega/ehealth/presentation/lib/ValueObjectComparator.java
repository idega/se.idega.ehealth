package se.idega.ehealth.presentation.lib;

import java.util.Comparator;
import java.util.Date;
import org.apache.commons.beanutils.*;

public class ValueObjectComparator implements Comparator
{
    private String propertyName;
    private boolean ascending;

    public ValueObjectComparator(String name,boolean ascending)
    {
        propertyName = name;
        this.ascending = ascending;
    }

    public int compare(Object arg0, Object arg1)
    {
        Object value1;
        Object value2;
        try
        {
            value1 = PropertyUtils.getProperty(arg0,propertyName);
            value2 = PropertyUtils.getProperty(arg1,propertyName);
        } catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
        
        if (value1 instanceof String)
        {
            String obj1 = (String) value1;
            String obj2 = (String) value2;
            return ascending ? obj1.compareTo(obj2) : obj2.compareTo(obj1);
        }
        
        if (value1 instanceof Date)
        {
            Date obj1 = (Date) value1;
            Date obj2 = (Date) value2;
            return ascending ? obj1.compareTo(obj2) : obj2.compareTo(obj1);
        }
        throw new IllegalArgumentException("Unsupported bean property type "+value1.getClass().getName());
    }
    
    
    
}
