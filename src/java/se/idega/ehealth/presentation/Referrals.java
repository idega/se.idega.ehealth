package se.idega.ehealth.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.faces.FactoryFinder;
import javax.faces.application.ApplicationFactory;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;
import javax.faces.model.ListDataModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import se.idega.ehealth.business.dataprovider.DataProvider;
import se.idega.ehealth.business.dataprovider.DataProviderFactory;
import se.idega.ehealth.business.dataprovider.valueobj.PersonalInfo;
import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.IWContext;
import com.idega.presentation.text.Break;
import com.idega.presentation.text.Strong;
import com.idega.presentation.text.Text;




/**
 * 
 * <p>
 * TODO Maris_O Describe Type PersonalInformation
 * </p>
 *  Last modified: $Date: 2005/11/23 15:44:10 $ by $Author: mariso $
 * 
 * @author <a href="mailto:Maris_O@idega.com">Maris_O</a>
 * @version $Revision: 1.2 $
 */
public class Referrals extends IWBaseComponent
{
    private static Log log = LogFactory.getLog(Referrals.class);

    public void initializeContent()
    { 
        
        // <div class="form_style">
        
        Text t = new Text();
        t.addToText("<div class='form_style'><p>H�r kan man ligga in lite informationstext om det skulle vara ngt viktigt meddelande man vill n� ut med. H�r kan man ligga in lite informationstext omdet skulle vara ngt viktigt meddelande man vill n� ut med. H�r kan man ligga in lite informationstext om det skulle vara ngt viktigt meddelande manvill n� ut med.</p>");
        add(t);        
               
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
        add(headtable);
        
        // div class="cc-iframe">
        
        t = new Text();
        t.addToText("<div class='cc-iframe'>");
        add(t);        
        
        // person_table_iframe
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HtmlDataTable table2 = (HtmlDataTable)facesContext.getApplication().createComponent(HtmlDataTable.COMPONENT_TYPE);
        
        UIColumn columnComponent1 = new UIColumn();
        UIColumn columnComponent2 = new UIColumn();
        UIColumn columnComponent3 = new UIColumn();
        
        table2.getChildren().add(columnComponent1);
        table2.getChildren().add(columnComponent2);
        table2.getChildren().add(columnComponent3);
        
        table2.setCellpadding("0");
        table2.setCellspacing("0");
        table2.setStyleClass("person_table_iframe");
        table2.setRowClasses("odd,even");
        table2.setColumnClasses("first,middle,last");
        //table2.setRows(2);
        
        ApplicationFactory factory = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
        ValueBinding vb = factory.getApplication().createValueBinding("#{ReferralsBean.referrals}");        
                       
        table2.setValueBinding("value",vb);
        
        add(table2);
        
        // person_table detailed

        HtmlDataTable table3 = new HtmlDataTable();
        table3.setCellpadding("0");
        table3.setCellspacing("0");
        table3.setRowClasses("odd,even");
        table3.setStyleClass("person_table detailed");
        
        add(table3);        
        
        // </div>
        t = new Text();
        t.addToText("</div>");
        add(t);        
        
        // </div>
        t = new Text();
        t.addToText("</div>");
        add(t);
    }


    
   
}
