package com.ctl.it.qa.passweb.tests.NSPSalesFlow;
/*package com.ctl.it.qa.passweb.tests.NSPSalesFlow;


import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.pages.PassWebHomePage;
import com.ctl.it.qa.passweb.tools.steps.NSPSalesFlow.PassErrorCheckSteps;
import com.ctl.it.qa.passweb.tools.steps.NSPSalesFlow.PassLoginSteps;
import com.ctl.it.qa.passweb.tools.steps.NSPSalesFlow.PassNSPSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NspSalesFlowStepDefinition {
	
	PassWebHomePage passWebHomePage;
	@Steps
	PassLoginSteps passLoginSteps;
	@Steps
	PassNSPSteps passNSP;
	@Steps
	PassErrorCheckSteps passErrorCheck;
	
	@Given("^I am logging in as \"([^\"]*)\" user in Passweb$")
	public void i_am_logging_in_as_user_in_Passweb(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		passLoginSteps.openWebPage();
    	passLoginSteps.enterCredentials(arg1);
		System.out.println("login");
	}

	@Then("^I should be able to load NSP and add Competitor Info$")
	public void i_should_be_able_to_load_NSP_and_add_Competitor_Info() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		passWebHomePage.shouldExist(passWebHomePage);
		passNSP.searchNSP();
		passNSP.loadNSP();
		//passNSP.addCompetitorInfo();
		System.out.println("competitor");
	}
	@When("^I select Entity and Product$")
	public void i_select_Entity_and_add_Product(DataTable entityProductTable) throws Throwable {
		//List<List<String>> list =entityProductTable.raw();
		passNSP.getEntityAndProducts(entityProductTable);
		passErrorCheck.checkErrors();
		passNSP.submitToPom("Cancel");
	}
	
	@Then("^Product should get added$")
	public void product_should_get_added() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hello");
	}

	@Then("^I am populating the product configuration fields on configuration page$")
	public void i_am_populating_the_product_configuration_fields_on_configuration_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hello");
	}

	@Then("^Products should get configured$")
	public void products_should_get_configured() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Hello");
	}

}
*/