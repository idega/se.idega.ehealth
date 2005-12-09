package se.idega.ehealth.presentation;

import javax.faces.FactoryFinder;
import javax.faces.application.ApplicationFactory;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.text.Text;
import org.apache.myfaces.component.html.ext.HtmlDataTable;

/**
 * 
 * <p>
 * TODO Maris_O Describe Type PersonalInformation
 * </p>
 *  Last modified: $Date: 2005/12/09 12:43:55 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris_O@idega.com">Maris_O</a>
 * @version $Revision: 1.5 $
 */
public class Referrals extends IWBaseComponent
{
    private static Log log = LogFactory.getLog(Referrals.class);

    public void initializeContent()
    {         
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        HtmlForm form = (HtmlForm)facesContext.getApplication().createComponent(HtmlForm.COMPONENT_TYPE);
        
        // <div class="form_style">
        
        Text t = new Text();
        t.addToText("<div class='form_style'><p>Här kan man ligga in lite informationstext om det skulle vara ngt viktigt meddelande man vill nå ut med. Här kan man ligga in lite informationstext omdet skulle vara ngt viktigt meddelande man vill nå ut med. Här kan man ligga in lite informationstext om det skulle vara ngt viktigt meddelande manvill nå ut med.</p>");
        form.getChildren().add(t);        
               
        // table headers
        HtmlGraphicImage img1 = new HtmlGraphicImage();
        img1.setAlt("");
        img1.setStyleClass("table_bullet");
        img1.setUrl("/style/table_header_bullet.gif");
        
        HtmlGraphicImage img2 = new HtmlGraphicImage();
        img2.setAlt("");
        img2.setStyleClass("table_bullet");
        img2.setUrl("/style/table_header_bullet.gif");
        
        HtmlGraphicImage img3 = new HtmlGraphicImage();
        img3.setAlt("");
        img3.setStyleClass("table_bullet");
        img3.setUrl("/style/table_header_bullet.gif");        
        
        HtmlOutputText textDate = new HtmlOutputText();
        textDate.setValue("Datum ");
        HtmlOutputText hcareUnit = new HtmlOutputText();
        hcareUnit.setValue("Vardenhet ");
        HtmlOutputText hcGiver = new HtmlOutputText();
        hcGiver.setValue("Vardgivare ");
        
        HtmlPanelGroup header1 = new HtmlPanelGroup();
        HtmlPanelGroup header2 = new HtmlPanelGroup();
        HtmlPanelGroup header3 = new HtmlPanelGroup();
        
        header1.getChildren().add(textDate);
        header1.getChildren().add(img1);
        header2.getChildren().add(hcareUnit);
        header2.getChildren().add(img2);
        header3.getChildren().add(hcGiver);
        header3.getChildren().add(img3);                
        
        HtmlPanelGrid headtable = new HtmlPanelGrid();        
        headtable.setCellpadding("0");
        headtable.setCellspacing("0");
        headtable.setColumns(3);        
        headtable.setStyleClass("person_table header");
        headtable.setColumnClasses("table_bullet");
        headtable.getChildren().add(header1);
        headtable.getChildren().add(header2);
        headtable.getChildren().add(header3);
        form.getChildren().add(headtable);
        
        // div class="cc-iframe">
        
        t = new Text();
        t.addToText("<div class='cc-iframe'>");
        form.getChildren().add(t);        
        
        // person_table_iframe
        
        ApplicationFactory factory = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);       
        
        
        HtmlDataTable table2 = (HtmlDataTable)facesContext.getApplication().createComponent(HtmlDataTable.COMPONENT_TYPE);        
        
        table2.setCellpadding("0");
        table2.setCellspacing("0");
        table2.setStyleClass("person_table_iframe");
        table2.setRowClasses("odd,even");
        table2.setColumnClasses("first,middle,last");
        table2.setRows(2);
        table2.setVar("referral");
        
                                
        ValueBinding vb = factory.getApplication().createValueBinding("#{ReferralsBean.referrals}");        
                       
        table2.setValueBinding("value",vb);
        
        HtmlOutputText colDate = new HtmlOutputText();
        colDate.setValueBinding("value",factory.getApplication().createValueBinding("#{referral.date}"));

        HtmlOutputText colProvider = new HtmlOutputText();
        colProvider.setValueBinding("value",factory.getApplication().createValueBinding("#{referral.provider}"));
        
        HtmlOutputText colUnit = new HtmlOutputText();
        colUnit.setValueBinding("value",factory.getApplication().createValueBinding("#{referral.unit}"));
        
        UIColumn columnComponent1 = new UIColumn();
        UIColumn columnComponent2 = new UIColumn();
        UIColumn columnComponent3 = new UIColumn();
        
        /*
        HtmlCommandLink link = (HtmlCommandLink)facesContext.getApplication().createComponent(HtmlCommandLink.COMPONENT_TYPE);
              
        colDate.getChildren().add(link);*/
        
        columnComponent1.getChildren().add(colDate);
        columnComponent2.getChildren().add(colUnit);
        columnComponent3.getChildren().add(colProvider);
        
        table2.getChildren().add(columnComponent1);
        table2.getChildren().add(columnComponent2);
        table2.getChildren().add(columnComponent3);        
        
        table2.setRowOnClick("this.bgColor='#5683B2'");
        table2.setRowOnMouseOver("this.bgColor='#5683B2'");

        table2.getAttributes().put("rowOnMouseOver", "this.bgColor='#5683B2'");
        table2.getAttributes().put("rowOnMouseOut","this.bgColor='#5683B2'");        
        
        
        form.getChildren().add(table2);
        
        // person_table detailed

        HtmlDataTable table3 = new HtmlDataTable();
        table3.setCellpadding("0");
        table3.setCellspacing("0");
        table3.setRowClasses("odd,even");
        table3.setStyleClass("person_table detailed");
        
        form.getChildren().add(table3);        
        
        // </div>
        t = new Text();
        t.addToText("</div>");
        form.getChildren().add(t);
        
        // </div>
        t = new Text();
        t.addToText("</div>");
        form.getChildren().add(t);
        
        add(form);
    }


    
   
}
