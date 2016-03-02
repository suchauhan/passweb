package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.DealSummaryPage;

//import com.ctl.it.qa.passweb.tools.pages.PassWebHomePage;



import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.ErrorCheckPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;

import groovy.transform.stc.PickAnyArgumentHint;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings("serial")
public class PassErrorCheckSteps extends PasswebSteps {

	ErrorCheckPage errorPage;
	PassWebHomePage passHomePage;
	DealSummaryPage dealSummaryPage;
	@Steps
	DealSummarySteps dealSummarySteps;
	
	@Steps
	PasswebHomeSteps passWebHomeSteps;
	
	@Steps
	ProductConfigurationSteps productConfigurationSteps;
	
	List<List<String>> errorList = new ArrayList<List<String>>();
	List<String> errorMessage = new ArrayList<String>();
	List<String> errorProduct = new ArrayList<String>();
	List<String> warningOrError = new ArrayList<String>();
	
	int warnings = 0;
	int errorsBeforeRefresh = 0;
	int errorsAfterRefresh = 0;
	
	@Step
	public void refreshErrors()
	{
		errorPage.btn_refreshErrors.click();
		waitABit(3000);
	}
	
	public void checkErrors()
	{
		
		passHomePage.btn_actions.click();
		passHomePage.ddl_errorCheck.click();
		waitABit(1000);
		countErrors();
		
	}
	public int countErrors()
	{
		int sizeOfErrWar = getDriver().findElements(By.xpath("//div[contains(@id, 'errorspanel')]/div[starts-with(@id, 'grid')]/div[starts-with(@id, 'grid')]//tr")).size();
		int errors = 0;
		String fieldCount = "";
		String message = "";
		String productName = "";
		String warningOrErr = "";
		for(int count = 1; count<=sizeOfErrWar;count++)
		{
			if(getDriver().findElement(By.xpath("//div[contains(@id, 'errorspanel')]/div[starts-with(@id, 'grid')]/div[starts-with(@id, 'grid')]//tr["+count+"]/td[1]/div")).getText().equals("Error"))
			{
				errors++;
				warningOrErr = getDriver().findElement(By.xpath("//div[contains(@id, 'errorspanel')]/div[starts-with(@id, 'grid')]/div[starts-with(@id, 'grid')]//tr["+count+"]/td[1]/div")).getText();
				message = getDriver().findElement(By.xpath("//div[contains(@id, 'errorspanel')]/div[starts-with(@id, 'grid')]/div[starts-with(@id, 'grid')]//tr["+count+"]/td[3]/div")).getText();
				fieldCount = getDriver().findElement(By.xpath("//div[contains(@id, 'errorspanel')]/div[starts-with(@id, 'grid')]/div[starts-with(@id, 'grid')]//tr["+count+"]/td[4]/div")).getText();
				productName = getDriver().findElement(By.xpath("//div[contains(@id, 'errorspanel')]/div[starts-with(@id, 'grid')]/div[starts-with(@id, 'grid')]//tr["+count+"]/td[2]/div")).getText();
				System.out.println(productName+ "contains following error: "+message+" for "+fieldCount+" fields");
				errorMessage.add(message);
				errorProduct.add(productName);
				warningOrError.add(warningOrErr);
				
			}
		}
		System.out.println("Total Errors: "+errors);
		System.out.println("Total Warnings: "+warnings);
		errorList.add(errorMessage);
		errorList.add(errorProduct);
		errorList.add(warningOrError);
		System.out.println(errorList);
		return errors;
	}
	
	@Step
	public void dealWithErrorsSales()
	{
		checkErrors();
		getProductAndMsg();
		refreshErrors();
		
	}
	public void getProductAndMsg()
	{
		for(int i=0; i<errorList.get(0).size();i++)
		{
			
			String product = errorList.get(1).get(i);
			if(isProductPresent("//label[text() = '"+product+"']"))
			{
				System.out.println("Product Page is already displayed");
				waitABit(2000);
				System.out.println("Handling error(If): "+errorList.get(0).get(i));
				errorPage.errorMessageCheck(errorList.get(1).get(i), errorList.get(0).get(i));

			}
			else
			{
				System.out.println("Product Page is not displayed");
				dealSummarySteps.pickaddedProduct(errorList.get(1).get(i));
				System.out.println("Handling error (Else): "+errorList.get(0).get(i));
				errorPage.errorMessageCheck(errorList.get(1).get(i), errorList.get(0).get(i));

				
			}
		}
	}
	
}
