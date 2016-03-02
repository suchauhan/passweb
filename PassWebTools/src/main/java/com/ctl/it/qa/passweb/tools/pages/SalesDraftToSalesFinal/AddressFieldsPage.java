package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class AddressFieldsPage extends PasswebPage {

	@FindBy(xpath = "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/table/tbody/tr[1]/td[8]/div")
	public WebElementFacade tbx_Streetgrid;
	
	@FindBy(xpath = "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/div[2]/table/tbody/tr[1]/td[2]/input")
	public WebElementFacade tbx_Street;
	
	@FindBy(xpath = "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/div[3]/table/tbody/tr[1]/td[2]/input")
	public WebElementFacade tbx_City;
	
	@FindBy(xpath = "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/div[4]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_State;
	
	@FindBy(xpath = "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/div[5]/table/tbody/tr[1]/td[2]/input")
	public WebElementFacade tbx_postalCode;
	
	@FindBy(xpath = "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/table/tbody/tr[1]/td[12]/div")
	public WebElementFacade tbx_CNDCGrid;
	
	@FindBy(xpath = "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/div[2]/table/tbody/tr[1]/td[2]/input")
	public WebElementFacade tbx_doubleClick;
	
	@FindBy(xpath = "//div[starts-with(@id,'componentgrid')]//div[contains(@id,'headercontainer')]//div[contains(@id,'gridcolumn')]//span")
	public WebElementFacade cbx_select;
	
	@FindBy(xpath ="//div[contains(text(), 'Please obtain a valid CNDC ID')]")
	public WebElementFacade lbl_errorMsg;
	
	@FindBy(xpath = "//div[contains(@id, 'messagebox')]//span[text() = 'OK']")
	public WebElementFacade btn_errorMsgOK;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getAddress(String product)
	{
		if(product.trim().equalsIgnoreCase("Metro Ethernet (LCTL)"))
		{
			waitABit(2000);
			tbx_Street.type("1060N MAIN ST");
			tbx_Street.sendKeys(Keys.TAB);
			tbx_City.type("CASPER");
			tbx_City.sendKeys(Keys.TAB);
			tbx_State.type("WY");
			tbx_State.sendKeys(Keys.TAB);
			tbx_postalCode.sendKeys("555555");
			//tbx_postalCode.sendKeys(Keys.TAB);
			cbx_select.click();
		}
	}
	
	public void doubleClickElement(WebElementFacade element)
	{
		Actions builder = new Actions(getDriver());
		Actions doubleClick = builder;
		doubleClick.doubleClick(element).build().perform();
		
	}

	public void populateAddress(WebElementFacade element, String product)
	{
		doubleClickElement(element);
		getAddress(product);
	}
	
	public void CNDCFieldValidation()
	{
		doubleClickElement(tbx_CNDCGrid);
		tbx_doubleClick.sendKeys("1234567");
		tbx_doubleClick.sendKeys(Keys.TAB);
		if(lbl_errorMsg.isDisplayed())
		{

			String errorMsg = lbl_errorMsg.getText();
			if(errorMsg.equals("CNDC ID: Please obtain a valid CNDC ID from your Sales Engineer or delete this line component."))
			{
				btn_errorMsgOK.click();
				System.out.println("Invalid CNDC entered, test case passed");
				
			}
		}
		else
		{
			System.out.println("Valid CNDC entered");
		}
	}
	
}
