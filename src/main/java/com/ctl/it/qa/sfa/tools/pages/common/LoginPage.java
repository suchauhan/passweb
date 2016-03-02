package com.ctl.it.qa.sfa.tools.pages.common;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

public class LoginPage extends SfaPage {

	@FindBy(id = "username")
	public WebElementFacade tbx_username;

	@FindBy(id = "password")
	public WebElementFacade tbx_password;

	@FindBy(id = "Login")
	public WebElementFacade btn_log_in_to_salesforce;

	@FindBy(xpath = "//span[. = 'CenturyLink SSO']")
	public WebElementFacade btn_centurylink_sso;

	public LoginPage() {
		initialize();
	}

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tbx_username;
	}

	public void enterCredentials(String userType) {
		IntDataContainer dataContainer = envData.getContainer(
				this.getClass().getSimpleName()).getContainer(userType);
		tbx_username.type(dataContainer.getFieldValue("tbx_username"));
		tbx_password.type(dataContainer.getFieldValue("tbx_password"));
	}
}