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

public class TC14243_incidentCreatedAsProblemGamblingConversation extends BaseTest{
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

	@Title("Test 14243")
	@Description(" Ensure an Incident can be created as a Problem Gambling Conversation  ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14254_createIncidentAsProblemGamblingConversation(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.clickOnCustomerMainMenu();
		objCustomerProfile_Incidents.navigateToincidentTab();
		objCustomerProfile_Incidents.ClickNewIncidentButton();

		objCommonView.createIncident("Problem Gambling Conversation");

		//objCommonView.addParticipantToIncident(getObjUtilities().dpString("CustomerNumber"));
		objCommonView.addParticipantToIncident("1957866519");

		objCommonView.verifySideBarTabsFromIncident();
		objCommonView.verifyFieldLabelsFromIncidentPage();

		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Details");

		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Notes");
		objCustomerProfile_Incidents.setNotes();
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("User");

		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Participants");
		objCustomerProfile_Incidents.verifyParticipantTableHeaders();
		objCustomerProfile_Incidents.verifyParticipantTableContent(getObjUtilities().dpString("CustomerNumber"));
		//objCustomerProfile_Incidents.verifyParticipantTableContent("1955155549");

		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Check List");
		//objCustomerProfile_Incidents.verifyCheckListTable();

		objCustomerProfile_Incidents.verifySubsectionOnIncidentPage("Additional Info");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Action Taken");
		objCustomerProfile_Incidents.selectActionTakenDropDown();

		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Player Type");
		objCustomerProfile_Incidents.selectPlayerType("1");

		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Risk Rating");
		objCustomerProfile_Incidents.selectRiskRating("2");

		objCustomerProfile_Incidents.clickOnSaveButton();
		objCustomerProfile_Incidents.verifyConfirmationMessage("This record has been saved successfully");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();

		String incidentId = objCustomerProfile_Incidents.getIncidentNumber();
		System.out.println("incidentId :" +incidentId);
		
		objCustomerProfile_Suspension.closeTab();
		objCustomerProfile_Suspension.clickOnCustomerMainMenu();
		objCustomerProfile_Incidents.navigateToincidentTab();
		
		objCustomerProfile_Incidents.serchIncidentByIncidentNumber(incidentId);
		objCustomerProfile_Suspension.clickOnfindButton(); 
		
		objCustomerProfile_Incidents.verifyFindIncidentSearchResult(incidentId);	
	}
	@AfterMethod
	public void tearDown()
	{
		tearDownWebEnvironment();
		objcustomerProfile_AddViewDueDiligence_PF = null;
		objCustomerProfile_Incidents = null;
		objCustomerProfile_Suspension = null;
		objCommonView = null;
	}
}


