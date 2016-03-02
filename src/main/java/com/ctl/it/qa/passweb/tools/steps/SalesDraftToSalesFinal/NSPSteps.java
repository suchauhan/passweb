package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;

import net.thucydides.core.annotations.Step;

import com.ctl.it.qa.sfa.tools.pages.common.SearchResultsPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.NSPEditPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.NSPViewPage;
import com.ctl.it.qa.sfa.tools.pages.opty.LiteQuoteEditPage;
import com.ctl.it.qa.sfa.tools.pages.opty.OptyViewPage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.SfaSteps;

@SuppressWarnings("serial")
public class NSPSteps extends SfaSteps {
	NSPEditPage nspEditPage;
	SearchResultsPage searchResultsPage;
	NSPViewPage nspViewPage;
	OptyViewPage optyViewPage;
	LiteQuoteEditPage liteQuoteEditPage;
	
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
	public void test()
	{
		System.out.println(get_data_for_page(liteQuoteEditPage).getFieldValue("ddl_product_type").toString());
		
	}
	
	@Step
	public void moveTOPass()
	{
		nspViewPage.btn_addPricingDetals.click();
		switchtoWindow();
		waitABit(20000);
	}
	
	@Step
	public void add_new_NSP()
	{
		optyViewPage.initiateNewNSP();
		fillMandatoryFields(nspEditPage,get_data_for_page(nspEditPage));
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
	
	public void getDataForNSP()
	{
		//get_data_for_page(nspEditPage).getMandatoryFieldsFromAllContainers();
		fillMandatoryFields(nspEditPage);
		/*nspEditPage.ddl_request_type.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_request_type"));
		nspEditPage.ddl_request_type.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_request_type"));
		waitABit(2000);
		nspEditPage.ddl_request_contract_term.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_request_contract_term"));
		waitABit(2000);
		nspEditPage.ddl_entities_providing_service.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_entities_providing_service"));
		waitABit(2000);
		nspEditPage.tbx_monthly_commit.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_monthly_commit"));
		waitABit(2000);
		nspEditPage.ddl_commit_type.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_commit_type"));  	
		waitABit(2000);
		nspEditPage.ddl_revenue_type.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_revenue_type"));
		waitABit(2000);
		nspEditPage.ddl_partner_related.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_partner_related"));
		waitABit(2000);
		nspEditPage.ddl_centurylink_network_design.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_centurylink_network_design"));
		waitABit(2000);
		nspEditPage.tbx_anticipated_monthly_revenue.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_anticipated_monthly_revenue"));
		waitABit(2000);
		nspEditPage.tbx_new_comments.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_new_comments"));
		waitABit(2000);
		nspEditPage.tbx_anticipated_monthly_revenue.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_anticipated_monthly_revenue"));
		waitABit(2000);
		nspEditPage.tbx_anticipated_monthly_revenue.sendKeys(Keys.TAB);
		nspEditPage.tbx_anticipated_monthly_revenue.sendKeys(Keys.TAB);
		waitABit(2000);
		nspEditPage.tbx_nsp_anticipated_nrc.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_nsp_anticipated_nrc"));
		waitABit(2000);
		nspEditPage.tbx_existing_monthly_revenue_ilec.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_existing_monthly_revenue_ilec"));
		waitABit(2000);
		nspEditPage.tbx_existing_monthly_revenue_ixc.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_existing_monthly_revenue_ixc"));
		waitABit(2000);
		nspEditPage.ddl_erate_470.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_erate_470"));*/
		
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
