package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import net.thucydides.core.annotations.Step;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.DealInformationPage;

@SuppressWarnings("serial")
public class DealInformationSteps extends PasswebSteps{

	DealInformationPage dealInfoPage;
	
	@Step
	public void addCompetitorInfo() 
	{
		dealInfoPage.tbx_compCompanyGrid.click();
		dealInfoPage.tbx_compCompany.type("Heifer");
		dealInfoPage.tbx_compPositionGrid.click();
		dealInfoPage.tbx_compPosition.type("Product Specialist");
	}

}
