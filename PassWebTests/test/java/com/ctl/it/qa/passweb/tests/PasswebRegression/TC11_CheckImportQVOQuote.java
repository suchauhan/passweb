package com.ctl.it.qa.passweb.tests.PasswebRegression;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC11_CheckImportQVOQuote {

	@Steps
	PasswebHomeSteps passwebhome;
	
	@When("^I import the QVO Quote in Passweb$")
	public void I_import_the_QVO_Quote_in_Passweb()
	{
		passwebhome.importQVOQuote();
	}
	
	@Then("^I should be able import QVO Quote successfully$")
	public void i_should_be_able_import_QVO_Quote_successfully()
	{
		passwebhome.checkimportPPandQVOQuote_status();
	}
}
