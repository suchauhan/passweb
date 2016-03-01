package com.ctl.it.qa.passweb.tests.PasswebRegression;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.ProductConfigurationSteps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC01_CheckKeyFieldsInMassUpdate {
	
	@Steps
	PasswebHomeSteps passWebHomeSteps;
	
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	@Given("^I have loaded the NSP after searching it$")
	public void i_have_loaded_the_NSP_after_searching_it()  {

		passWebHomeSteps.searchNSP();
		passWebHomeSteps.loadNSP();
		
	}

	@When("^I select Entity and Product for adding it and configure it$")
	public void i_select_Entity_and_Product_for_adding_it(DataTable arg1) {
	  
		//productConfigurationSteps.fetchEntityProducts(arg1);
		productConfigurationSteps.addProductandapplyConfigurations(arg1);
		}

	@Then("^I should be able to compare MassUpdate and UpdateKeyfields for the product$")
	public void i_should_be_able_to_compare_MassUpdate_and_UpdateKeyfields_for_the_product()  {
	    // Write code here that turns the phrase above into concrete actions
		  productConfigurationSteps.addRedirectandCompare();
		//productConfigurationSteps.checkMassUpdateUsageForProducts();
	}

}
