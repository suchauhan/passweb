package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import java.util.ArrayList;
import java.util.List;

import jxl.common.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.AddressFieldsPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.DealSummaryPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.MassUpdateFieldsPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.UpdateKeyFieldsPage;

import cucumber.api.DataTable;
import groovy.transform.stc.PickAnyArgumentHint;

@SuppressWarnings("serial")
public class ProductConfigurationSteps extends PasswebSteps{

	
	String updateKeyField [], massUpdateField[], manualUpdate[];
	UpdateKeyFieldsPage keyfieldsPage;
	MassUpdateFieldsPage massUpdateFieldsPage;
	AddressFieldsPage addressFieldsPage;
	static List<String> entityValues;
	static List <String> productValues;
	DealSummaryPage dealSummaryPage;
		
	@Steps
	PasswebHomeSteps passwebHomeSteps;
	
	@Steps
	DealSummarySteps dealSummarySteps;
	
	@Steps
	DealInformationSteps dealInformationSteps;
	
	String entityVal, ProdVal;
	public String getEntity()
	{
		return entityVal;
	}
	public void setEntity(String entity)
	{
		entityVal = entity;
	}
	public String getProduct()
	{
		return ProdVal;
	}
	public void setProduct(String product)
	{
		ProdVal = product;
	}
	
	@Step
	public void getEntityAndProducts(DataTable table)
	{
		
		List<List<String>> entity = table.raw();
		for(int i = 0;i<entity.size();i++)
		{

			setEntity(entity.get(i).get(0));
			setProduct(entity.get(i).get(1));
			passwebHomeSteps.addProduct(getEntity(), getProduct());
			dealSummarySteps.selectandConfigureAddedProduct(getProduct());
			dealSummarySteps.selectAddedProduct(getProduct());
			compareUpdateKeyMassUpdate(getProduct());
		}
	}

	public List<List<String>> getEntityAndProducts1(DataTable table)
	{
		
		List<List<String>> featureFileValues = table.raw();
		return featureFileValues;
	}
	
	public void fetchEntityProducts(DataTable table)
	{
		List<List<String>> datavalues = getEntityAndProducts1(table);
		this.entityValues = new ArrayList<String>();
		this.productValues= new ArrayList<String>();
		for(int i = 0;i<datavalues.size();i++)
		{
			entityValues.add(datavalues.get(i).get(0));
			productValues.add(datavalues.get(i).get(1));
			System.out.println("Entity Count " +entityValues.size() + " " + entityValues);
			System.out.println("Product Count " +productValues.size() + " " + productValues);
		}
	}
	@Step
	public void addProductandapplyConfigurations(DataTable table)
	{
		fetchEntityProducts(table);
		for(int i = 0; i<productValues.size();i++)
		{
			passwebHomeSteps.addProduct(entityValues.get(i), productValues.get(i));
			dealSummarySteps.selectandConfigureAddedProduct(productValues.get(i));
			
		}
	}
	
	@Step
	public void addProductmanually(DataTable table)
	{
		fetchEntityProducts(table);
		for(int i = 0; i<productValues.size();i++)
		{
			passwebHomeSteps.addProduct(entityValues.get(i), productValues.get(i));
		}
	}
	
	@Step
	public void applyConfiguration()
	{
		for(int i = 0; i<productValues.size();i++)
		{
			//passwebHomeSteps.addProduct(entityValues.get(i), productValues.get(i));
			dealSummarySteps.selectandConfigureAddedProduct(productValues.get(i));
		}
	}
	
