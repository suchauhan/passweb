package com.ctl.it.qa.passweb.tests.PasswebRegression;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.UserSteps;
import com.ctl.it.qa.sfa.tools.pages.common.HomePage;
import com.ctl.it.qa.staf.Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefinition {

	@Steps
	UserSteps endUser;
	HomePage homePage;

	// ********************** GIVEN METHODS **************************

	@Given("^I am logged in as a \"([^\"]*)\" user in SFA$")
	public void i_am_logged_in_as_a_user_in_SFA(String userType) {
		String url = Page.envData.getFieldValue("sfa-url");
		Serenity.setSessionVariable("url").to(url);
		Serenity.setSessionVariable("user_type").to(userType);
		endUser.is_in_sfa_login_page(url);
		endUser.logs_in_as(userType);
	}

	@Given("^I am logged in as a \"([^\"]*)\" user in SSO$")
	public void i_am_logged_in_as_a_user_in_SSO(String userType) {
		String url = Page.envData.getFieldValue("sso-console");
		Serenity.setSessionVariable("url").to(url);
		Serenity.setSessionVariable("user_type").to(userType);
		System.out.println(userType);
		endUser.is_in_sso_login_page(url);
		endUser.logs_in_sso_as(userType);
	}
	

	// ********************** WHEN METHODS **************************

	@When("^I log back as a \"([^\"]*)\" user in SFA$")
	public void i_log_back_as_a_user_in_SFA(String userType) {
		endUser.logs_out();
		endUser.logs_in_as(userType);
		Serenity.setSessionVariable("user_type").to(userType);
	}

	@When("^I log back as a \"([^\"]*)\" user in SSO$")
	public void i_log_back_as_a_user_in_SSO(String userType) {
		endUser.logs_out();
		endUser.logs_in_sso_as(userType);
		Serenity.setSessionVariable("user_type").to(userType);
	}

	// ********************** THEN METHODS **************************

	@Then("I should be on home page")
	public void I_should_be_on_home_page() {
		homePage.shouldExist(homePage);
	}
}
