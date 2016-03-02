package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import java.util.List;

import net.thucydides.core.annotations.Step;

import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.OptySteps;
import com.ctl.it.qa.sfa.tools.pages.opty.LQCommercialOptyEditPage;
import com.ctl.it.qa.staf.xml.reader.IntContainerField;

@SuppressWarnings("serial")
public class LQCommercialOptySteps extends OptySteps {

	private LQCommercialOptyEditPage lqCommercialOptyEditPage;

	private void create_lq_commercial_opty(String accountName,
			List<IntContainerField> optyFields) {
		initiates_new_opportunity();
		selects_opty_type("LQ Commercial");
		shouldExist(lqCommercialOptyEditPage);
		fillFields(lqCommercialOptyEditPage,
				optyFields);
		lqCommercialOptyEditPage.openAccountLookupPage();
		shouldExist(lookUpPage);
		lookUpPage.searchAndSelectEntity(accountName);
		shouldExist(lqCommercialOptyEditPage);
		lqCommercialOptyEditPage.btn_save.click();
	}

	@Step
	public void creates_default_lq_commercial_opty() {
		create_lq_commercial_opty("DONT_USE_approved_commercial_account",
				get_data_for_page(lqCommercialOptyEditPage)
						.getMandatoryFieldsFromAllContainers());
	}
	
	@Step
	public void creates_lq_commercial_opty(String optyName, String accountName) {
		get_data_for_page(lqCommercialOptyEditPage).getField("tbx_opportunity_name").setValue(optyName);
		create_lq_commercial_opty(accountName,
				get_data_for_page(lqCommercialOptyEditPage)
						.getMandatoryFieldsFromAllContainers());
	}
	
	@Step
	public void creates_lq_commercial_opty_for_cie() {
		create_lq_commercial_opty("DONT_USE_approved_commercial_account",
				get_data_for_page(lqCommercialOptyEditPage)
						.getFieldsFromAllContainers());
		
	}
}
