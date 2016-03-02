package com.ctl.it.qa.sfa.tools.pages.common;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class HomePage extends SfaPage {

	@FindBy(xpath="//a[@title = 'Home Tab - Selected']")
	public WebElementFacade tab_home;
	
	@FindBy(css="img[title = 'All Tabs']")
	public WebElementFacade img_all_tabs;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tab_home;
	}
}
