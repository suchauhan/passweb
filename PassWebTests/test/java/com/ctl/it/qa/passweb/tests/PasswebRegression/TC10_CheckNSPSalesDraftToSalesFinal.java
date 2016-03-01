package com.ctl.it.qa.passweb.tests.PasswebRegression;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebAddProductPage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.ProductConfigurationSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class TC10_CheckNSPSalesDraftToSalesFinal {
	
	@Steps
	PasswebHomeSteps passWebHomeSteps;
	
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	PassWebAddProductPage addProductPage;


	@Then("^I should be able to configure and move NSP to Sales Final$")
	public void i_should_be_able_to_configure_and_move_NSP_to_Sales_Final() throws Throwable {
	   productConfigurationSteps.applyConfiguration();
	}
	
}
