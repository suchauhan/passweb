package com.ctl.it.qa.passweb.tests.PasswebRegression;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

   
public class TC13_CheckCloneVersionForAllTypes {
	
	@Steps
	PasswebHomeSteps passwebhomesteps;

	@When("^I try to clone a NSP$")
	public void i_try_to_clone_a_NSP()
	{
		passwebhomesteps.doclone();
	}
	
	@Then("^I should be able to clone successfully$")
	public void i_should_be_able_to_clone_successfully()
	{
		passwebhomesteps.checkcloningoperation();
	}
	
	@When("^I move back to initial version of NSP$")
	public void i_move_back_to_initial_version_of_NSP()
	{
		passwebhomesteps.moveBacktoInitialVersion();
	}
}
