package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MassUpdateFieldsPage extends PasswebPage {

	
	DealSummaryPage dealSummaryPage;
	
   @FindBy(xpath= "//label[text()='Target']/../following-sibling::td/table/tbody/tr/td[2]/div")
   public WebElementFacade ddl_target;
   
   @FindBy(xpath= "//label[text()='Formula']/../following-sibling::td/input")
   public WebElementFacade tbx_Formula;
	
   @FindBy(xpath ="//span[text()='Update']")
   public WebElementFacade btn_Update;
   
   @FindBy(xpath = "//div[contains(@id,'massupdatepanel') and contains(@class,'x-component')]/following::div[1]/img")
   public WebElementFacade img_close;
   
	 
  
   public void getMassUpdateFields(String productName)
   {
	   List<WebElement> massButtons = getDriver().findElements(By.xpath("//label[text() = '"+productName+"']/following-sibling::div[contains(@id, 'componentgrid')]//span[text() = 'Mass Update']"));
	   dealSummaryPage.cbx_selectAll.click();
	   for(int btn_counter = 0; btn_counter<massButtons.size();btn_counter++)
		{
			if(massButtons.get(btn_counter).isDisplayed()){
				massButtons.get(btn_counter).click();
				ddl_target.click();
				int massUpdateListSize =  getDriver().findElements(By.xpath("//div[contains(@id, 'boundlist')]//li[@class= 'x-boundlist-item' or contains(@class,'x-boundlist-item x-boundlist-item-over')]")).size();
				System.out.println( massUpdateListSize + " list items found on the page");
				for(int i = 1; i<=massUpdateListSize;i++)
					{
								waitABit(2000);
								String textFieldsMass = getDriver().findElement(By.xpath("//div[contains(@id, 'boundlist')]//li[@class= 'x-boundlist-item' or contains(@class,'x-boundlist-item x-boundlist-item-over')]["+i+"]")).getText();
								System.out.println("Fetched List Item "  +textFieldsMass);
								if(checkListValueDisplay(textFieldsMass))
								{
									getDropDownValue(textFieldsMass).click();
									typeInTextBox(tbx_Formula,this,textFieldsMass,productName);
									btn_Update.click();
									waitABit(3000);
								}
								
								massButtons.get(btn_counter).click();
								System.out.println("clicked massUpdate");
								ddl_target.click();
								System.out.println("clicked drop down");
								

						}
					
				
				
					}
			}
	   dealSummaryPage.cbx_selectAll.click();
	}
		
   public void fillMassUpdateValue(String productName,String value)
   {
             List<WebElement> massButtons = getDriver().findElements(By.xpath("//span[text() = 'Mass Update']"));
             System.out.println("Size of buttons "+massButtons.size());
             if(isElementPresent("//span[text() = 'Mass Update']/ancestor::a[contains(@class, 'x-item-disabled')]"))
             {
                        dealSummaryPage.cbx_selectAll.click();
                        waitABit(2000);
                        System.out.println("In if statement of Mass UpdateValue");
                        for(int btn_counter = 0; btn_counter<massButtons.size();btn_counter++)
                       {
                               System.out.println("For loop of if statement in MassUpdateValue method "+value+ " "+ btn_counter);
                               if(massButtons.get(btn_counter).isDisplayed())  
                               {
                                    massButtons.get(btn_counter).click();
                                   //  waitABit(3000);
                                     waitFor(ddl_target);
                                     ddl_target.click();
                                     if(isVisible(getDropDownValue(value)))
                                     {
                                        getDropDownValue(value).click();
                                        typeInTextBox(tbx_Formula,this,value,productName);
                                        btn_Update.click();
                                     }
                                     else	
                                            img_close.click();
                                     waitABit(3000);
                               }
                               
                       }
                        waitABit(3000);
                        dealSummaryPage.cbx_selectAll.click();
             }
                 } 
                    
                /*else {
                          for(int btn_counter = 0; btn_counter<massButtons.size();btn_counter++)
                              {
                                 System.out.println("For loop of else statement in MassUpdateValue method "+value+ " "+ btn_counter);
                              if(massButtons.get(btn_counter).isDisplayed())
                                 {
                                     massButtons.get(btn_counter).click();
                                     waitABit(2000);
                                     ddl_target.click();
                                     getDropDownValue(value).click();
                                     typeInTextBox(tbx_Formula,this,value,productName);
                                     btn_Update.click();
                                     waitABit(3000);
                                 }
                              }
                          dealSummaryPage.cbx_selectAll.click();
                    }
             
                 }
*/
	  
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return btn_Update;
	}

	
	
}
