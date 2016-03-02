package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class OptyEditPage extends SfaPage {

	// ################# Main Section ###################
	@FindBy(xpath = "//h2[@class='mainTitle'][. = 'Opportunity Edit']")
	public WebElementFacade lbl_opportunity_edit;

	@FindBy(id = "opp3")
	public WebElementFacade tbx_opportunity_name;

	@FindBy(id = "opp4_lkwgt")
	public WebElementFacade img_account_name;

	@FindBy(xpath = "//label[text() = 'Sub-Type']/parent::td/following-sibling::td[1]/div/span/select")
	public WebElementFacade ddl_sub_type;

	@FindBy(xpath = "//label[text() = 'Close Date']/parent::td/following-sibling::td[1]/div/span/span/a")
	public WebElementFacade lnk_close_date;

	@FindBy(id = "opp11")
	public WebElementFacade ddl_stage;

	@FindBy(id = "ForecastCategoryName")
	public WebElementFacade ddl_forecast_category;

	@FindBy(xpath = "//label[text()='Expected Turn-Up Date']/../../following-sibling::td/span/input")
	public WebElementFacade tbx_expected_turn_up_date;

	@FindBy(id = "00NF0000008rbfi")
	public WebElementFacade ddl_is_ctl_network_being_ordered;

	@FindBy(id = "opp14")
	public WebElementFacade tbx_description;

	@FindBy(css = "input[value = ' Save ']")
	public WebElementFacade btn_save;
	
	@FindBy(id = "00NF0000009X7eE")
	public WebElementFacade ddl_is_this_CQL_Opportunity;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lbl_opportunity_edit;
	}

	public void openAccountLookupPage() {
		setParentHandle();
		img_account_name.click();
		waitForChildWindowToAppear();
		switchToChildWindow();
	}
}
