package com.ctl.it.qa.passweb.tests.PasswebRegression;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebAddProductPage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.ProductConfigurationSteps;

import cucumber.api.java.en.Then;

public class TC04_CheckAddComponentForAllTypes {
	
	@Steps
	PasswebHomeSteps passWebHomeSteps;
	
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	PassWebAddProductPage addProductPage;
	
	
	@Then("^Component Row should get added$")
	public void component_Row_should_get_added()  {
	   
	 productConfigurationSteps.verifyaddcomponent();
	}

}
