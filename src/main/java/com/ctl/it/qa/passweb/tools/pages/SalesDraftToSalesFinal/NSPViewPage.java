package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class NSPViewPage extends SfaPage {

	@FindBy(css = "span[id *= 'nsp_status']")
	public WebElementFacade lbl_nsp_status;

	@FindBy(css = "span[id *= 'nsp_step']")
	public WebElementFacade lbl_nsp_step;

	@FindBy(xpath = "//th[. = 'NSP Number']/following-sibling::td/span[contains(@id, 'Name')]")
	public WebElementFacade lbl_nsp_number;
	
	@FindBy(xpath = "//h3[text()='NSP Steps and Status']/preceding::input[@value='Add Pricing Details']")
	public WebElementFacade btn_addPricingDetals;
	
	

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lbl_nsp_status;
	}
}
