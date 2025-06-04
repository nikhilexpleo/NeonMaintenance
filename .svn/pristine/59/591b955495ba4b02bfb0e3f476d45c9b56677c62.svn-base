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

public class TC14244_incidentCreatedAsProblemGamblingReinstatementRequest extends BaseTest{
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

	@Title("Test 14244")
	@Description(" Ensure an Incident can be created as a Problem Gambling Conversation  ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14253_createIncidentAsProblemGamblingConversation(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.clickOnCustomerMainMenu();
		objCustomerProfile_Incidents.navigateToincidentTab();
		objCustomerProfile_Incidents.ClickNewIncidentButton();

		objCommonView.createIncident("Problem Gambling Reinstatement Request");

		objCommonView.addParticipantToIncident(getObjUtilities().dpString("CustomerNumber"));
		//objCommonView.addParticipantToIncident("1955155549");

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
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Q1");
		objCustomerProfile_Incidents.setText("0");	
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Q2");
		objCustomerProfile_Incidents.setText("1");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Q3");
		objCustomerProfile_Incidents.setText("2");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Q4");
		objCustomerProfile_Incidents.setText("3");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Q5");
		objCustomerProfile_Incidents.setText("4");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Previous Reinstatements?");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Recommend Reinstatement?");
		objCustomerProfile_Incidents.selectDropdownOption("6","No");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Preferred Contact Method");
		objCustomerProfile_Incidents.selectDropdownOption("7","Email");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("INFORMATION CENTRE ONLY");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Reinstated?");
		objCustomerProfile_Incidents.selectDropdownOption("9","No");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Decision Made By");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("If Not Yes, Why Not?");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Previous Self-Exclusions");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Previous SE Ended");
		
	
		
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
