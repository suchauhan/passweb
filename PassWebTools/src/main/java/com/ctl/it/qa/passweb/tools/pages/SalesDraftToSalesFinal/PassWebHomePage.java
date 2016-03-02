package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

public class PassWebHomePage extends PasswebPage{

	@FindBy(xpath = "//span[text() = 'Actions']/parent::span")
	public WebElementFacade btn_actions;
	
	@FindBy(xpath = "//span[text()='Products']")
	public WebElementFacade btn_Products;
	
	@FindBy(xpath = "//span[text()= 'Deal Summary']")
	public WebElementFacade ddl_DealSummary;
		
	@FindBy(xpath = "//span[text() = 'Import Quotes']")
	public WebElementFacade ddl_importQuote;
	
	@FindBy(xpath = "//span[text() = 'Error Check']")
	public WebElementFacade ddl_errorCheck;
	
	@FindBy(xpath = "//span[text() = 'Clone Version']")
	public WebElementFacade ddl_cloneversion;
	
	@FindBy(xpath = "//table[contains(@id,'versioncombo') and contains(@class,'form-trigger')]/tbody/tr/td[2]/div")
	public WebElementFacade ddl_versionlist;
	
	@FindBy(xpath ="//div[contains(@class,'x-boundlist-item x-boundlist-selected')]/span")
	public WebElementFacade ddl_initialversion;
	
	@FindBy(xpath = "//span[text()='Logout']")
	public WebElementFacade btn_logout;
	
	@FindBy(xpath = "//div[starts-with(@id, 'boundlist-')]/ul/li")
	public WebElementFacade ddl_NSPSearchValue;
	
	@FindBy(xpath = "//input[contains(@id, 'nspcombo')]")
	public WebElementFacade tbx_nspNumber;
	
	@FindBy(xpath = "//label[text() = 'Pricing Analysis Support System (PASS)']")
	public WebElementFacade lbl_header;
	
	@FindBy(xpath = "//div[@id = 'messagebox-1001-toolbar-innerCt']/div/child::a[2]/span/span")
	public WebElementFacade logoutOptionYes;
	
	@FindBy(xpath = "//label[text()='Quote ID']/ancestor::td/following-sibling::td/textarea") 
    public WebElementFacade tbx_quotePP; 
	
	@FindBy(xpath = "//label[text()='Quote ID']/ancestor::td/following-sibling::td/textarea") 
    public WebElementFacade tbx_quoteQVO; 
	
	@FindBy(xpath = "//label[text()='QVO']/preceding-sibling::input")
	public WebElementFacade cbx_QVO;
    
    @FindBy(xpath = "//label[contains(text(), 'To import multiple quotes')]/following::td[2]/div/input") 
    public WebElementFacade cbx_IQ_Networking;
    
    @FindBy(xpath = "//span[text()='Submit']")
    public WebElementFacade btn_Submit;
    
    @FindBy(xpath = "//div[contains(@id,'importnsp')]//span[text() = 'Create New NSP']")
    public WebElementFacade lbl_createNSPDialog;
    
    @FindBy(xpath = "//div[contains(@id,'importnsp')]//span[text() = 'Create']")
    public WebElementFacade btn_createNSP;
	
    @FindBy(xpath = "//table[contains(@id,'messagebox')][1]/tbody/tr/td[2]/div")
    public WebElementFacade lbl_messagebox;
    
    @FindBy(xpath = "//div[contains(@id,'messagebox') and contains(@class,'x-window x-message-box x-layer')]")
    public WebElementFacade lbl_import;
    
    @FindBy(xpath = "//span[text()='OK']")
    public WebElementFacade btn_OK;
    
    @FindBy(xpath = "//span[text() = 'Confirm Submit']")
     public WebElementFacade btn_ConfirmSubmit;
    
    @FindBy(xpath = "//div[text() = 'This deal has passed all error, warning, and policy checks!']")
    public WebElementFacade lbl_congratulationMessage;
    	    
    @FindBy(xpath = "//span[text() = 'NSP Status Changed']")
    public WebElementFacade lbl_nspStatusChangedMsg;
   
    @FindBy(xpath ="//label[text()='Version Status']/../following-sibling::div")
    public WebElementFacade lbl_versionStatus;
    
    @FindBy(xpath = "//input[@id='ProductSelect']")
    public WebElementFacade tbx_product;
    
	
    @Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return lbl_header;
	}
	
    public void getNSP(String nspField)
	{
		tbx_nspNumber.type(Page.commonData.getContainer(this.getClass().getSimpleName()).getFieldValue(nspField).toString());
	}
    
    public void getList(String val)
	{
		System.out.println(val);
		getDriver().findElement(By.xpath("//li[contains(text(),'"+val+"')]")).click();
		
	}
    
    public void get_ppquote() 
    { 
           
            IntDataContainer dataContainer = commonData.getContainer(this.getClass().getSimpleName()); 
            tbx_quotePP.type(dataContainer.getFieldValue("tbx_quotePP").toString()); 
            
    }
    
    public void get_qvoquote()
	{
		
		IntDataContainer dataContainer = commonData.getContainer(this.getClass().getSimpleName());
		tbx_quotePP.type(dataContainer.getFieldValue("tbx_quoteQVO").toString());
	}
	
}