package com.ctl.it.qa.sfa.tools.pages.opty;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class ProductSelectionForOptyPage extends SfaPage {

	@FindBy(id = "search")
	public WebElementFacade tbx_by_keyword;

	@FindBy(id = "PricebookEntrycol0")
	public WebElementFacade ddl_by_field_filter;

	@FindBy(id = "PricebookEntryoper0")
	public WebElementFacade ddl_by_field_equals_to_paramter;

	@FindBy(id = "PricebookEntryfval0")
	public WebElementFacade tbx_product;

	@FindBy(id = "save_filter_PricebookEntry")
	public WebElementFacade btn_search;

	@FindBy(id = "01uF000000LJoI4")
	public WebElementFacade cbx_product_iq_sip;

	@FindBy(name = "edit")
	public WebElementFacade btn_select;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_select;
	}

	public void chooseProductFromList() {
		this.shouldExist(this);
		cbx_product_iq_sip.waitUntilVisible();
		cbx_product_iq_sip.waitUntilClickable();
		cbx_product_iq_sip.click();
		btn_select.click();
	}
}