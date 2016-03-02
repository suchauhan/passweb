package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;



import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

@SuppressWarnings("serial")
public abstract class PasswebSteps extends Steps {

	PassWebHomePage passWebHomePage;
	
	public List<List<String>> errorList = new ArrayList<List<String>>();
	public List<String> errorMessage = new ArrayList<String>();
	public List<String> errorProduct = new ArrayList<String>();
	public List<String> warningOrError = new ArrayList<String>();
	
	int warnings = 0;
	int errorsBeforeRefresh = 0;
	int errorsAfterRefresh = 0;
	
	
	
	public void getNSP(String nspNumber)
	{
		passWebHomePage.tbx_nspNumber.type(Page.commonData.getFieldValue(nspNumber).toString());
	}
	
	public void switchTOWindow()
	{
		for(String winHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(winHandle);
		}
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
	
	public void switchToParenWindow(String parentwin)
	{
		System.out.println(parentwin);
		for(String winHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(parentwin);
		}
	}
	
	
	public void logOut()
	{
		if(passWebHomePage.btn_logout.isVisible())
		{
			passWebHomePage.btn_logout.click();
			passWebHomePage.switchtoWindow();
			if(getDriver().findElement(By.xpath("//span[text() = 'Confirm Logout']")).isDisplayed())
			{
				System.out.println("Title is displayed");
				passWebHomePage.logoutOptionYes.click();;
			}
			
		}
	}
	
	public void expandProduct(String product)
	{
		WebElement lnk_ExpandPro= getDriver().findElement(By.xpath("//div[starts-with(@id, 'dealsummary')]//div[starts-with(@id, 'grid')]//div[starts-with(@id, 'gridview')]//div[contains(@id, '"+product+"')]/div"));
		if(isElementPresent("//div[contains(@id,'"+product+"')]//following::table/tbody/tr[1]/td[1]/div[contains(text(),'Total')]"))
		{
			System.out.println("In if statement of Expand Product");
			lnk_ExpandPro.click();
			getDriver().findElement(By.xpath("//div[contains(@id,'"+product+"')]//following::tr[1]/td[1]")).click();
			
			System.out.println("Clicked row item");
			waitABit(3000);
		}
		else
		{
			System.out.println("In else statement of Expand Product");
			//lnk_ExpandPro.click();
			//System.out.println("Clicked + sign");
			getDriver().findElement(By.xpath("//div[contains(@id,'"+product+"')]//following::tr[1]/td[1]")).click();
			System.out.println("Clicked row item");
			waitABit(3000);
			
		}
	}
	
	public boolean isProductPresent(String elementPath)
	{
		try{
		getDriver().findElement(By.xpath(elementPath));
		return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Error for "+elementPath+" "+e);
			return false;
		}
	}
	
	public boolean isElementPresent(String elementPath)
	{
		
		try{
		getDriver().findElement(By.xpath(elementPath));
		return true;
		}
		catch(NoSuchElementException ex)
		{
			System.out.println(ex);
			return false;
		}
		
	}
	
	
	public void switchtoFrame(String frame) {
		getDriver().switchTo().window(getDriver().getWindowHandle());
		getDriver().switchTo().frame(frame);
	}
	
	public void closeBrowser(){
		getDriver().close();
	}
	
	public void clickButton(String btn_name)
	{
		getDriver().findElement(By.xpath("//span[text() = '"+btn_name+"']")).click();
		
	}
	
	public void selectListOption(String option)
	{
		getDriver().findElement(By.xpath("//a[text() = '"+option+"]")).click();
	}
	
	

}
