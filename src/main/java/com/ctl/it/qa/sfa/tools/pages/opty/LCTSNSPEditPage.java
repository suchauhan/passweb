package com.ctl.it.qa.sfa.tools.pages.opty;

import java.util.Random;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.NSPEditPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LCTSNSPEditPage extends NSPEditPage {
	
	@FindBy(css = "input[id *='idnum']")
	public WebElementFacade tbx_id_number;

	@FindBy(xpath = "//label[. ='ID Number']")
	public WebElementFacade lbl_id_number;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lbl_id_number;
	}

	public void enterIdNumber() {
		Random r = new Random();
		int num = r.nextInt(999999 - 100000);
		num = num + 100000;
		tbx_id_number.type(Integer.toString(num));
	}
}
