package com.ctl.it.qa.passweb.tools.pages.PomDraftToPomFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.MassUpdateFieldsPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PasswebPage;


public class POMErrorCheckPage extends PasswebPage {
	
	MassUpdateFieldsPage massUpdateFieldsPage;
	
	@FindBy(xpath = "//span[text() = 'Refresh Errors']")
    public WebElementFacade btn_refreshErrors;
	
	@Override
    public WebElementFacade getUniqueElementInPage() {
           // TODO Auto-generated method stub
           return btn_refreshErrors;
    }
	
	
	 public void errorMessageCheckPOM(String product,String errorMsg)
     {
            System.out.println("Error Msg: "+ errorMsg + "ProductName: "+product);
            String error = errorMsg;
            switch(errorMsg)
            {
              
            case "Please enter a numeric Approved MRR." :
            	massUpdateFieldsPage.fillMassUpdateValue(product, "Approved MRR");
            	break;
            	
            case "Please enter a numeric Approved NRR." :
            	massUpdateFieldsPage.fillMassUpdateValue(product, "Approved NRR");
            
            }

}
}