package com.ctl.it.qa.sfa.tools.pages.opty;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CPQCommercialOptyEditPage extends OptyEditPage {

	@FindBy(xpath = "//td[. = 'CPQ Commercial']")
	public WebElementFacade lbl_opportunity_record_type;
	
	@FindBy(xpath = "//label[contains(text(), 'Network / Hosting Opptys to be combined?')]/parent::*/parent::*/following-sibling::td/div/span/select")
	public WebElementFacade ddl_network_hosting_opptys_to_be_combined;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// We need to send val_opportunityRecordType element as well in future
		return lbl_opportunity_edit;
	}
}
