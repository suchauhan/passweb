package com.ctl.it.qa.passweb.tests.PasswebRegression;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebAddProductPage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PassErrorCheckSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.ProductConfigurationSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC03_AddProductsForAllTypes {
	
	@Steps
	PasswebHomeSteps passWebHomeSteps;
	
	@Steps
	PassErrorCheckSteps passErrorChkSteps;
	
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	PassWebAddProductPage addProductPage;
	
	
	@Then("^I should be able to add products$")
	public void i_should_be_able_to_add_products() {
	   
		//passErrorChkSteps.checkErrors();
		//productConfigurationSteps.checkAddProducts();
	}
	
	@When("^I select Entity and Product and apply the configuration on it.$")
	public void i_select_entity_and_product_for_adding_it(DataTable entityProductTable)
	{
		productConfigurationSteps.addProductandapplyConfigurations(entityProductTable);
	}
	
	@When("^I select Entity and Product and adding it manually$")
	public void i_select_entity_and_product_and_adding_it_manually(DataTable entityProductTable)
	{
		productConfigurationSteps.addProductmanually(entityProductTable);
	}
}
