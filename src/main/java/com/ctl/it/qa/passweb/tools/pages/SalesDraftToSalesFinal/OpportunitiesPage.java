package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class OpportunitiesPage extends SfaPage {

	@FindBy(xpath = "//h3[contains(text(), 'Recent Opportunities')]")
	public WebElementFacade lbl_recent_opportunities;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lbl_recent_opportunities;
	}
}
