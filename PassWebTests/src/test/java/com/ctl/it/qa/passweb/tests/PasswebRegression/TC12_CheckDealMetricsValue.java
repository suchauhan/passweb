package com.ctl.it.qa.passweb.tests.PasswebRegression;

import java.util.HashMap;

import org.openqa.selenium.remote.server.handler.SwitchToWindow;

import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.steps.PomDraftToPomFinal.POMDealSummarySteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PassLoginSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.NSPSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebHomeSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.UserSteps;

import cucumber.api.java.en.When;

public class TC12_CheckDealMetricsValue {

	@Steps
	POMDealSummarySteps dealsummarysteps;
	@Steps
	NSPSteps nspSteps;
	@Steps
	UserSteps endUser;
	@Steps
	PassLoginSteps passLoginSteps;
	
	
	
	
//	@Given("^I am logged in as a \"([^\"]*)\" user in SSO$")
//	public void i_am_logging_in_as_a_in_SSO(String userType) {
//		String url = Page.envData.getFieldValue("sso-console");
//		//String url = Page.envData.getFieldValue("passweb-url");
//		Serenity.setSessionVariable("url").to(url);
//		Serenity.setSessionVariable("user_type").to(userType);
//		endUser.is_in_sso_login_page(url);
//		endUser.logs_in_sso_as(userType);
//	}
	
	
	
	@When("^I open the Deal Summary Page in PASS$")
	public void i_open_the_deal_summary_page_in_PASS()
	{
		
		dealsummarysteps.moveToDealSummaryPage();
		waitABit("1000");
		dealsummarysteps.getDealMetricsvalues();
		dealsummarysteps.comparedealmetricsvalueswithSFAvalues();
		dealsummarysteps.moveBackToSFA();
		nspSteps.getDealMetricesvalues();
		
	}
 
	@When("^I get the dealmetrices of NSP in SFA$")
	public void I_get_the_dealmetrices_of_NSP_in_SFA() {
		nspSteps.getDealMetricesvalues();
		nspSteps.getwinid();
		nspSteps.moveTOPass();
		}


	private void waitABit(String string) {
		// TODO Auto-generated method stub
		
	}
		
}

