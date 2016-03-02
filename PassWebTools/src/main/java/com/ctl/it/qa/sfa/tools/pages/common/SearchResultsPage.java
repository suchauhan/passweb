package com.ctl.it.qa.sfa.tools.pages.common;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class SearchResultsPage extends SfaPage {

	@FindBy(id = "secondSearchText")
	public WebElementFacade tbx_search;

	@FindBy(id = "secondSearchButton")
	public WebElementFacade btn_search_again;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tbx_search;
	}

	private By getResultXPath(String objectName, String searchValue) {

		if (objectName.equals("Order Requests")) {
			return By.xpath("//td[text()='" + searchValue
					+ "']/preceding-sibling::td/a");
		} else {
			return By
					.xpath("//table[@summary = '"
							+ objectName
							+ "']/parent::div/following-sibling::div[1]/..//*[text() = '"
							+ searchValue + "']");
		}
	}

	private void selectObject(String objectName) {
		find(By.xpath("//span[. = '" + objectName + "']")).click();
	}

	public void searchObject(String objectName, String searchValue) {
		selectObject(objectName);
		tbx_search.type(searchValue);
		btn_search_again.click();
	}

	private boolean isResultFound(String objectName, String searchValue) {
		boolean isFound = false;
		withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(
				getResultXPath(objectName, searchValue));
		if (find(getResultXPath(objectName, searchValue)).isPresent()) {
			isFound = true;
		}
		return isFound;
	}

	public void selectResult(String objectName, String searchValue) {
		assertThat("No result was found when searched " + objectName
				+ "with value '" + searchValue + "'",
				isResultFound(objectName, searchValue));
		find(getResultXPath(objectName, searchValue)).click();
	}
}
