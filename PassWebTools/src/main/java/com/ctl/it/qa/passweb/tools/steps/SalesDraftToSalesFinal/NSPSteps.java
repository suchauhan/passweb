package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;

import net.thucydides.core.annotations.Step;

import com.ctl.it.qa.sfa.tools.pages.common.SearchResultsPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.NSPEditPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.NSPViewPage;
import com.ctl.it.qa.sfa.tools.pages.opty.OptyViewPage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.SfaSteps;

@SuppressWarnings("serial")
public class NSPSteps extends SfaSteps {
	NSPEditPage nspEditPage;
	SearchResultsPage searchResultsPage;
	NSPViewPage nspViewPage;
	OptyViewPage optyViewPage;
	
	public static HashMap<String, String> mapSFA = new HashMap<>();
	public static String winid;
	
	@Step
	public void move_nsp_status_to(String nspStatus) {
		nspViewPage.shouldExist(nspViewPage);
		nspViewPage.btn_edit.click();
		nspEditPage.shouldExist(nspEditPage);
		nspEditPage.ddl_nsp_status.selectByValue(nspStatus);
		nspEditPage.btn_save.click();
	}
	
	@Step
	public void moveTOPass()
	{
		nspViewPage.btn_addPricingDetals.click();
		switchtoWindow();
		waitABit(15000);
	}
	
	@Step
	public void add_new_NSP()
	{
		optyViewPage.initiateNewNSP();
		//nspEditPage.fillMandatoryFields(nspEditPage);
		nspEditPage.getDataforNSP();
		nspEditPage.get_offer_requested_date();
		waitABit(1000);
		nspEditPage.btn_save.click();
		waitABit(2000);
		//nspEditPage.tbx_offer_requested_date.sendKeys(nspEditPage.selectdate());	
	}
	
	public void getwinid()
	{
		winid = getDriver().getWindowHandle();
		System.out.println(winid);
	}
	
	@Step
	public String getNSPnumber()
	{
		return nspViewPage.lbl_nsp_number.getText();
	}
	
	
	@Step
	public void getDealMetricesvalues()
	{
		
		System.out.println("entering method");
		List<WebElement> rows = getDriver().findElements(By.xpath("//h3[text()='Deal Metrics Summary']/../following-sibling::div/table/tbody/tr"));
		System.out.println(rows.size());
	
		for(int i =1; i<= rows.size();i++)
		{
	       List<WebElement> cols = getDriver().findElements(By.xpath("//h3[text()='Deal Metrics Summary']/../following-sibling::div/table/tbody/tr["+i+"]/th"));
	         for (int j=1;j<= cols.size();j++)
	         {
	        	 String dealMetrices = getDriver().findElement(By.xpath("//h3[text()='Deal Metrics Summary']/../following-sibling::div/table/tbody/tr["+i+"]/th["+j+"]")).getText();
	        	 String dealMetricesvalue = getDriver().findElement(By.xpath("//h3[text()='Deal Metrics Summary']/../following-sibling::div/table/tbody/tr["+i+"]/td["+j+"]/span")).getText();
	        	 mapSFA.put(dealMetrices,dealMetricesvalue); 
	        	  
	        	  
	         }
	         
		}
		  
		System.out.println(mapSFA.entrySet());
		
		
	}
}
