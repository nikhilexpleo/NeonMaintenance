package com.scripts.EDD;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Incidents;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerDueDiligenceFilter_PF;
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.login_PF;

public class TC14242_incidentCreatedAsPositiveAsCustomerUnderMonitoring extends BaseTest
{
	private CustomerProfile_Incidents objCustomerProfile_Incidents;
	private customerProfile_AddViewDueDiligence_PF objcustomerProfile_AddViewDueDiligence_PF;
	private login_PF objlogin_PF;
	private CustomerDueDiligenceFilter_PF objCustomerDueDiligenceFilter_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerDueDiligenceFilter_PF = new CustomerDueDiligenceFilter_PF(this);
		objcustomerProfile_AddViewDueDiligence_PF = new customerProfile_AddViewDueDiligence_PF(this);	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objlogin_PF = new login_PF(this);
		objCustomerProfile_Incidents = new CustomerProfile_Incidents(this);
		objCommonView = new CommonView(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14242")
	@Description(" Ensure an Incident can be created as a Customer Under Monitoring ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14256_createIncidentAsCustomerUnderMonitoring(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		//objCustomerProfile_Suspension.findCustomerByUsingNumber(getObjUtilities().dpString("CustomerNumber"));
		objCustomerProfile_Suspension.findCustomerByUsingNumber("1957866526");
		objCustomerProfile_Suspension.clickOnfindButton();
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Incidents");
		objCustomerProfile_Incidents.clickOnAddButton();
		//objCommonView.createIncident("Positive Assessment");
		objCustomerProfile_Suspension.verifyPageTitle("Select New Incident Type");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Group");
		objCustomerProfile_Incidents.selectGroupFromDropdown();
		objCustomerProfile_Incidents.selectIncidentTypeFromDropdown("Customer Under Monitoring");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		objCustomerProfile_Incidents.verifyIncidentTitle("Customer Under Monitoring");


		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Associated Incidents");
		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Audit");
		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Evidence");


		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Incident Number");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Actual Date / Time");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Gaming Date");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Category");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Status");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Date Closed");

		objCustomerProfile_Incidents.selectCasinoDropdownOptionFromIncidentPage("_Maidenhead (FF NT7)");
		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Details");

		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Notes");
		objCustomerProfile_Incidents.setNotes();
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("User");

		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Participants");
		objCustomerProfile_Incidents.verifyParticipantTableHeaders();
		//objCustomerProfile_Incidents.verifyParticipantTableContent(getObjUtilities().dpString("CustomerNumber"));
		objCustomerProfile_Incidents.verifyParticipantTableContent("1957866526");

//		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Additional Info");
//
//		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Action Taken");
//		objCustomerProfile_Incidents.selectActionTakenDropDown();
//
//
//		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Player Type");
//		objCustomerProfile_Incidents.selectPlayerType("1");
//
//		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Risk Rating");
//		objCustomerProfile_Incidents.selectRiskRating("2");

		objCustomerProfile_Incidents.clickOnSaveButton();
		objCustomerProfile_Incidents.verifyConfirmationMessage("This record has been saved successfully");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();

		String incidentId = objCustomerProfile_Incidents.getIncidentNumber();
		System.out.println("incidentId :" +incidentId);
	}
	@AfterMethod
	public void tearDown()
	{
		tearDownWebEnvironment();
		objcustomerProfile_AddViewDueDiligence_PF = null;
		objCustomerProfile_Incidents = null;
		objCustomerProfile_Suspension = null;
	}
}