	public void configureProducts(String product)
	{
			//initFields(product);
			//keyfieldsPage.fillKeyFields( product,updateKeyField);
			//massUpdateFieldsPage.fillMassUpdateFields(massUpdateField);
			//keyfieldsPage.fillUpdateKeyFields(product);
			//massUpdateFieldsPage.getMassUpdateFields(product);
			//addressFieldsPage.CNDCFieldValidation();
			//addressFieldsPage.populateAddress(addressFieldsPage.tbx_Streetgrid,product);	
			keyfieldsPage.fillUpdateKeyFields(product);
			massUpdateFieldsPage.getMassUpdateFields(product);
			
			
			
			
	}
	
	
	public void compareUpdateKeyMassUpdate(String productName)
	{
		dealSummaryPage.cbx_selectAll.click();
		List<WebElement> updateButtons = getDriver().findElements(By.xpath("//label[text() = '"+productName+"']/following-sibling::div[contains(@id, 'componentgrid')]//span[text() = 'Update Key Fields']"));
		List<WebElement> massButtons = getDriver().findElements(By.xpath("//label[text() = '"+productName+"']/following-sibling::div[contains(@id, 'componentgrid')]//span[text() = 'Mass Update']"));
		System.out.println("Update Buttons " +updateButtons.size());
		System.out.println("Mass Update buttons "+massButtons.size());
		int counter = 0;
		for(int h = 0;h<updateButtons.size()-1;h++)
		{
			updateButtons.get(h).click();
			if(keyfieldsPage.lbl_updatekeyfieldtitle.isVisible())
			{
			List<WebElement> updateKeyFieldValues = getDriver().findElement(By.xpath("//div[contains(@id, 'updateKeyFieldsWindow')]/div[contains(@id, 'form')]")).findElements(By.tagName("label"));
			System.out.println("Key Field List size "+updateKeyFieldValues.size());
			List<String> labeltexts = new ArrayList<>();
			for(int i = 1;i<=updateKeyFieldValues.size();i++)
			{
				String textFields =getDriver().findElement(By.xpath("//div[contains(@id, 'updateKeyFieldsWindow')]//div[contains(@id, 'form')]/table["+i+"]//label[contains(@id, 'combobox')]")).getText();
				textFields = textFields.substring(0, textFields.length()-1);
				System.out.println(textFields);
				labeltexts.add(textFields);
			}
			
			getDriver().findElement(By.xpath("//div[contains(@id,'updateKeyFieldsWindow')]//span[text() = 'Cancel']")).click();
			waitABit(2000);
			
			
			massButtons.get(h).click();
			massUpdateFieldsPage.ddl_target.click();
			waitABit(2000);
			List<WebElement> massUpdate =  getDriver().findElement(By.xpath("//descendant::body/div[contains(@id, 'boundlist')][2]/div/ul")).findElements(By.tagName("li"));
			System.out.println("MassUpdateList size "+massUpdate.size());
			
			
			for(int i = 1;i<=massUpdate.size();i++)
			{
				String textFieldsMass =getDriver().findElement(By.xpath("//descendant::body/div[contains(@id, 'boundlist')][2]/div/ul/li["+i+"]")).getText();
				System.out.println(textFieldsMass);
				if(labeltexts.contains(textFieldsMass))
				{
					System.out.println("Mass Update field contains " +textFieldsMass+ "which is of UpdateKeyFields list for product "+productName);
					counter++;
				}
				else
				{
					System.out.println(textFieldsMass + " is not in UpdateKeyFields for product "+productName);
				}
			}
			
			massUpdateFieldsPage.img_close.click();
			}

			
		}
		
		if(counter==0)
		{
			System.out.println("There are no matching values in UpdateKeyFields and MassUpdatefields for product "+productName);
		}
		else if(counter>0)
		{
			System.out.println("Matching values found for MassUpdatefields and UpdateKeyFields for product "+productName);
		}
		
		dealSummaryPage.cbx_selectAll.click();
	}
	
	@Step
	public void addRedirectandCompare()
	{
		for(int i = 0;i<entityValues.size();i++)
		{
			//passwebHomeSteps.addProduct(entityValues.get(i), productValues.get(i));
			dealSummarySteps.selectAddedProduct(productValues.get(i));
			System.out.println("check box select before check mass and update key");
			compareUpdateKeyMassUpdate(productValues.get(i));
		}
	}

	@Step
	public void checkMassUpdateUsageForProducts()
	{
		
		System.out.println(entityValues.size());
		System.out.println(productValues.size());
		for(int i = 0;i<entityValues.size();i++)
		{
		passwebHomeSteps.addProduct(entityValues.get(i), productValues.get(i));
		dealSummarySteps.selectAddedProduct(productValues.get(i));
		massUpdateFieldsPage.getMassUpdateFields(productValues.get(i));
		}
	}
	@Step
	public void checkAddProducts()
	{
		
		System.out.println(entityValues.size());
		System.out.println(productValues.size());
		for(int i = 0;i<entityValues.size();i++)
		{
			
			passwebHomeSteps.addProduct(entityValues.get(i), productValues.get(i));
			
		
		}
	}
	
