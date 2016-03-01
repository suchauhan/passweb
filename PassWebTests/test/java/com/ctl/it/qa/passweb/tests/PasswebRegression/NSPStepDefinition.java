package com.ctl.it.qa.passweb.tests.PasswebRegression;

import static org.hamcrest.MatcherAssert.assertThat;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.NSPViewPage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.NSPSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NSPStepDefinition {

	@Steps
	NSPSteps nspSteps;
	NSPViewPage nspViewPage;

	// ********************** WHEN METHODS **************************//

	@When("^I open the NSP$")
	public void i_open_nsp() {
		//String nspNumber = Serenity.sessionVariableCalled("nsp_number").toString();
		String nspNumber = "NSP-176336";
		nspSteps.open_record("Non-Standard Pricing", nspNumber);
		nspSteps.getDealMetricesvalues();
		//nspSteps.click_addpricing();
	}

	@When("^I move NSP to \"([^\"]*)\" status$")
	public void select_nsp_status_as_big_machine_quote(String nspStatus) {
		nspSteps.move_nsp_status_to(nspStatus);
	}

	// ********************** THEN METHODS **************************//

	@Then("^NSP step should be moved to \"([^\"]*)\"$")
	public void nsp_step_should_be_moved_to(String nspStep) {
		assertThat("NSP Step is not moved to " + nspStep,
				nspViewPage.lbl_nsp_step.getText().equals(nspStep));
	}

}
