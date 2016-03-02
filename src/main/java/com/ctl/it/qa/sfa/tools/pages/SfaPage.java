package com.ctl.it.qa.sfa.tools.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.staf.Page;

public abstract class SfaPage extends Page {

	@FindBy(id = "phSearchButton")
	public WebElementFacade btn_search;

	@FindBy(xpath = "//input[@title='Continue']")
	public WebElementFacade btn_continue;

	@FindBy(id = "userNav-arrow")
	public WebElementFacade lnk_user_name_old;

	@FindBy(xpath = "//b[@class = 'zen-selectArrow']")
	public WebElementFacade lnk_user_name_new;

	@FindBy(css = "a[title='Logout']")
	public WebElementFacade lnk_logout;

	@FindBy(xpath = "//a[@id='helpBubbleCloseX']/img")
	public WebElementFacade img_close;

	@FindBy(css = "table[class = 'list']")
	public WebElementFacade tbl_search_result;

	@FindBy(css = "input[value*='New Service Location']")
	public WebElementFacade btn_new_service_location;

	@FindBy(name="new")
	public WebElementFacade btn_new;

	@FindBy(css = "input[id*='SaveReturn']")
	public WebElementFacade btn_save_return;

	@FindBy(css = "input[value = 'Save']")
	public WebElementFacade btn_save;
	
	@FindBy(css = "input[value = 'Next']")
	public WebElementFacade btn_next;

	@FindBy(css = "input[value = 'Edit']")
	public WebElementFacade btn_edit;

	@FindBy(css = "input[value = 'Order Summary']")
	public WebElementFacade btn_order_summary;
	
	@FindBy(xpath = "//li[@id='home_Tab']/a")
	public WebElementFacade lnk_home;
	
	@FindBy(xpath= "//span[contains(@class,'globalHeaderProfile')]/..")
	public WebElementFacade lbl_logged_in_user;

	@FindBy(css = "input[value='Submit to Order Processing']")
	public WebElementFacade btn_submit_to_order_processing;
	
	@FindBy(css = "input[value='Accept']")
	public WebElementFacade btn_accept;

	@FindBy(css = "input[value='Return']")
	public WebElementFacade btn_return;

	public void logout() {
		if (lnk_user_name_old.isPresent() && lnk_user_name_old.isEnabled()) {
			lnk_user_name_old.click();
		} else {
			lnk_user_name_new.click();
		}
		lnk_logout.click();
	}

	public void closePopUps() { // NO_UCD (unused code)
		closeHelpBubble();
	}

	private void closeHelpBubble() {
		if (img_close.isPresent()) {
			img_close.click();
		}
	}

	public void waitForResultTableToLoad() {
		tbl_search_result.isPresent();
		tbl_search_result.waitUntilPresent();
	}
	
	public void navigateToHomePage(){
		lnk_home.isPresent();
		lnk_home.click();
	}

	public void switchtoFrame(String frame) {
		getDriver().switchTo().window(getDriver().getWindowHandle());
		getDriver().switchTo().frame(frame);
	}
	
	public void closeBrowser(){
		getDriver().close();
	}
	
	
}
