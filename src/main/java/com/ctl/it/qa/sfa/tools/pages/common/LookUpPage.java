package com.ctl.it.qa.sfa.tools.pages.common;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class LookUpPage extends SfaPage {
	
	@FindBy(id = "lksrch")
	public WebElementFacade tbx_search;

	@FindBy(name = "go")
	public WebElementFacade btn_go;
	
	private String frm_search = "searchFrame";
	
	private String frm_result = "resultsFrame";
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		switchToFrame(frm_search);
		return tbx_search;
	}

	public void searchAndSelectEntity(String searchValue) {
		this.shouldExist(this);
		switchToFrame(frm_search);
		tbx_search.type(searchValue);
		switchToFrame(frm_search);
		btn_go.click();
		switchToFrame(frm_result);
		if (isResultFound(searchValue)) {
			switchToFrame(frm_result);
			find(getResultLink(searchValue)).click();
		}
		switchToParentWindow();
	}
	
	public boolean isResultFound(String searchValue) {
		boolean isFound = false;
		withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(getResultLink(searchValue));
		if (find(getResultLink(searchValue)).isPresent()) {
			isFound = true;
		}
		return isFound;
	}
	
	private By getResultLink(String searchValue) {
		return By.xpath("//a[. = '" + searchValue + "']");
	}
}