	public void addComponent()
    {
           
           int subComponentCount = getDriver().findElements(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]")).size() - 1;
           System.out.println("Subcomponent Size " +subComponentCount );
           for(int i =1;i<=subComponentCount;i++)
           {
        	   int rowCountBeforeAddition =  getDriver().findElements(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]//tr")).size();
        	   System.out.println("First Subcomponent Row Size " +rowCountBeforeAddition );
        	   getDriver().findElement(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]//span[text() = 'Add Component']")).click();
        	   waitABit(2000);
        	   getDriver().findElement(By.xpath("//div[contains(@id, 'howmanydialogue')]//span[text() = 'Submit']")).click();
        	   waitABit(5000);
        	   int rowCountAfterAddition =  getDriver().findElements(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]//tr")).size();
        	   System.out.println("First Subcomponent Row Size " + rowCountAfterAddition);
        	   
        	   if(rowCountAfterAddition>rowCountBeforeAddition)
        	   {
        		   System.out.println("component got added");
        	   }
        	   else
        	   {
        		   System.out.println("component not added");
        	   }
           }
           dealSummaryPage.cbx_selectAll.click();
           System.out.println("check box deselect after adding component ");
    }
    
    
  /*  @Step
    public void getComponentName()
    {
           
           List<WebElement> componentname = getDriver().findElements(By.xpath("//span[contains(@id,'associatedcomponentgrid')]"));
           productconfigurepage.cbx_configrow.click();
           String[] rowcounts;
           for(int i=0; i< componentname.size();i++)
           {
           if(componentname.get(i).isDisplayed())
           {  
               String rowcount = componentname.get(i).getText();
                System.out.print(rowcount.substring(rowcount.lastIndexOf("d")+2));
              
           }
           }
           
    }*/
    
    @Step 
    public void verifyaddcomponent()
    {
    	for(int i = 0;i<entityValues.size();i++)
		{
			//passwebHomeSteps.addProduct(entityValues.get(i), productValues.get(i));
    		String product = productValues.get(i);
    		if(isProductPresent("//label[text()='"+product+"']"))
    		{
			dealSummarySteps.selectAddedProduct(product);
			System.out.println("check box selected before add component");
			addComponent();
    		}
    		
    		else
    		{
    			System.out.println("Product Page is not displayed");
				dealSummarySteps.pickaddedProduct(product);
				dealSummarySteps.selectAddedProduct(product);
				addComponent();	
    		}
		}
    }


    public void deletecomponent()
    {
    	int div_SubComponent = getDriver().findElements(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]")).size() - 1;
         System.out.println("Sub Component Count " +div_SubComponent );
         for(int i =1;i<=div_SubComponent;i++)
         {
         int rowCount =  getDriver().findElements(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]//tr")).size();
         System.out.println("Row Size for sub component no "+i+": "+rowCount+" before deletion");
         int j = rowCount;
         getDriver().findElement(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]//tr["+j+"]/td[1]")).click();
         waitABit(2000);
         if(j>1)
           {
        	 System.out.println("In if(j>1) condition");
        	 getDriver().findElement(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]//span[text()='Delete Component']")).click();
        	 getDriver().findElement(By.xpath("//div[contains(@id,'messagebox')]//span[text()='Yes']")).click();
        	 waitABit(2000);
        	 int rowCountAfterDeletion = getDriver().findElements(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]//tr")).size();
        	 System.out.println("Row Size for sub component no "+i+": "+rowCountAfterDeletion+" after deletion");
        	 if(rowCountAfterDeletion < rowCount )
             {
                     System.out.println("Component row got deleted");
             }
             else
             {
                     System.out.println("Component row not deleted");
                     
             }
           }
         else if(j==1)
         {
        	 System.out.println("In if(j==1) condition");
        	 
        	 
        	 getDriver().findElement(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]//span[text()='Delete Component']")).click();
        	 System.out.println("Clicked Delete Component Button");
        	 getDriver().findElement(By.xpath("//div[contains(@id,'messagebox')]//span[text()='Yes']")).click();
        	 System.out.println("Clicked Yes Button");
        	 waitABit(2000);
        	 if(getDriver().findElement(By.xpath("//div[contains(@id, 'associatedcomponentgrid')][contains(@class,'x-panel-default')]["+i+"]")).isDisplayed())
        	 {
        		 System.out.println("Subcomponent not deleted");
        	 }
        	 else
        	 {
        		 System.out.println("Subcomponent got deleted");
        	 }
        	 
        	  
         }
         
         
         
       }
         dealSummaryPage.cbx_selectAll.click(); 
         System.out.println("check box deselect after delete component");
                 
    }
    
    @Step 
    public void verifyDeleteComponent()
    {
    	for(int i = 0;i<entityValues.size();i++)
		{
    		String product = productValues.get(i);
    		if(isProductPresent("//label[text()='"+product+"']"))
    		{
			dealSummarySteps.selectAddedProduct(product);
			System.out.println("check box selected before add component");
			deletecomponent();
    		}
    		else
    		{
    			System.out.println("Product Page is not displayed");
				dealSummarySteps.pickaddedProduct(product);
				dealSummarySteps.selectAddedProduct(product);
				deletecomponent();	
    		}
		}
    }

    
	
	
}
