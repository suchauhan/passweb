package com.ctl.it.qa.sfa.tools.pages.opty;

import static org.hamcrest.MatcherAssert.assertThat;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class ManageProductsPage extends SfaPage {

	@FindBy(xpath = "//span[. = 'Manage Products Page for ']")
	public WebElementFacade lbl_manage_products_page_for;

	@FindBy(css = "input[value = 'Return to Opportunity']")
	public WebElementFacade btn_return_to_opportunity;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lbl_manage_products_page_for;
	}

	public void navigateToLiteQuoteEditPage(String productName) {
		String actualProduct = null;
		WebElementFacade lnk_create_lite = null;
		int productCount = findAll(
				By.xpath("//table[contains(@id, 'ProductsTable')]/tbody/tr"))
				.size();
		for (int counter = 1; counter <= productCount; counter++) {
			actualProduct = find(
					By.xpath("//table[contains(@id, 'ProductsTable')]/tbody/tr["
							+ counter + "]/td[2]")).getText();
			if (actualProduct.equalsIgnoreCase(productName)) {
				lnk_create_lite = find(By
						.xpath("//table[contains(@id, 'ProductsTable')]/tbody/tr["
								+ counter + "]/td[1]/a[. = 'Create Lite']"));
				break;
			}
		}
		assertThat("Unable to find create lite link for product '"
				+ productName + "'", lnk_create_lite != null);
		lnk_create_lite.click();
	}
}
