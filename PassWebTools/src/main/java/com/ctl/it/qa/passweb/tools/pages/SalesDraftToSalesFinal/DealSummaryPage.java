package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

public class DealSummaryPage extends PasswebPage{
	

	
	@FindBy(xpath = "//label[text()='Deal Summary']")
	public WebElementFacade lbl_dealsummarypage;
	
	@FindBy(xpath = "//span[text()='Products']")
	public WebElementFacade btn_Products;
	
	@FindBy(xpath = "//span[text()= 'Deal Summary']")
	public WebElementFacade ddl_DealSummary;
	
	@FindBy(xpath= "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/table/tbody/tr[1]/td[1]/div/div")
    public WebElementFacade cbx_configrow;
	
	@FindBy(xpath = "//div[starts-with(@id,'componentgrid')]//div[contains(@id,'headercontainer')]//div[contains(@id,'gridcolumn')]//span")
	public WebElementFacade cbx_selectAll;
	
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
	
	@FindBy(xpath = "//div[contains(@id, 'products')]/div/div[starts-with(@id,'componentgrid')]/div[starts-with(@id,'gridview')]/div[6]/table/tbody/tr[1]/td[2]/input")
	public WebElementFacade tbx_CNDCID;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return lbl_dealsummarypage;
	}
	
		

}
