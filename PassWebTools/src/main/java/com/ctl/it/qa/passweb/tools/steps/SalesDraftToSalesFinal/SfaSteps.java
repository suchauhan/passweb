package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import com.ctl.it.qa.sfa.tools.pages.common.SearchResultsPage;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

@SuppressWarnings("serial")
public abstract class SfaSteps extends Steps {

	SearchResultsPage searchResultsPage;

	public void open_search_results_page() {
		int i = 0;
		searchResultsPage.WaitForPageToLoad(60);
		searchResultsPage.btn_search.click();
		if (i < 3 && !searchResultsPage.isExist(searchResultsPage)) {
			searchResultsPage.btn_search.click();
			i++;
			waitABit(3000);
		}
	}
	
	public void switchtoWindow()
	{
		{
			for(String winHandle : getDriver().getWindowHandles()){
				getDriver().switchTo().window(winHandle);
			}
		}
	}

	public void open_record(String recordType, String recordName) {
		open_search_results_page();
		searchResultsPage.shouldExist(searchResultsPage);
		System.out.println("0");
		searchResultsPage.searchObject(recordType, recordName);
		System.out.println("1");
		searchResultsPage.selectResult(recordType, recordName);
		System.out.println("2");
		System.out.println("3");
		searchResultsPage.WaitForPageToLoad(120);
		System.out.println("4");
	}
	public IntDataContainer get_data_for_page(Page page) {

		commonData.getContainer(page.getClass().getSimpleName())
				.setActualValuesForAllContainers();
		return commonData.getContainer(page.getClass().getSimpleName());
	}
	
	public IntDataContainer get_container_from_xml(String... containers){
		IntDataContainer actualContainer= commonData;
		for(int i=0;i<containers.length;i++){
			actualContainer=actualContainer.getContainer(containers[i]);
		}
		return actualContainer;
	}

}
