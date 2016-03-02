package com.ctl.it.qa.sfa.tools.pages.opty;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LQCommercialOptyEditPage extends OptyEditPage {

	@FindBy(xpath = "//td[. = 'LQ Commercial']")
	public WebElementFacade lbl_opportunity_record_type;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// We need to send val_opportunityRecordType element as well in future
		return lbl_opportunity_edit;
	}
}
