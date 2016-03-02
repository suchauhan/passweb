package com.ctl.it.qa.sfa.tools.pages.common;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class AllTabsPage extends SfaPage {
	
	@FindBy(xpath="//option[text()='All Tabs'][@selected='selected']")
	public WebElementFacade ddl_all_tabs;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_all_tabs;
	}

	public void openPage(String pageName) {
		find(By.cssSelector("img[title = '" + pageName + "']")).click();
	}
}
