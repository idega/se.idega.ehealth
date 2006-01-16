package se.idega.ehealth.presentation;

import javax.faces.FactoryFinder;
import javax.faces.application.ApplicationFactory;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.text.Text;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.apache.myfaces.custom.sortheader.HtmlCommandSortHeader;

/**
 * 
 * <p>
 * TODO Maris_O Describe Type PersonalInformation
 * </p>
 *  Last modified: $Date: 2006/01/16 09:35:12 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris_O@idega.com">Maris_O</a>
 * @version $Revision: 1.5 $
 */
public class HealthcareContacts extends IWBaseComponent
{
    private static Log log = LogFactory.getLog(HealthcareContacts.class);

    public void initializeContent()
    {         
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ApplicationFactory factory = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
        
        HtmlForm form = (HtmlForm)facesContext.getApplication().createComponent(HtmlForm.COMPONENT_TYPE);
        // <div class="form_style">
        
        Text t = new Text();
        t.addToText("<div class='form_style'><p>Här kan man ligga in lite informationstext om det skulle vara ngt viktigt meddelande man vill nå ut med. Här kan man ligga in lite informationstext omdet skulle vara ngt viktigt meddelande man vill nå ut med. Här kan man ligga in lite informationstext om det skulle vara ngt viktigt meddelande manvill nå ut med.</p>");
        form.getChildren().add(t);        
        
        // table
        
        HtmlDataTable table2 = (HtmlDataTable)facesContext.getApplication().createComponent(HtmlDataTable.COMPONENT_TYPE);        
        table2.setCellpadding("0");
        table2.setCellspacing("0");
        
        table2.setStyleClass("person_table");        
        table2.setCellpadding("0");
        table2.setCellspacing("0");        
        table2.setRowClasses("odd,even");
        table2.setColumnClasses("first,middle,last");
        table2.setVar("element");        
                                
        ValueBinding vb = factory.getApplication().createValueBinding("#{ContactsBean.elements}");        
                       
        table2.setValueBinding("value",vb);
        
        
        HtmlCommandSortHeader header1 = new HtmlCommandSortHeader();
        header1.setColumnName("strDate");
        header1.setValue("Datum ");
        header1.setArrow(true);
        
        HtmlCommandSortHeader header2 = new HtmlCommandSortHeader();
        header2.setColumnName("provider");
        header2.setValue("Vardenhet ");
        header1.setArrow(true);
        
        HtmlCommandSortHeader header3 = new HtmlCommandSortHeader();
        header3.setColumnName("unit") ;
        header3.setValue("Vardgivare ");
        header1.setArrow(true);
                
        HtmlGraphicImage img1 = new HtmlGraphicImage();
        img1.setAlt("");
        img1.setStyleClass("table_bullet");
        img1.setUrl("/idegaweb/style/table_header_bullet.gif");
        
        HtmlGraphicImage img2 = new HtmlGraphicImage();
        img2.setAlt("");
        img2.setStyleClass("table_bullet");
        img2.setUrl("/idegaweb/style/table_header_bullet.gif");
        
        HtmlGraphicImage img3 = new HtmlGraphicImage();
        img3.setAlt("");
        img3.setStyleClass("table_bullet");
        img3.setUrl("/idegaweb/style/table_header_bullet.gif");                
        
        HtmlPanelGroup headerGroup1 = new HtmlPanelGroup();
        HtmlPanelGroup headerGroup2 = new HtmlPanelGroup();
        HtmlPanelGroup headerGroup3 = new HtmlPanelGroup();
        
        headerGroup1.getChildren().add(header1);
        headerGroup1.getChildren().add(img1);
        headerGroup2.getChildren().add(header2);
        headerGroup2.getChildren().add(img2);
        headerGroup3.getChildren().add(header3);
        headerGroup3.getChildren().add(img3);       
        
        
        HtmlOutputText colDate = new HtmlOutputText();
        colDate.setValueBinding("value",factory.getApplication().createValueBinding("#{element.strDate}"));

        HtmlOutputText colProvider = new HtmlOutputText();
        colProvider.setValueBinding("value",factory.getApplication().createValueBinding("#{element.provider}"));
        
        HtmlOutputText colUnit = new HtmlOutputText();
        colUnit.setValueBinding("value",factory.getApplication().createValueBinding("#{element.unit}"));
        
        UIColumn columnComponent1 = new UIColumn();
        UIColumn columnComponent2 = new UIColumn();
        UIColumn columnComponent3 = new UIColumn();
        
        columnComponent1.setHeader(headerGroup1);
        columnComponent2.setHeader(headerGroup2);
        columnComponent3.setHeader(headerGroup3);         
        
        columnComponent1.getChildren().add(colDate);
        columnComponent2.getChildren().add(colUnit);
        columnComponent3.getChildren().add(colProvider);
        
        table2.setValueBinding("sortColumn",factory.getApplication().createValueBinding("#{ContactsBean.sort}"));
        table2.setValueBinding("sortAscending",factory.getApplication().createValueBinding("#{ContactsBean.ascending}"));
        table2.setSortAscending(true);
        
        table2.getChildren().add(columnComponent1);
        table2.getChildren().add(columnComponent2);
        table2.getChildren().add(columnComponent3);        
        
        table2.setRowOnClick("this.bgColor='#5683B2'");
        table2.setRowOnMouseOver("this.bgColor='#5683B2'");      
        
        form.getChildren().add(table2);
               
        add(form);
    }
   
}
