package com.ctl.it.qa.sfa.tools.pages.opty;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class ManageOrdersPage extends SfaPage {

	@FindBy(xpath = "//input[@value='Initiate Orders']")
	public WebElementFacade btn_initiate_orders;

	@FindBy(xpath = "//input[@value='Create Manual Order']")
	public WebElementFacade btn_create_manual_order;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_create_manual_order;
	}

	public void initiateOrderConfiguration(String productName) {
		this.shouldExist(this);
		WebElementFacade lnk_do_now = find(By.xpath("//td[contains(text(),'"
				+ productName + "')]/preceding-sibling::td[2]/a"));
		lnk_do_now.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable()
				.click();
	}
}
