package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import org.openqa.selenium.By;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.OpportunitiesPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.OptyProductCatalogPage;
import com.ctl.it.qa.sfa.tools.pages.SetUpPage;
import com.ctl.it.qa.sfa.tools.pages.common.LookUpPage;
import com.ctl.it.qa.sfa.tools.pages.common.SearchResultsPage;
import com.ctl.it.qa.sfa.tools.pages.common.SelectRecordTypePage;
import com.ctl.it.qa.sfa.tools.pages.opty.AddProductsForOptyPage;
import com.ctl.it.qa.sfa.tools.pages.opty.ContactRolesForOptyPage;
import com.ctl.it.qa.sfa.tools.pages.opty.CreditCheckPage;
import com.ctl.it.qa.sfa.tools.pages.opty.LiteQuoteEditPage;
import com.ctl.it.qa.sfa.tools.pages.opty.ManageOrdersPage;
import com.ctl.it.qa.sfa.tools.pages.opty.ManageProductsPage;
import com.ctl.it.qa.sfa.tools.pages.opty.OptyEditPage;
import com.ctl.it.qa.sfa.tools.pages.opty.OptyViewPage;
import com.ctl.it.qa.sfa.tools.pages.opty.ProductSelectionForOptyPage;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

@SuppressWarnings("serial")
public class OptySteps extends SfaSteps {

	OpportunitiesPage opportunitiesPage;
	SelectRecordTypePage selectRecordTypePage;
	SearchResultsPage searchResultsPage;
	OptyEditPage optyEditPage;
	OptyViewPage optyViewPage;
	ContactRolesForOptyPage contactRolesForOptyPage;
	OptyProductCatalogPage optyProductCatalogPage;
	ManageProductsPage manageProductsPage;
	LiteQuoteEditPage liteQuoteEditPage;
	ManageOrdersPage manageOrdersPage;
	AddProductsForOptyPage addProductsForOptyPage;
	ProductSelectionForOptyPage productSelectionForOptyPage;
	CreditCheckPage creditCheckPage;
	SetUpPage setUpPage;
	 LookUpPage lookUpPage;

	@Steps
	UserSteps userSteps;

	public void initiates_new_opportunity() {
		if (!opportunitiesPage.isExist(opportunitiesPage)) {
			userSteps.opens_page("Opportunities");
		}
		opportunitiesPage.shouldExist(opportunitiesPage);
		opportunitiesPage.btn_new.click();
	}

	public void selects_opty_type(String optyType) {

		if (selectRecordTypePage.isExist(selectRecordTypePage)) {
			selectRecordTypePage.shouldExist(selectRecordTypePage);
			selectRecordTypePage.ddl_record_type_of_new_record
					.selectByVisibleText(optyType);
			selectRecordTypePage.btn_continue.click();
		}
	}

	@Step
	public void add_contact_role_for_opty() {
		optyViewPage.shouldExist(optyViewPage);
		optyViewPage.btn_new_contact_roles.click();
		contactRolesForOptyPage.shouldExist(contactRolesForOptyPage);
		fillMandatoryFields(contactRolesForOptyPage);
		contactRolesForOptyPage.btn_save.click();
	}

	

	@Step
	public void adds_lq_lite_quote_to_opty(String productName, String region) {
		waitABit(4000);
		optyViewPage.shouldExist(optyViewPage);
		optyViewPage.btn_add_lq_product.click();
		optyProductCatalogPage.shouldExist(optyProductCatalogPage);
		optyProductCatalogPage.selectProduct(productName, region);
		manageProductsPage.shouldExist(manageProductsPage);
		manageProductsPage.navigateToLiteQuoteEditPage(productName);
		liteQuoteEditPage.shouldExist(liteQuoteEditPage);
		fillMandatoryFields(liteQuoteEditPage);
		waitABit(2000);
		fillAllFields(liteQuoteEditPage);
		//liteQuoteEditPage.btn_save_changes.click();
		getDriver().findElement(By.cssSelector("input[value = 'Save Changes']")).click();
		manageProductsPage.shouldExist(manageProductsPage);
		manageProductsPage.btn_return_to_opportunity.click();
	}

	@Step
	public void move_opty_to_stage(String stageName) {
		optyViewPage.shouldExist(optyViewPage);
		optyViewPage.btn_edit.click();
		optyEditPage.shouldExist(optyEditPage);
		optyEditPage.ddl_stage.selectByVisibleText(stageName);
		if (stageName.equals("Won")) {
			optyEditPage.tbx_expected_turn_up_date.type(OptyEditPage.getDate());
		}
		optyEditPage.btn_save.click();
	}

	

	public boolean isOptyViewPageExist() {
		return optyViewPage.isExist(optyViewPage);
	}

	@Step
	public boolean is_opty_open(String optyName) {

		boolean isOpen = false;
		optyViewPage.shouldExist(optyViewPage);
		if (optyViewPage.lbl_opportunity_name.getText().equals(optyName)) {
			isOpen = true;
		}
		return isOpen;
	}

	@Step
	public void add_product_to_opty(String productName) {
		optyViewPage.shouldExist(optyViewPage);
		optyViewPage.btn_add_product.click();
		productSelectionForOptyPage.shouldExist(productSelectionForOptyPage);
		IntDataContainer osData = get_data_for_page(productSelectionForOptyPage);
		osData.setFieldValue("tbx_product", productName);
		fillMandatoryFields(productSelectionForOptyPage);
		productSelectionForOptyPage.btn_search.click();
		productSelectionForOptyPage.chooseProductFromList();
		addProductsForOptyPage.shouldExist(addProductsForOptyPage);
		fillMandatoryFields(addProductsForOptyPage);
		addProductsForOptyPage.btn_save.click();
	}

	@Step
	public boolean is_product_type(String productType) {
		boolean isExpectedProductType = false;
		optyViewPage.shouldExist(optyViewPage);
		if (productType.equals(optyViewPage.lbl_product_type.getText())) {
			isExpectedProductType = true;
		}
		return isExpectedProductType;
	}


	@Step
	public boolean is_credit_status(String creditStatus) {
		boolean isExpectedCreditStatus = false;
		if (creditStatus.trim().equals(
				optyViewPage.lbl_response_message.getText().trim())) {
			isExpectedCreditStatus = true;
		}
		return isExpectedCreditStatus;
	}

	@Step
	public boolean is_credit_id(int id) {
		boolean isExpectedCreditStatus = false;
		if (id == getCreditApprovalId()) {
			isExpectedCreditStatus = true;
		}
		return isExpectedCreditStatus;
	}

	public boolean is_not_credit_status(String creditStatus) {
		boolean isExpectedCreditStatus = true;
		if (creditStatus.trim().equals(
				optyViewPage.lbl_credit_status.getText().trim())) {
			isExpectedCreditStatus = false;
		}
		return isExpectedCreditStatus;
	}

	public int getCreditApprovalId() {
		int credit_appoval_id = Integer
				.parseInt(optyViewPage.lbl_credit_approval_id.getText());

		return credit_appoval_id;
	}

}
