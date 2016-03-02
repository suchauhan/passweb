package com.ctl.it.qa.sfa.tools.pages.opty;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class LiteQuoteEditPage extends SfaPage {

	@FindBy(css = "select[id *= 'theProductTypeLabel']")
	public WebElementFacade ddl_product_type;

	@FindBy(css = "input[id *= 'theMRR']")
	public WebElementFacade tbx_mrc;

	@FindBy(css = "input[id *= 'theOTC']")
	public WebElementFacade tbx_otc;

	@FindBy(css = "select[id *= 'theContractTypeLabel']")
	public WebElementFacade ddl_contract_type_name;

	@FindBy(css = "input[id *= 'theTerm']")
	public WebElementFacade tbx_term;

	@FindBy(css = "input[id *= 'theCommit']")
	public WebElementFacade tbx_commitment;

	@FindBy(css = "input[value = 'Save Changes']")
	public WebElementFacade btn_save_changes;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_product_type;
	}
}
