package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;


import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.DealSummaryPage;

public class DealSummarySteps extends PasswebSteps {
	
	
	DealSummaryPage dealSummaryPage;
	
	@Steps
	DealSummarySteps dealSummarySteps;
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	@Step
	public void selectandConfigureAddedProduct(String product)
	{
		selectAddedProduct(product);
		productConfigurationSteps.configureProducts(product);
		waitABit(2000);
		pickaddedProduct(product);
	}
	public void selectAddedProduct(String product)
	{
		waitABit(5000);
		dealSummaryPage.cbx_selectAll.click();
		System.out.println(product);
		
	}
	@Step
	public void pickaddedProduct(String product)
	{
		dealSummaryPage.btn_Products.click();
		dealSummaryPage.ddl_DealSummary.click();
		expandProduct(product);
		waitABit(2000);
		//selectAddedProduct(product);
		
	}
	

}
