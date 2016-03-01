package com.ctl.it.qa.passweb.tests.PasswebRegression;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.ProductConfigurationSteps;


import cucumber.api.java.en.Then;

public class TC02_CanUseMassUpdateInAllTypes {

	@Steps
	PasswebHomeSteps passWebHomeSteps;
	
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	@Then("^I should be able to use mass update and populate values in fields for the product$")
	public void i_should_be_able_to_use_mass_update_and_populate_values_in_fields_for_the_product()  {
		productConfigurationSteps.checkMassUpdateUsageForProducts();
	}
	
}
