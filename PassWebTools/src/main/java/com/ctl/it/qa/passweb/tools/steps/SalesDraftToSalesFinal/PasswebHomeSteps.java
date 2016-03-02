package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebAddProductPage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PassWebHomePage;
import com.ctl.it.qa.passweb.tools.pages.SalesDraftToSalesFinal.PasswebPage;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.thucydides.core.annotations.Step;


public class PasswebHomeSteps extends PasswebSteps {

	
	PassWebHomePage passWebHomePage;
	PassWebAddProductPage addProductPage;
	
	
	
	
	@Step
	public void searchNSP()
	{
		passWebHomePage.getNSP("tbx_NSP_Number");
	}
		
	@Step
	public void loadNSP()
	{
		passWebHomePage.ddl_NSPSearchValue.click();
		waitABit(20000);
		
	}
	
	@Step
	public void createNSPInPASS()
	{
		if(passWebHomePage.lbl_createNSPDialog.isVisible())
		{
			passWebHomePage.btn_createNSP.click();
			System.out.println("Create New NSP Dialog box appeared, Clicking Submit");
			waitABit(4000);
		}
	}
	
	@Step
	public void logout()
	{
		passWebHomePage.btn_logout.click();
		waitABit(2000);
	}
	
	@Step
	public void importQVOQuote()
	{
		passWebHomePage.btn_actions.click();
		passWebHomePage.ddl_importQuote.click();
		passWebHomePage.cbx_QVO.click();
		passWebHomePage.get_qvoquote();
		passWebHomePage.btn_Submit.click();
		waitABit(40000);
	}
	
	@Step
	public void importPPQuote(String product)
	{
		
		passWebHomePage.btn_actions.click();
		passWebHomePage.ddl_importQuote.click();
		passWebHomePage.get_ppquote();
		passWebHomePage.cbx_IQ_Networking.click();
		passWebHomePage.tbx_product.type(product);
		passWebHomePage.btn_Submit.click();
		//passWebHomePage.waitFor("lbl_import");
		waitABit(50000);
	}
	
	@Step
	public void doclone()
	{
		passWebHomePage.btn_actions.click();
		passWebHomePage.ddl_cloneversion.click();
		waitABit(30000);
	}
	
	@Step
	public void moveBacktoInitialVersion()
	{
		passWebHomePage.ddl_versionlist.click();
		passWebHomePage.ddl_initialversion.click();
		waitABit(30000);
		
	}

	
	@Step
	public void checkimportPPandQVOQuote_status()
	{
		Assert.assertEquals("Import Success", passWebHomePage.lbl_messagebox.getText());
		passWebHomePage.btn_OK.click();
	}
	
	@Step
	public void checkcloningoperation()
	{
		System.out.println(passWebHomePage.lbl_messagebox.getText());
		Assert.assertEquals("New version created successfully.", passWebHomePage.lbl_messagebox.getText());
	}
	
	@Step
	public void addProduct(String Entity, String Product) 
	{
		//addProductPage.shouldExist(addProductPage);
		System.out.println("enter add product");
		passWebHomePage.btn_actions.click();
		//addProductPage.btn_action.click();
		addProductPage.ddl_actionsList.click();
		waitABit(1000);
		addProductPage.ddl_entity_list.click();
	    waitABit(2000);
		passWebHomePage.getList(Entity);
		waitABit(5000);
		addProductPage.ddl_product_list.click();
		waitABit(2000);
		//addProductPage.ddl_product_list_val.click();
		passWebHomePage.getList(Product);
		addProductPage.tbx_rowcount.type("1");
		addProductPage.btn_submitProduct.click();
		System.out.println("Product Added Successfully");
		waitABit(40000);
	}
	
	
	@Step
	public void submitToPom(String btn_submit_cancel)
	{
		passWebHomePage.btn_actions.click();
		clickButton("Submit to POM");
		waitABit(3000);
		switchTOWindow();
		if(passWebHomePage.btn_ConfirmSubmit.isVisible())
		{
			click_SubmitOrCancel(btn_submit_cancel);
			waitABit(2000);
		
		}
		else if(passWebHomePage.lbl_congratulationMessage.isVisible())
		{
			getDriver().findElement(By.xpath("//span[text() = 'OK']")).click();
			waitABit(2000);
		}
		if(passWebHomePage.lbl_nspStatusChangedMsg.isVisible())
		{
			getDriver().findElement(By.xpath("//span[text() = 'OK']")).click();
			System.out.println(getDriver().findElement(By.xpath("//div[contains(@id,'dataview')]/div[1]/div[1]")).getText());
			System.out.println(getDriver().findElement(By.xpath("//div[contains(@id,'dataview')]/div[1]/div[2]")).getText());
		}
	}
	
	@Step
	public boolean checkNSPStatus()
	{
		waitABit(5000);
		System.out.println( passWebHomePage.lbl_versionStatus.getText());
		Assert.assertEquals("Sales Final", passWebHomePage.lbl_versionStatus.getText());
		return true;
	}

	public void click_SubmitOrCancel(String btn_submit_cancel)
	{
		getDriver().findElement(By.xpath("//div[starts-with(@id, 'confirmwarningsubmitwindow')]//span[text() = '"+btn_submit_cancel+"']")).click();
	}
}
