package com.ctl.it.qa.sfa.tools.pages.common;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class RevenueUpliftPage extends SfaPage {
	
	@FindBy(css="input[value='No'][type='button']")
	public WebElementFacade btn_uplift_no;

	@FindBy(xpath="//div[contains=text=),'uplift in revenue')]")
	public WebElementFacade lbl_uplift;

	@FindBy(css="input[value='Yes'][type='button']")
	public WebElementFacade btn_uplift_yes;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lbl_uplift;
	}
}
