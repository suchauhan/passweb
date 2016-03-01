package com.ctl.it.qa.passweb.tests.login;

import net.thucydides.core.annotations.Steps;





import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PassLoginSteps;


import com.ctl.it.qa.staf.Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PassWebLoginStepDefinition {
	
	PassWebHomePage passWebHomePage;
	@Steps
	PassLoginSteps passLoginSteps;
	
	
	
	
	@Given("^I am logged in as \"([^\"]*)\" user in Passweb$")
	public void i_am_logged_in_as_a_user_in_Passweb(String userType) throws Exception  {
	    // Write code here that turns the phrase above into concrete actions
		
		//String url = Page.envData.getFieldValue("sso-console");
		//System.out.println(url);
		passLoginSteps.openWebPage();
		passLoginSteps.enterCredentials(userType);
    	
	    
	}

	@Then("^I should be at the home page$")
	public void i_should_be_at_the_home_page() throws Throwable {
		passWebHomePage.shouldExist(passWebHomePage);
	}

}
