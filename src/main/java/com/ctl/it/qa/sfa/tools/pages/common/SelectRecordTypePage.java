package com.ctl.it.qa.sfa.tools.pages.common;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class SelectRecordTypePage extends SfaPage {

	@FindBy(id = "p3")
	public WebElementFacade ddl_record_type_of_new_record;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_record_type_of_new_record;
	}

	public void selectRecordType(String recordType) {
		this.shouldExist(this);
		ddl_record_type_of_new_record.selectByVisibleText(recordType);
		btn_continue.click();
	}
}
