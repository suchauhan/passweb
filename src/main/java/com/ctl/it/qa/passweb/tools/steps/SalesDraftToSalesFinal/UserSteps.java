package com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal;

import java.util.Map;

import net.thucydides.core.annotations.Step;

import com.ctl.it.qa.sfa.tools.pages.common.AllTabsPage;
import com.ctl.it.qa.sfa.tools.pages.common.HomePage;
import com.ctl.it.qa.sfa.tools.pages.common.LoginPage;
import com.ctl.it.qa.sfa.tools.pages.common.SSOLoginPage;
import com.ctl.it.qa.passweb.tools.steps.SalesDraftToSalesFinal.SfaSteps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

@SuppressWarnings("serial")
public class UserSteps extends SfaSteps {

	LoginPage loginPage;
	HomePage homePage;
	AllTabsPage allTabsPage;
	SSOLoginPage ssoLoginPage;

	public UserSteps() {
		initialize();
	}

	@Step
	public void try_logging_in_as(String userType) {
		loginPage.shouldExist(loginPage);
		loginPage.enterCredentials(userType);
		loginPage.btn_log_in_to_salesforce.click();
	}

	@Step
	public void logs_in_as(String userType) {
		loginPage.shouldExist(loginPage);
		loginPage.enterCredentials(userType);
		loginPage.btn_log_in_to_salesforce.click();
		loginPage.WaitForPageToLoad(100);
	}

	@Step
	public void is_in_sfa_login_page(String url) {
		loginPage.openAt(url);
		loginPage.maximize();
	}

	@Step
	public void should_be_on_home_page() {
		homePage.shouldExist(homePage);
	}

	@Step
	public void open_all_tabs_page() {
		//homePage.shouldExist(homePage);
		homePage.img_all_tabs.click();
	}

	@Step
	public void opens_page(String pageName) {
		open_all_tabs_page();
		allTabsPage.shouldExist(allTabsPage);
		allTabsPage.openPage(pageName);
	}

	@Step
	public void logs_out() {
		homePage.logout();
		loginPage.shouldExist(loginPage, 60);
	}

	@Step
	public void is_in_sso_login_page(String url) {
		loginPage.openAt(url);
		loginPage.maximize();
		loginPage.shouldExist(loginPage);
		loginPage.btn_centurylink_sso.click();
	}

	@Step
	public void logs_in_sso_as(String userType) {
		ssoLoginPage.shouldExist(ssoLoginPage);
		ssoLoginPage.enterCredentials(userType);
		ssoLoginPage.btn_login.click();
	}

	public void logs_in_using_name(String userName) {
		loginPage.shouldExist(loginPage);
		IntDataContainer userDetails = null;
		Map<String, IntDataContainer> users = get_data_for_page(loginPage)
				.getContainers();
		for (Map.Entry<String, IntDataContainer> user : users.entrySet()) {
			userDetails = user.getValue();
			if ((userDetails.getFieldValue("first_name") + " " + userDetails
					.getFieldValue("last_name")).equalsIgnoreCase(userName)) {
				logs_in_as(user.getKey());
				break;
			}
		}
	}

	public String getUserName(String userType) {
		String firstName = envData.getContainer("LoginPage")
				.getContainer(userType).getFieldValue("first_name");
		String lastName = envData.getContainer("LoginPage")
				.getContainer(userType).getFieldValue("last_name");
		return firstName + " " + lastName;
	}
}