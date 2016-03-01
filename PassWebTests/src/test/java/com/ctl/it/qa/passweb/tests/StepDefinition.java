package com.ctl.it.qa.passweb.tests;

import net.serenitybdd.core.Serenity;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.xml.reader.XMLDataWriter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class StepDefinition {

	@Before
	public void beforeEveryScenario() {

	}
	
	@After
	public void afterEveryScenario() {
		Steps.isInitialized = false;
		Page.isInitialized = false;
	}

	@Then("^I save \"([^\"]*)\" as \"([^\"]*)\" in data xml$")
	public void i_should_save_as_in_data_xml(String variableName, String tagName)
			throws Throwable {
		Page.envData.getContainer("RefreshData").setFieldValue(tagName, Serenity.sessionVariableCalled(variableName).toString());
		new XMLDataWriter().writeXML(Page.data, "C:\\data.xml");
	}
}
