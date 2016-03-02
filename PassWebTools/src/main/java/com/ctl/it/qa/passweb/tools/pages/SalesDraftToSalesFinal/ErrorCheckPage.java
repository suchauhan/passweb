package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import java.util.List;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ErrorCheckPage extends PasswebPage{
       
       UpdateKeyFieldsPage updateKeyFieldPage;
       MassUpdateFieldsPage massUpdateFieldsPage;
       AddressFieldsPage addressFieldsPage;
       DealSummaryPage dealsummarypage;
       @FindBy(xpath = "//span[text() = 'Refresh Errors']")
       public WebElementFacade btn_refreshErrors;
       
       @FindBy(xpath ="//*[@id='gridview-1235-record-ext-record-3378']/td[3]/div")
       public WebElementFacade lnk_ErrorMessage;
       
       @Override
       public WebElementFacade getUniqueElementInPage() {
              // TODO Auto-generated method stub
              return btn_refreshErrors;
       }
       
       public void errorMessageCheck(String product,String errorMsg)
       {
              System.out.println("Error Msg: "+ errorMsg + "ProductName: "+product);
              String error = errorMsg;
              switch(errorMsg)
              {
              case "The configuration for this component is not a valid combination in the PASS system. If the item was imported, please click through the attributes and make necessary changes or contact the POM Helpdesk if you feel this should be a valid selection. If the item was manually entered, please make sure all key attribute columns are populated." :
                     if(product.equalsIgnoreCase("Metro Ethernet (LCTL)") || product.equalsIgnoreCase("Dedicated IP Port (LCTL)") || product.equalsIgnoreCase("Dedicated IP Bundle (LCTL)") || product.equalsIgnoreCase("Dedicated IP Bundle (LEQ)") || product.equalsIgnoreCase("Optical Wavelength Service (QC)"))
                     {
                           updateKeyFieldPage.fillUpdateKeyFields(product);
                           massUpdateFieldsPage.fillMassUpdateValue(product, "NPANXX");
                     }
                     
                     else if(product.equalsIgnoreCase("Metro Ethernet (LEQ)"))
                     {
                           updateKeyFieldPage.fillUpdateKeyFields(product);
                           fillGrids(1, 5, "Service Type" ,"associatedcomponent", "Ethernet VAS",product);
                           fillGrids(1, 6, "Service Description" ,"associatedcomponent", "Ethernet VAS",product);
                           massUpdateFieldsPage.fillMassUpdateValue(product, "NPANXX");
                     }
                     
                     else if(product.equalsIgnoreCase("Metro Ethernet (QC)"))
                     {
                    	 updateKeyFieldPage.fillUpdateKeyFields(product);
                    	 fillGrids(1, 5, "Service Type" ,"associatedcomponent", "Ethernet VAS",product);
                         fillGrids(1, 6, "Service Description" ,"associatedcomponent", "Ethernet VAS",product);
                         massUpdateFieldsPage.fillMassUpdateValue(product, "NPANXX");
                     }
                     
                     else if(product.equalsIgnoreCase("Conferencing (QCC)") || product.equalsIgnoreCase("iQ Standard (QCC)") || product.equalsIgnoreCase("iQ Bundle (QCC)") || product.equalsIgnoreCase("LD Voice - Domestic (QCC)") || product.equalsIgnoreCase("LD Voice - International (QCC)") || product.equalsIgnoreCase("SIP Trunk (QCC)") || product.equalsIgnoreCase("E-Line (QCC)") || product.equalsIgnoreCase("Private Line Domestic (QCC)"))
                     {
                           updateKeyFieldPage.fillUpdateKeyFields(product);
                     }
                     
              break;
                  
              
              case "Please enter a numeric Requested MRR." :
                     massUpdateFieldsPage.fillMassUpdateValue(product, "Requested MRR");

              break;

              case "Please enter a numeric Requested NRR." :
                     massUpdateFieldsPage.fillMassUpdateValue(product, "Requested NRR");
              break;

              case "One or more addresses are incomplete. Please review and update the address information so that each line-item address is complete." :
                    if(product.equalsIgnoreCase("Dedicated IP Bundle (LCTL)") || product.equalsIgnoreCase("Dedicated IP Bundle (LEQ)"))   
                    {
                    	massUpdateFieldsPage.fillMassUpdateValue(product, "Address - Full");
                    }
                    else if(product.equalsIgnoreCase("Metro Ethernet (LCTL)"))
                    {
                        addressFieldsPage.populateAddress(addressFieldsPage.tbx_Streetgrid,product);
                    }
                    else if(product.equalsIgnoreCase("Metro Ethernet (QC)"))
                    {
                    	addressFieldsPage.populateAddress(addressFieldsPage.tbx_Streetgrid, product);
                    }
                    
                    else if(product.equalsIgnoreCase("iQ Standard (QCC)") || product.equalsIgnoreCase("LD Voice - Domestic (QCC)") || product.equalsIgnoreCase("iQ Bundle (QCC)") || product.equalsIgnoreCase("LD Voice - International (QCC)"))
                    {
                    	fillGrids(1, 24, "Street", "associatedcomponent", "Loop",product);
                    	fillGrids(1, 25, "City", "associatedcomponent", "Loop",product);
                    	fillGrids(1, 26, "State", "associatedcomponent", "Loop",product);
                    	fillGrids(1, 27, "Postal Code", "associatedcomponent", "Loop",product);
                    }
                    
                    else if(product.equalsIgnoreCase("IQ SIP (QCC)"))
                    {
                    	fillGrids(1, 9, "Street", "associatedcomponent", "IQ SIP Sessions",product);
                    	fillGrids(1, 10, "City", "associatedcomponent", "IQ SIP Sessions",product);
                    	fillGrids(1, 11, "State", "associatedcomponent", "IQ SIP Sessions",product);
                    	fillGrids(1, 12, "Postal Code", "associatedcomponent", "IQ SIP Sessions",product);
                    }
                    else if(product.equalsIgnoreCase("E-Line (QCC)") || product.equalsIgnoreCase("Private Line Domestic (QCC)"))
                    {
                    	fillGrids(1, 24, "Street", "associatedcomponent", "Loop",product);
                    	fillGrids(1, 25, "City", "associatedcomponent", "Loop",product);
                    	fillGrids(1, 26, "State", "associatedcomponent", "Loop",product);
                    	fillGrids(1, 27, "Postal Code", "associatedcomponent", "Loop",product);
                    	fillGrids(2, 24, "Street", "associatedcomponent", "Loop",product);
                    	fillGrids(2, 25, "City", "associatedcomponent", "Loop",product);
                    	fillGrids(2, 26, "State", "associatedcomponent", "Loop",product);
                    	fillGrids(2, 27, "Postal Code", "associatedcomponent", "Loop",product);
                    }
                    
                    else if(product.equalsIgnoreCase("SIP Trunk (QCC)"))
                    {
                    	fillGrids(1, 10, "Street", "associatedcomponent", "TNs", product);
                    	fillGrids(1, 11, "City", "associatedcomponent", "TNs", product);
                    	fillGrids(1, 12, "State", "associatedcomponent", "TNs", product);
                    	fillGrids(1, 13, "Postal Code", "associatedcomponent", "TNs", product);
                    	
                    }
                    break;
              
              case "Please be sure both Location A NPANXX and Location Z NPANXX are filled out." :
                    massUpdateFieldsPage.fillMassUpdateValue(product, "Location A NPANXX");
                    massUpdateFieldsPage.fillMassUpdateValue(product, "Location Z NPANXX");
                    break;
                    
              case "Mileage is mandatory and must be positive." :
                    massUpdateFieldsPage.fillMassUpdateValue(product, "Mileage");
                    break;
                    
              case "Please be sure both Address Location A and Address Location Z are filled out." :
                     massUpdateFieldsPage.fillMassUpdateValue(product, "Address Location A");
                     massUpdateFieldsPage.fillMassUpdateValue(product, "Address Location Z");
                     break;
                     
              case "You must enter a numeric Quantity of Monthly Minutes." :
                     massUpdateFieldsPage.fillMassUpdateValue(product, "Quantity of Monthly Minutes");
                     break; 
                     
              case "Please enter a numeric Requested Price Per Minute." :
                     massUpdateFieldsPage.fillMassUpdateValue(product, "Requested Price Per Minute");
                     break;
                     
              case "You must enter a CNDC ID for this Loop" :
            	     massUpdateFieldsPage.fillMassUpdateValue(product, "CNDC ID");
                     break;
                     
              case "ALOC in seconds is mandatory and must be positive.":
            	     fillGrids(1, 7, "ALOC in seconds", "component", "Voice Domestic", product);
            	     break;
             
              case "Quantity of Monthly Minutes is mandatory and must be positive.":
            	     fillGrids(1, 10, "Quantity of Monthly Minutes", "component", "Voice Domestic", product);
            	     break;
            	     
              case "You must select VQT Qualification for this component":
            	     fillGrids(1, 6, "VQT Qualification", "associatedcomponent", "TNs", product);
            	     break;
                     
              case "You must select a Type for this Loop." :
            	  if (product.equalsIgnoreCase("iQ Standard (QCC)") || product.equalsIgnoreCase("LD Voice - Domestic (QCC)") || product.equalsIgnoreCase("iQ Bundle (QCC)") || product.equalsIgnoreCase("LD Voice - International (QCC)"))
            	  {
            		  fillGrids(1, 12, "Type", "associatedcomponent", "Loop",product);
            	  }
            	  
            	  else if(product.equalsIgnoreCase("E-Line (QCC)") || product.equalsIgnoreCase("Private Line Domestic (QCC)"))
            	  {
            		  fillGrids(1, 12, "Type", "associatedcomponent", "Loop",product);
            		  fillGrids(2, 12, "Type", "associatedcomponent", "Loop",product);
            	  }
                    break; 
                    
              case "You must enter the Loop Type for this Loop.":
            	  if (product.equalsIgnoreCase("iQ Standard (QCC)") || product.equalsIgnoreCase("LD Voice - Domestic (QCC)") || product.equalsIgnoreCase("iQ Bundle (QCC)") || product.equalsIgnoreCase("LD Voice - International (QCC)"))
            	  {
            		  fillGrids(1, 35, "Loop Type","associatedcomponent", "Loop",product); 
            	  }
            	  
            	  else if(product.equalsIgnoreCase("E-Line (QCC)") || product.equalsIgnoreCase("Private Line Domestic (QCC)"))
            	  {
            		  fillGrids(1, 35, "Loop Type","associatedcomponent", "Loop",product);
            		  fillGrids(2, 35, "Loop Type","associatedcomponent", "Loop",product);
            	  }
            	  break;
            	  
              case "There is a quantity discrepancy between the Session Count and IQ SIP Sessions components" :
            	  massUpdateFieldsPage.fillMassUpdateValue(product, "Session Quantity");
            	  massUpdateFieldsPage.fillMassUpdateValue(product, "Quantity");
              }
       }


       public void fillGrids(int row,int col,String tbx_name, String typeOfComponent,String componentName,String product)
       {
              
              WebElement tbx_grid =  getDriver().findElement(By.xpath("//span[contains(text(),'"+componentName+"')]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div[contains(@id,'"+typeOfComponent+"')][1]/div[contains(@id,'body')]//tr["+row+"]/td["+col+"]"));
              Actions act = new Actions(getDriver());
              act.doubleClick(tbx_grid).build().perform();;
              waitABit(1000);
              WebElement tbx_input = getDriver().findElement(By.xpath("//input[@name = '"+tbx_name+"']"));
              System.out.println(generateRuntimeField(tbx_name));
              tbx_input.sendKeys(commonData.getContainer("GridFields").getContainer(product).getFieldValue(generateRuntimeField(tbx_name)));
              dealsummarypage.cbx_selectAll.click();
       }
      
}

