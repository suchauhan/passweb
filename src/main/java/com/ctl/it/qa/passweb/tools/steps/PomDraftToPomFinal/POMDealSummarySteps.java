package com.ctl.it.qa.passweb.tools.steps.PomDraftToPomFinal;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import net.thucydides.core.annotations.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ctl.it.qa.passweb.tools.pages.PomDraftToPomFinal.POMDealSummaryPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.NSPSteps;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebSteps;

public class POMDealSummarySteps extends PasswebSteps{

	POMDealSummaryPage pomdealsummarypage;
	PassWebHomePage passwebhomepage;
	
	public static HashMap<String,String> mapPASS = new HashMap<>();
	
	
	@Step
	public void getDealMetricsvalues()
	{
		
		pomdealsummarypage.img_clickonimg.click();
	    List<WebElement> getdealmetricstables = getDriver().findElements(By.xpath("//div[contains(@id,'dealsummary')]//div[contains(@id, 'sfdcmetricspanel')]//div[contains(@id, 'container')][@class = 'x-box-target']/div"));
	    System.out.println(getdealmetricstables.size());
	    for(int i=1; i<=getdealmetricstables.size();i++)
	    {
	    	List<WebElement> getDealmetricnames = getDriver().findElements(By.xpath("//div[contains(@id,'dealsummary')]//div[contains(@id, 'sfdcmetricspanel')]//div[contains(@id, 'container')][@class = 'x-box-target']/div["+i+"]//table"));
	    	for(int j=1; j<=getDealmetricnames.size(); j++)
	    	{
	    		String dealmetricname = getDriver().findElement(By.xpath("//div[contains(@id,'dealsummary')]//div[contains(@id, 'sfdcmetricspanel')]//div[contains(@id, 'container')][@class = 'x-box-target']/div["+i+"]//table["+j+"]//td/label")).getText();
                String dealmetricnamebeforecolon = dealmetricname.substring(0,dealmetricname.lastIndexOf(":"));
	    		String dealmetricvalues = getDriver().findElement(By.xpath("//div[contains(@id,'dealsummary')]//div[contains(@id, 'sfdcmetricspanel')]//div[contains(@id, 'container')][@class = 'x-box-target']/div["+i+"]//table["+j+"]//td[2]")).getText();
	    		//System.out.println(dealmetricname);
                mapPASS.put(dealmetricnamebeforecolon, dealmetricvalues);
                
                
	    	}
	    	
	    	
	    	
	    }
	    System.out.println(mapPASS.keySet());
	    
	}
	
	@Step
	public void moveToDealSummaryPage()
	{
		passwebhomepage.btn_Products.click();
		waitABit(2000);
		passwebhomepage.ddl_DealSummary.click();
	}
	

	@Step
	public void moveBackToSFA()
	{
	     switchToParenWindow(NSPSteps.winid);
	}
	
	@Step
	public void pickaddedProduct(String product)
	{
		pomdealsummarypage.btn_Products.click();
		pomdealsummarypage.ddl_DealSummary.click();
		expandProduct(product);
		waitABit(2000);
	}
	
	@Step
	public void comparedealmetricsvalueswithSFAvalues()
	{
		Set<Entry<String, String>> ksf = NSPSteps.mapSFA.entrySet();
		for (Entry<String, String> kp: mapPASS.entrySet())
	{
			
				if(kp.getKey().equals(ksf) && kp.getValue().equals(ksf))
						{
				
				              System.out.println("Key and values are matching");
			            }
			    else
			      {
				    System.out.println("keys" +kp.getKey()+ "and value"+kp.getValue()+"are not matching");
			      }
		}	
		
		
	
	}
	
	
}
