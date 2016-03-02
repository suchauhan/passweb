package com.ctl.it.qa.sfa.tools.pages.common;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

public class SSOLoginPage extends SfaPage {

	public static IntDataContainer dataContainer;

	@FindBy(name = "user")
	public WebElementFacade tbx_user_name;

	@FindBy(name = "password")
	public WebElementFacade tbx_password;

	@FindBy(css = "input[value='Login']")
	public WebElementFacade btn_login;

	public SSOLoginPage() {
		initialize();
	}

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_login;
	}

	public void enterCredentials(String userType) {
		IntDataContainer dataContainer = envData.getContainer(
				this.getClass().getSimpleName()).getContainer(userType);
		tbx_user_name.type(dataContainer.getFieldValue("tbx_user_name"));
		tbx_password.type(dataContainer.getFieldValue("tbx_password"));
	}
}
