package com.ctl.it.qa.passweb.tests.PasswebRegression;


import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.Steps;








import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.DealInformationSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.NSPSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PassErrorCheckSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PassLoginSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.ProductConfigurationSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NspSalesFlowStepDefinition {
	
	PassWebHomePage passWebHomePage;
	
	@Steps
	PassLoginSteps passLoginSteps;

	@Steps
	PassErrorCheckSteps passErrorCheck;
	@Steps
	PasswebHomeSteps passWebHomeSteps;
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	@Steps
	DealInformationSteps dealInfoSteps;
	
	@Steps
	PasswebSteps passwebsteps;
	
	@Steps
	NSPSteps nspsteps;


	@Then("^I should be in PASS and load the NSP$")
	public void i_should_be_able_to_load_NSP_and_add_Competitor_Info() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		passWebHomePage.shouldExist(passWebHomePage);
		passWebHomeSteps.searchNSP();
		passWebHomeSteps.loadNSP();
		
		System.out.println("competitor");
	}
	
	@Then("^I should be in PASS and create the NSP in PASS$")
	public void i_should_be_in_PASS_and_create_the_NSP_in_PASS()
	{
		passWebHomeSteps.createNSPInPASS();
	}
	
	@When("^I add the competitor info$")
	public void i_add_the_competitor_info()
	{
		dealInfoSteps.addCompetitorInfo();
	}
	@When("^I select Entity and Product$")
	public void i_select_Entity_and_add_Product(DataTable entityProductTable) throws Throwable {
		//List<List<String>> list =entityProductTable.raw();
		//productConfigurationSteps.applyConfigurations(entityProductTable);
		//passErrorCheck.checkErrors();
		//passWebHomeSteps.submitToPom("Cancel");
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
