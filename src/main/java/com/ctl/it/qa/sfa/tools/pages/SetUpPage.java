package com.ctl.it.qa.sfa.tools.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SetUpPage extends SfaPage {

	@FindBy(id = "DevTools_icon")
	public WebElementFacade lnk_create;

	@FindBy(id = "ExternalStrings_font")
	public WebElementFacade lnk_custom_label;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lnk_create;
	}

}
