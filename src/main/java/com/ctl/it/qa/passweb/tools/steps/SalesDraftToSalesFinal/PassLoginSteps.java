package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;


import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;


//import com.ctl.it.qa.passweb.tools.pages.PassWebHomePage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.LoginPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.*;

@SuppressWarnings("serial")
public class PassLoginSteps extends PasswebSteps{
	

	LoginPage passLoginPage;
	PassWebHomePage passWebHomePage;
	
	public PassLoginSteps() {
		// TODO Auto-generated constructor stub
		 initialize();
	}
	
	@Step
	public void openWebPage()
	{
		String url = Page.envData.getFieldValue("passweb-url");
		System.out.println(url);
		Serenity.setSessionVariable("url").to(url);
		passLoginPage.openAt(url);
		passLoginPage.maximize();
		passLoginPage.shouldExist(passLoginPage);
			
	}
	
	@Step
	public void enterCredentials(String userType) throws Exception
	{
		passLoginPage.doLogin(userType);
		waitABit(3000);
		passLoginPage.shouldExist(passWebHomePage);
		System.out.println("user is on homepage");
		
	}
	
	
}
