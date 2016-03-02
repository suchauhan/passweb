package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;



public class DealInformationPage extends PasswebPage{

	@FindBy(xpath = "//div[contains(@id, 'grid')]/div[3]/div/table/tbody/tr/td[1]")
	public WebElementFacade tbx_compCompanyGrid;
	
	@FindBy(xpath = "//div[contains(@id, 'grid')]/div[3]/div/table/tbody/tr/td[2]")
	public WebElementFacade tbx_compPositionGrid;
	
	@FindBy(xpath = "//div[contains(@id,'summarycompetitor')]/parent::div/div[4]/div[2]/span/div/div/div[3]/div/div[1]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_compCompany;
	
	@FindBy(xpath = "//div[contains(@id,'summarycompetitor')]/parent::div/div[4]/div[2]/span/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_compPosition;
	
	@FindBy(xpath = "//label[text() = 'Pricing Analysis Support System (PASS)']")
	public WebElementFacade lbl_header;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return lbl_header;
	}

}
