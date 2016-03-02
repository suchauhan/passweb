package com.ctl.it.qa.sfa.tools.pages.opty;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class CreditCheckPage  extends SfaPage{

	@FindBy(name="j_id0:j_id2:j_id3:j_id31:j_id32")
	 public WebElementFacade btn_close; 

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_close;
	}
}
