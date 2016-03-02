package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import java.util.List;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;



public class UpdateKeyFieldsPage extends PasswebPage {
	
	
	DealSummaryPage dealSummaryPage;
	@FindBy(xpath = "//label[text() = 'Affiliated Company']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_AffiliatedCo;
	
	@FindBy(xpath = "//label[text() = 'State (In Region)']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_StateInRegion;
	
	@FindBy(xpath = "//label[text() = 'Product Type']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_ProductType;
	
	@FindBy(xpath = "//label[text() = 'Port Speed']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_PortSpeed;
	
	@FindBy(xpath = "//label[text() = 'Bandwidth Profile']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_BandwidthProfile;
	
	@FindBy(xpath = "//label[text() = 'Service Type']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_ServiceType;

	@FindBy(xpath = "//span[text() = 'Submit']")
	public WebElementFacade btn_Submit;
	
	@FindBy(xpath = "//span[text() = 'Cancel']")
	public WebElementFacade btn_Cancel;
	
	@FindBy(xpath = "//label[text() = 'Service Description']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_ServiceDescription;
	
	@FindBy(xpath = "//label[text() = 'Location A Rate Element']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_Location_A_Rate_Element;
	
	@FindBy(xpath = "//label[text() = 'Location Z Rate Element']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_Location_Z_Rate_Element;
	
	@FindBy(xpath = "//label[text() = 'Bandwidth Profile']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input")
	public WebElementFacade tbx_Bandwidth_Profile;
	
	@FindBy(xpath = "//span[contains(@id,'updateKeyFieldsWindow')]")
	public WebElementFacade lbl_updatekeyfieldtitle;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return tbx_Bandwidth_Profile;
	}
	

	public void clickSubmit()
	{
		btn_Submit.click();
		waitABit(10000);
	}

	
    public void fillUpdateKeyFields(String product)
 {
        dealSummaryPage.cbx_selectAll.click();
        List<WebElement> btn_updateKeyFields = getDriver().findElements(By.xpath("//span[text() = 'Update Key Fields']"));
        int countOfBtn = btn_updateKeyFields.size();
        System.out.println("No of Update Key Fields button on page are: "+countOfBtn+" for product "+product );
        for(int counter = 0;counter<countOfBtn;counter++)
        {
        	if(btn_updateKeyFields.get(counter).isDisplayed())
               {
                     btn_updateKeyFields.get(counter).click();
                     if(lbl_updatekeyfieldtitle.isVisible())
                     {
                     int labelCount = getDriver().findElements(By.xpath("//div[contains(@id,'updateKeyFieldsWindow')][contains(@class,'x-box-inner')]//label")).size();
                     List<WebElement> labelName = getDriver().findElements(By.xpath("//div[contains(@id,'updateKeyFieldsWindow')][contains(@class,'x-box-inner')]//label"));
                     System.out.println("No of labels on Update Key Fields window is "+labelCount);
                     for(int count = 0; count<labelCount;count++)
                     {
                            System.out.println("Label Name "+labelName.get(count).getText());
                            String labelSubstring = labelName.get(count).getText();
                            labelSubstring = labelSubstring.substring(0, labelSubstring.length()-1);
                            System.out.println("Label Name after substring "+labelSubstring);
                            String listValue = commonData.getContainer(this.getClass().getSimpleName()).getContainer(product).getFieldValue(generateRuntimeField(labelSubstring));
                            
                            System.out.println("label Value for "+labelSubstring+" is "+listValue);
                            typeInTextBox(getTextbox(labelSubstring), this, labelSubstring,product);
                            getTextbox(labelSubstring).sendKeys(Keys.ENTER);
                            //waitABit(2000);
                            getTextbox(labelSubstring).clear();
                            typeInTextBox(getTextbox(labelSubstring), this, labelSubstring,product);
                            getTextbox(labelSubstring).sendKeys(Keys.ENTER);
                            waitABit(2000);
                            getTextbox(labelSubstring).sendKeys(Keys.TAB);
                            //selectDropDownValue(listValue);
                            
                     }
                     getDriver().findElement(By.xpath("//span[text() = 'Submit']")).click();
                     waitABit(2000);
               }
        }
        }
        dealSummaryPage.cbx_selectAll.click();
 }
    
    
}
