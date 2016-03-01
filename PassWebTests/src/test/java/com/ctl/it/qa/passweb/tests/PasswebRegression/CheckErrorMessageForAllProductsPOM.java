package com.ctl.it.qa.passweb.tests.PasswebRegression;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.steps.PomDraftToPomFinal.POMErrorCheckSteps;

import cucumber.api.java.en.When;

public class CheckErrorMessageForAllProductsPOM {
	
	@Steps
	POMErrorCheckSteps pomerrorchecksteps;

	@When("^I am checking the errors and correcting it as POM$")
	public void i_am_checking_the_errors_and_correcting_it() throws Throwable {
		
		pomerrorchecksteps.dealWithErrorsPOM();
	    
	}
	
}
