package com.scripts.EDD;

import java.lang.reflect.Method;
import java.util.Hashtable;

//import org.junit.AfterClass;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Incidents;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerDueDiligenceFilter_PF;
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.login_PF;

public class TC14241_incidentCreatedAsEnforcedExclusion extends BaseTest{

	private CustomerProfile_Incidents objCustomerProfile_Incidents;
	
	private customerProfile_AddViewDueDiligence_PF objcustomerProfile_AddViewDueDiligence_PF;
	private login_PF objlogin_PF;
	private CustomerDueDiligenceFilter_PF objCustomerDueDiligenceFilter_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerDueDiligenceFilter_PF = new CustomerDueDiligenceFilter_PF(this);
		objcustomerProfile_AddViewDueDiligence_PF = new customerProfile_AddViewDueDiligence_PF(this);	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objlogin_PF = new login_PF(this);
		objCustomerProfile_Incidents = new CustomerProfile_Incidents(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14241")
	@Description(" Ensure an Incident can be created as a Enforced Exclusion ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14255_createIncidentAsEnforcedExclusion(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(getObjUtilities().dpString("CustomerNumber"));
		//objCustomerProfile_Suspension.findCustomerByUsingNumber("1955155549");
		objCustomerProfile_Suspension.clickOnfindButton();
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Incidents");
		objCustomerProfile_Incidents.clickOnAddButton();
		
		objCustomerProfile_Suspension.verifyPageTitle("Select New Incident Type");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Group");
		objCustomerProfile_Incidents.selectGroupFromDropdown();
		objCustomerProfile_Incidents.selectIncidentTypeFromDropdown("Enforced Exclusion");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		objCustomerProfile_Incidents.verifyIncidentTitle("Enforced Exclusion");
	
		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Associated Incidents");
		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Audit");
		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Evidence");
		
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Incident Number");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Actual Date / Time");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Gaming Date");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Category");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Status");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Date Closed");
		
		objCustomerProfile_Incidents.selectCasinoDropdownOptionFromIncidentPage("_SAW 1");
		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Details");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Notes");
		objCustomerProfile_Incidents.setNotes();
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("User");
		
		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Participants");
		objCustomerProfile_Incidents.verifyParticipantTableHeaders();
		objCustomerProfile_Incidents.verifyParticipantTableContent(getObjUtilities().dpString("CustomerNumber"));
		//objCustomerProfile_Incidents.verifyParticipantTableContent("1955155549");
		
		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Additional Info");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Were the Police Called?");
		objCustomerProfile_Incidents.selectWerePoliceCalled();
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Method of Exclusion");
		objCustomerProfile_Incidents.selectMethodofExclusion();
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Player Type");
		objCustomerProfile_Incidents.selectPlayerType("2");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Risk Rating");
		objCustomerProfile_Incidents.selectRiskRating("3");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Exclusion Term (Months)");
		objCustomerProfile_Incidents.setExclusionTermMonths();
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Exclude from Digital?");
		objCustomerProfile_Incidents.selectExcludefromDigital();
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("SENSE Rejection Reason");
		objCustomerProfile_Incidents.selectSENSERejectionReason();
	
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("SENSE URN No (or NA)");
		objCustomerProfile_Incidents.setSENSEURNNO();
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("SENSE Application Method");
		objCustomerProfile_Incidents.selectSENSEApplicatioMethod();
		
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
