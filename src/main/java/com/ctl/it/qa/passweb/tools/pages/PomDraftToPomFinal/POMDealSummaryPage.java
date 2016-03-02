package com.ctl.it.qa.passweb.tools.pages.PomDraftToPomFinal;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PasswebPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class POMDealSummaryPage extends PasswebPage {

	@FindBy(xpath = "//label[text()='Deal Summary']")
	public WebElementFacade lbl_dealSummary;
	
	@FindBy(xpath = "//span[text()='Products']")
	public WebElementFacade btn_Products;
	
	@FindBy(xpath = "//span[text()= 'Deal Summary']")
	public WebElementFacade ddl_DealSummary;
	
	@FindBy(xpath = "//span[text()='Deal Metrics Summary']/../following-sibling::div[1]/img[contains(@class,'x-tool-expand')]")
	public WebElementFacade img_clickonimg;
	
	@FindBy(xpath = "//span[text()='Deal Metrics Summary']/../following-sibling::div[1]/img[contains(@class,'x-tool-collapse')]")
    public WebElementFacade img_noneedclickonimg;
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return lbl_dealSummary;
	}
	
}
