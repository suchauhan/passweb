package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

public class LoginPage extends PassWebHomePage{

	
	@FindBy(xpath = ".//*[@id='UserName']")
	public WebElementFacade tbx_username;
	
	@FindBy(xpath = ".//*[@id='Password']")
	public WebElementFacade tbx_password;
	
	@FindBy(xpath = "//button[text() = 'Sign in']")
	public WebElementFacade btn_signin;
	
	@FindBy(xpath = "html/body/div[1]/div[1]/h2")
	public WebElementFacade lbl_heading;
	
	
	public LoginPage() {
		initialize();
	}
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return lbl_heading;
	}
	
	public void doLogin(String userType)
	{
		IntDataContainer dataContainer = envData.getContainer(
				this.getClass().getSimpleName());
		tbx_username.type(dataContainer.getContainer(userType).getFieldValue("tbx_passweb_username"));
		tbx_password.type(dataContainer.getContainer(userType).getFieldValue("tbx_passweb_password"));
		btn_signin.click();
	}
	

}
