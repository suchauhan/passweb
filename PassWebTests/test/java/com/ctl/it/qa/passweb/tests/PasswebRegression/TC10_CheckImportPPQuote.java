package com.ctl.it.qa.passweb.tests.PasswebRegression;

import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.Serenity.SessionVariableSetter;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC10_CheckImportPPQuote {
	
	@Steps
	PasswebHomeSteps passwebhomesteps;

	@When("^I import the PP Quote of \"([^\"]*)\" in PASS$")
	public void i_import_the_PP_Quote(String Product){
		Serenity.setSessionVariable("Product").to(Product);
		passwebhomesteps.importPPQuote(Product);
	}
	
	@Then("^I should be able import PP Quote successfully$")
	public void i_should_be_able_import_PP_Quote_successfully()
	{
		passwebhomesteps.checkimportPPandQVOQuote_status();
	}
}
