package com.ctl.it.qa.sfa.tools.pages.opty;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class OptyViewPage extends SfaPage {

	// ###################### Top Row Buttons Section ##########################
	@FindBy(xpath = "//h2[. = 'Opportunity Detail']")
	public WebElementFacade lbl_opportunity_detail;

	@FindBy(name = "manage_orders")
	public WebElementFacade btn_manage_orders;

	@FindBy(name = "add_lq_product")
	public WebElementFacade btn_add_lq_product;

	@FindBy(name = "addProd")
	public WebElementFacade btn_add_product;

	@FindBy(css = "input[value = ' Edit ']")
	public WebElementFacade btn_edit;

	// ###################### BigMachines Quotes Section //
	// ##########################

	@FindBy(xpath = "//input[@name='cpq_new_quote']")
	public WebElementFacade btn_new_quote;

	// ###################### Contact Roles Section //
	// ###############################

	@FindBy(name = "newRole")
	public WebElementFacade btn_new_contact_roles;

	@FindBy(xpath = "//div[contains(@id,'RelatedLineItemList_body')]/table/tbody/tr[2]/td[2]")
	public WebElementFacade lbl_product_type;

	@FindBy(xpath = "//td[text() = 'Opportunity Name']/following-sibling::td[1]")
	public WebElementFacade lbl_opportunity_name;

	@FindBy(xpath = "//td[text()='Opportunity ID']/following-sibling::td[1]/div")
	public WebElementFacade lbl_opportunity_id;

	@FindBy(xpath = "//div[@class='listHoverLinks']")
	public WebElementFacade lnk_hover_list;

	@FindBy(xpath = "//input[@title='New Non-Standard Pricing']")
	public WebElementFacade btn_new_non_standard_pricing;

	@FindBy(name = "credit_request")
	public WebElementFacade btn_submit_credit_check;

	@FindBy(name = "credit_pullback")
	public WebElementFacade btn_pullback_credit_check;

	@FindBy(id = "00NA0000005BwN0_ileinner")
	public WebElementFacade lbl_credit_status;

	@FindBy(id = "00NA0000006KFbL_ilecell")
	public WebElementFacade lbl_credit_approval_id;

	@FindBy(id = "00NA0000005BwPR_ileinner")
	public WebElementFacade lbl_response_message;
	
	

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lbl_opportunity_detail;
	}

	public void captureOpportunityDetails() {
		Serenity.setSessionVariable("opty_name").to(
				lbl_opportunity_name.getText());
		Serenity.setSessionVariable("opty_id").to(lbl_opportunity_id.getText());
	}

	public void initiateNewNSP() {
		this.shouldExist(this);
		lnk_hover_list.withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
		btn_new_non_standard_pricing.click();
	}

	public String getProductType() {
		return lbl_product_type.getText();
	}
	

}
