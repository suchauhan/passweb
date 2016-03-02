package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

public class NSPEditPage extends SfaPage {

	@FindBy(css = "select[id *= 'nsp_step']")
	public WebElementFacade ddl_nsp_step;

	@FindBy(css = "select[id *='scope']")
	public WebElementFacade ddl_solution_scope;

	@FindBy(xpath = "//select[contains(@id,'nsp_status__c_su')]")
	public WebElementFacade ddl_nsp_status;
	
	@FindBy(xpath = "//select[contains(@id,'Request_Type')]")
	public WebElementFacade ddl_request_type;
	
	@FindBy(xpath = "//select[contains(@id,'requested_contract_term')]")
	public WebElementFacade ddl_request_contract_term;
	
	@FindBy(xpath = "//input[contains(@id,'Monthly_Min_Contractual_Commitment')]")
	public WebElementFacade tbx_monthly_commit;
	
	@FindBy(xpath = "//select[contains(@name,'Contract_Commitment')]")
	public WebElementFacade ddl_commit_type;
	
	@FindBy(xpath = "//select[contains(@name,'Revenue_Type')]")
	public WebElementFacade ddl_revenue_type;
	
	@FindBy(xpath = "//input[contains(@id,'Anticipated_Monthly_Revenue')]")
	public WebElementFacade tbx_anticipated_monthly_revenue;
	
	@FindBy(xpath = "//select[contains(@id,'Entities_Providing_Service')]")
	public WebElementFacade ddl_entities_providing_service;
	
	@FindBy(xpath = "//input[contains(@id,'nsp_anticipated_nrc')]")
    public WebElementFacade tbx_nsp_anticipated_nrc;
	
	@FindBy(xpath = "//*[contains(text(),'Existing Monthly Revenue ILEC')]/following::td[1]/input")
	public WebElementFacade tbx_existing_monthly_revenue_ilec;
	
	@FindBy(xpath = "//*[contains(text(),'Existing Monthly Revenue IXC')]/following::td[1]/input")
	public WebElementFacade tbx_existing_monthly_revenue_ixc;
	
	@FindBy(xpath = "//select[contains(@id,'Partner_Related')]")
	public WebElementFacade ddl_partner_related;
	
	@FindBy(xpath = "//select[contains(@id,'QNDC_Required')]")
	public WebElementFacade ddl_centurylink_network_design;
	
	@FindBy(xpath = "//select[contains(@id,'erate470')]")
	public WebElementFacade ddl_erate_470;
	
	@FindBy(xpath = "//textarea[contains(@id,'New_Comments')]")
	public WebElementFacade tbx_new_comments;
	
	@FindBy(xpath = "//input[contains(@id,'Offer_Requested_Date')]")
	public WebElementFacade tbx_offer_requested_date;
	
	@FindBy(xpath =  "//h3[text()='NSP Steps and Status']/preceding::input[@value='Save']")
	public WebElementFacade btn_save;
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_nsp_step;
	}
	
	public String selectdate()
	{
	    DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println("current Date"+date);
		
		long currmilli  = date.getTime();
		System.out.println("current Milli"+currmilli);
	    currmilli = currmilli + (1000*60*60*24*3);
		Date seldate = new Date(currmilli);
		System.out.println(seldate);
		String chkdate = seldate.toString();
		chkdate = chkdate.substring(0,3);
		if(chkdate.equals("Sun")||chkdate.equals("Sat"))
		{
			currmilli = currmilli + (1000*60*60*24*2);
			Date date3 = new Date(currmilli);
			/*month = date3.getMonth()+1;
			day = date3.getDate();
			String newseldate = pickdate.toString();
			String year = newseldate.substring(newseldate.length()-4,newseldate.length());
			String txtDate = month+"/"+day+"/"+year;
			String dateC = date3.getMonth()+1+"/"+date3.getDate()+"/"+year;*/
			return dateformat.format(date3);
		}
		
		else 
		{   
			return dateformat.format(seldate);
		}
	}
	
	public void get_offer_requested_date()
	{
		tbx_offer_requested_date.type(selectdate());
	}
	
	public void getDataforNSP()
	{
		//getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ddl_request_type.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_request_type"));
		waitABit(2000);
		ddl_request_contract_term.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_request_contract_term"));
		waitABit(2000);
		ddl_entities_providing_service.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_entities_providing_service"));
		waitABit(2000);
		tbx_monthly_commit.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_monthly_commit"));
		waitABit(2000);
		ddl_commit_type.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_commit_type"));  	
		waitABit(2000);
		ddl_revenue_type.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_revenue_type"));
		waitABit(2000);
		ddl_partner_related.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_partner_related"));
		waitABit(2000);
		ddl_centurylink_network_design.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_centurylink_network_design"));
		waitABit(2000);
		tbx_anticipated_monthly_revenue.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_anticipated_monthly_revenue"));
		waitABit(2000);
		tbx_new_comments.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_new_comments"));
		waitABit(2000);
		tbx_anticipated_monthly_revenue.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_anticipated_monthly_revenue"));
		waitABit(2000);
		tbx_anticipated_monthly_revenue.sendKeys(Keys.TAB);
		tbx_anticipated_monthly_revenue.sendKeys(Keys.TAB);
		waitABit(2000);
		tbx_nsp_anticipated_nrc.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_nsp_anticipated_nrc"));
		waitABit(2000);
		tbx_existing_monthly_revenue_ilec.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_existing_monthly_revenue_ilec"));
		waitABit(2000);
		tbx_existing_monthly_revenue_ixc.type(commonData.getContainer("NSPEditPage").getFieldValue("tbx_existing_monthly_revenue_ixc"));
		waitABit(2000);
		ddl_erate_470.selectByValue(commonData.getContainer("NSPEditPage").getFieldValue("ddl_erate_470"));
	}
	}

