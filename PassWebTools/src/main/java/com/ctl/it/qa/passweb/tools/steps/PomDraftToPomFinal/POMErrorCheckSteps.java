package com.ctl.it.qa.passweb.tools.steps.PomDraftToPomFinal;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.passweb.tools.pages.PomDraftToPomFinal.POMErrorCheckPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.PasswebSteps;

@SuppressWarnings("serial")
public class POMErrorCheckSteps extends PasswebSteps{

	PassWebHomePage passHomePage;
	POMErrorCheckPage pomerrorpage;
	
	@Steps
	POMDealSummarySteps pomdealSummarySteps;
	
	
	public void checkErrors()
	{
		
		passHomePage.btn_actions.click();
		passHomePage.ddl_errorCheck.click();
		waitABit(1000);
		countErrors();
	}
	
	@Step
	public void dealWithErrorsPOM()
	{
		checkErrors();
		getProductAndMsg();
		refreshErrors();
		
	}
	
	@Step
	public void refreshErrors()
	{
		pomerrorpage.btn_refreshErrors.click();
		waitABit(5000);
	}
	
	public void getProductAndMsg()
	{
		for(int i=0; i<errorList.get(0).size();i++)
		{
			
			String product = errorList.get(1).get(i);
			if(isProductPresent("//label[text() = '"+product+"']"))
			{
				System.out.println("Product Page is already displayed");
				waitABit(2000);
				System.out.println("Handling error(If): "+errorList.get(0).get(i));
				pomerrorpage.errorMessageCheckPOM(errorList.get(1).get(i), errorList.get(0).get(i));

			}
			else
			{
				System.out.println("Product Page is not displayed");
				pomdealSummarySteps.pickaddedProduct(errorList.get(1).get(i));
				System.out.println("Handling error (Else): "+errorList.get(0).get(i));
				pomerrorpage.errorMessageCheckPOM(errorList.get(1).get(i), errorList.get(0).get(i));

				
			}
		}
	}
}
