package com.ctl.it.qa.sfa.tools.pages.opty;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class ContactRolesForOptyPage extends SfaPage {
	
	@FindBy(id = "primary0")
	public WebElementFacade rbn_primary_first;

	@FindBy(id = "role0")
	public WebElementFacade ddl_role_first;
	
	@FindBy(css = "input[value = ' Save ']")
	public WebElementFacade btn_save;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_role_first;
	}
}
