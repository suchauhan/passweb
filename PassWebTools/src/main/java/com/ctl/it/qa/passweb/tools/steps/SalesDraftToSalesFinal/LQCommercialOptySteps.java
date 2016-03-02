package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import java.util.List;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.LQCommercialOptyEditPage;
import com.ctl.it.qa.staf.xml.reader.IntContainerField;

@SuppressWarnings("serial")
public class LQCommercialOptySteps extends OptySteps {

	private LQCommercialOptyEditPage lqCommercialOptyEditPage;

	private void create_lq_commercial_opty(String accountName,
			List<IntContainerField> optyFields) {
		initiates_new_opportunity();
		selects_opty_type("LQ Commercial");
		lqCommercialOptyEditPage.shouldExist(lqCommercialOptyEditPage);
		lqCommercialOptyEditPage.fillFields(lqCommercialOptyEditPage,
				optyFields);
		lqCommercialOptyEditPage.openAccountLookupPage();
		lookUpPage.shouldExist(lookUpPage);
		lookUpPage.searchAndSelectEntity(accountName);
		lqCommercialOptyEditPage.shouldExist(lqCommercialOptyEditPage);
		lqCommercialOptyEditPage.btn_save.click();
	}

	@Step
	public void creates_default_lq_commercial_opty() {
		create_lq_commercial_opty(envData.getContainer("RefreshData")
				.getFieldValue("approved_commercial_account"),
				get_data_for_page(lqCommercialOptyEditPage)
						.getMandatoryFieldsFromAllContainers());
	}

	@Step
	public boolean is_commercial_opty_created() {
		boolean isCreated = false;
		if (optyViewPage.isExist(optyViewPage)
				&& Serenity
						.sessionVariableCalled("opty_name")
						.toString()
						.equals(get_data_for_page(lqCommercialOptyEditPage)
								.getFieldValue("tbx_opportunity_name"))) {
			isCreated = true;
		}
		return isCreated;
	}
}
