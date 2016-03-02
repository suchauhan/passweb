package com.ctl.it.qa.sfa.tools.pages.opty;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import com.ctl.it.qa.sfa.tools.pages.SfaPage;

public class AddProductsForOptyPage extends SfaPage {
		
	@FindBy(id="00NF0000008PQDX01uF000000LJoI4")
	public WebElementFacade tbx_mrc;
	
	@FindBy(id="00NF0000008PQDd01uF000000LJoI4")
	public WebElementFacade tbx_otc;
	
	@FindBy(id="00NA0000005BwQZ01uF000000LJoI4")
	public WebElementFacade tbx_nrc;
	
	@FindBy(css = "input[value = ' Save ']")
	public WebElementFacade btn_save;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tbx_nrc;
	}
}
