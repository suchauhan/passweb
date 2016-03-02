package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import static org.hamcrest.MatcherAssert.assertThat;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class OptyProductCatalogPage extends SfaPage {

	@FindBy(css = "input[value = 'Return to Opportunity']")
	public WebElementFacade btn_return_to_opportunity;

	@FindBy(css = "input[value = 'Add Selected']")
	public WebElementFacade btn_add_selected;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_return_to_opportunity;
	}

	public void selectProduct(String productName, String region) {
		WebElementFacade cbx_product = null;
		if (region.equals("QCC")) {
			cbx_product = find(By.xpath("//td[text() = '" + productName
					+ "']/following-sibling::td[2]/div/input"));
		} else if (region.equals("QC")) {
			cbx_product = find(By.xpath("//td[text() = '" + productName
					+ "']/following-sibling::td[1]/div/input"));
		}
		assertThat("Unable to find product '" + productName
				+ "' in the region '" + region + "'", cbx_product != null);
		cbx_product.click();
		btn_add_selected.click();
	}
}
