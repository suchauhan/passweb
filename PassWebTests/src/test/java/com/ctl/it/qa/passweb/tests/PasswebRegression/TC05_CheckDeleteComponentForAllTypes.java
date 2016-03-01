package com.ctl.it.qa.passweb.tests.PasswebRegression;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebAddProductPage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.ProductConfigurationSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class TC05_CheckDeleteComponentForAllTypes {
	
	@Steps
	PasswebHomeSteps passWebHomeSteps;
	
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	PassWebAddProductPage addProductPage;
	
	
	
	@Then("^Component Row should get Deleted$")
	public void component_Row_should_get_Deleted() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   productConfigurationSteps.verifyDeleteComponent();	}

}
