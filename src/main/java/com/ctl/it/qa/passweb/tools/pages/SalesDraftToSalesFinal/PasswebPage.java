package com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal;

import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.Page;

public abstract class PasswebPage extends Page {

	
	
	public void switchtoWindow()
	{
		for(String winhandle: getDriver().getWindowHandles())
		{
		     getDriver().switchTo().window(winhandle);
		}
	}
	
	public PasswebPage()
	{
		initialize();
	}
	public void typeInTextBox(WebElement tbx_name,Page page,String tbx_value,String product)
	{
	   System.out.println("Type in TextBox "+tbx_value);
	   if(page.getClass().getSimpleName().equals("UpdateKeyFieldsPage"))
	   {
		   System.out.println("Product Name: "+product+", Pagename: "+page+", tbx_value: "+tbx_value+", tbx_name: "+tbx_name);
		  // System.out.println(commonData.getContainer(page.getClass().getSimpleName()).getContainer(product).getFieldValue(generateRuntimeField(tbx_value)));
		   tbx_name.sendKeys(commonData.getContainer(page.getClass().getSimpleName()).getContainer(product).getFieldValue(generateRuntimeField(tbx_value)));   
	   }
	   else if(page.getClass().getSimpleName().equals("MassUpdateFieldsPage"))
	   {
		   //System.out.println(commonData.getContainer(page.getClass().getSimpleName()).getFieldValue(generateRuntimeField(tbx_value)));
		   tbx_name.sendKeys(commonData.getContainer(page.getClass().getSimpleName()).getFieldValue(generateRuntimeField(tbx_value))); 
	   }
		
	}
	public WebElement getDropDownValue(String listValue)
	{
		try{
		if(getDriver().findElement(By.xpath("//li[text() = '"+listValue+"']")).isDisplayed())
		{
		return getDriver().findElement(By.xpath("//li[text() = '"+listValue+"']"));
		
		}
		else
		{
			return null;
		}
		}
		catch(Exception e)
		{
			System.out.println("Web Element not found in get Drop down method");
			return null;
		}
	}
	
	public boolean isVisible(WebElement element) {

        try {
            if(element.isDisplayed())
            {
            	return true;
            }
            else
            {
            	return false;
            }
        }
         catch (ElementNotVisibleException e) {
            return false;
        } catch (NoSuchElementException e) {
            return false;
        } catch (StaleElementReferenceException se) {
            return false;
        }
        catch (Exception se) {
            return false;
            
        }
    }
   public boolean checkListValueDisplay(String str)
   {
	   try{
		   if(getDropDownValue(str).isDisplayed())
		   {
			   return true;
		   }
	   }
	   catch(Exception e){
		   System.out.println(e);
	   }
	return false;
   }
   
   public WebElement getTextbox(String textBox)
	{
		return getDriver().findElement(By.xpath("//label[text() = '"+textBox+"']/ancestor::tr/td/following-sibling::td/table/tbody/tr/td[1]/input"));
	}
	
	public boolean checkTextBoxDisplay(String str)
	{
		try{
		if(getTextbox(str).isDisplayed())
		{
			return true;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	
	public void switchtoFrame(String frame) {
		getDriver().switchTo().window(getDriver().getWindowHandle());
		getDriver().switchTo().frame(frame);
	}
	
	public void closeBrowser(){
		getDriver().close();
	}
	
	public void clickButton(String btn_name)
	{
		getDriver().findElement(By.xpath("//span[text() = '"+btn_name+"']")).click();
		
	}
	
	public void selectListOption(String option)
	{
		getDriver().findElement(By.xpath("//a[text() = '"+option+"]")).click();
	}
	public String generateRuntimeField(String field)
	   {
		   field = "tbx_" +field.replaceAll("\\s", "_");
		   System.out.println("Runtime field generated: "+field);
		   return field;
	   }
	
	public void selectDropDownValue(String value)
	{
		getDriver().findElement(By.xpath("//li[text() = '"+value+"']")).click();
	}
	
	public boolean isElementPresent(String elementPath)
	{
		
		try{
		getDriver().findElement(By.xpath(elementPath));
		return true;
		}
		catch(NoSuchElementException ex)
		{
			System.out.println(ex);
			return false;
		}
		
	}
	
	public boolean isClickable(WebElement webe)      
	{
	try
	{
	   WebDriverWait wait = new WebDriverWait(getDriver(), 5);
	   wait.until(ExpectedConditions.elementToBeClickable(webe));
	   return true;
	}
	catch (Exception e)
	{
	  return false;
	}
	}
}
