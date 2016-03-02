package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PassWebAddProductPage extends PassWebHomePage{
	
	
	@FindBy(xpath = ".//*[@id='nspcombo-1025-labelEl']")
	public WebElementFacade lbl_NSP_Number;
	
	@FindBy(xpath = ".//*[@id='combobox-1122-inputEl']")
	public WebElementFacade ddl_comp_company;

	@FindBy(xpath = ".//*[@id='combobox-1123-inputEl']")
	public WebElementFacade ddl_comp_position;
	
	@FindBy(xpath = ".//*[@id='gridview-1129-record-ext-record-3824']/td[1]/div")
	public WebElementFacade ddl_hidden_company;
	
	@FindBy(xpath = ".//*[@id='gridview-1129-record-ext-record-3824']/td[2]/div")
	public WebElementFacade ddl_hidden_position;
	
	@FindBy(xpath = ".//*[@id='boundlist-1259-listEl']/ul/li")
	public WebElementFacade ddl_NSP_list;
	
	@FindBy(xpath = ".//*[@id='button-1038-btnWrap']")
	public WebElementFacade btn_action;
	
	@FindBy(xpath = "//span[text() = 'Add Products']")
	public WebElementFacade ddl_actionsList;
	
	@FindBy(xpath = "//label[text() = 'Entity']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[2]/div")
	public WebElementFacade ddl_entity_list;
	
	@FindBy(xpath = "//label[text() = 'Product']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[2]/div")
	public WebElementFacade ddl_product_list;
	
	@FindBy(xpath = "//input[starts-with(@id,'numberfield')][@name = 'RowCount']")
	public WebElementFacade tbx_rowcount;

	@FindBy(xpath = "//li[contains(text(),'LCTL')]")
	public WebElementFacade ddl_entity_list_val;
	
	@FindBy(xpath = "//li[contains(text(),'Dedicated IP Bundle (LCTL)')]")
	public WebElementFacade ddl_product_list_val;
	
	@FindBy(xpath = "//span[text() = 'Submit']")
	public WebElementFacade btn_submitProduct;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		
		return lbl_NSP_Number;
	}
	

	
//*[text() = '']
	
	
	
}
