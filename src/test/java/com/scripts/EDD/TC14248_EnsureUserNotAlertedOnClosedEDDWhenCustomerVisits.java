package com.scripts.EDD;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerEntry_UsingDOBName_PF;
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.login_PF;

public class TC14248_EnsureUserNotAlertedOnClosedEDDWhenCustomerVisits extends BaseTest{
	
	private CustomerEntry_UsingDOBName_PF objCustomerEntry_UsingDOBName_PF;
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private customerProfile_AddViewDueDiligence_PF objcustomerProfile_AddViewDueDiligence_PF;
	private CommonView objCommonView;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objlogin_PF = new login_PF(this);
		objCustomerEntry_UsingDOBName_PF = new CustomerEntry_UsingDOBName_PF(this);
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objcustomerProfile_AddViewDueDiligence_PF = new customerProfile_AddViewDueDiligence_PF(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14248")
	@Description(" Ensure user is not alerted on a closed EDD when a customer visits ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14248_VerifyUserNotAlertedOnClosedEDDWhenCustomerVisits(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(getObjUtilities().dpString("CustomerNumber"));
		//objCustomerProfile_Suspension.findCustomerByUsingNumber("1955158948");
		objCustomerProfile_Suspension.clickOnfindButton();
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Due Diligence");
		objcustomerProfile_AddViewDueDiligence_PF.createNewDueDiligenceByClickingAddButton();
		objCustomerProfile_Suspension.verifyPageTitle("Create New Due Diligence");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Reason For Creation");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Reason");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Loss Value");
		objcustomerProfile_AddViewDueDiligence_PF.selectReasonForCreation(getObjUtilities().dpString("Reason"));
		objcustomerProfile_AddViewDueDiligence_PF.setReason();
		objcustomerProfile_AddViewDueDiligence_PF.setLossValue(getObjUtilities().dpString("Loss Value"));
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		
		objcustomerProfile_AddViewDueDiligence_PF.verifyAddOutcomeButton();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnAddOutcomeButton();
		
		objcustomerProfile_AddViewDueDiligence_PF.selectReasonForReview("Other");
		//Retain
		objcustomerProfile_AddViewDueDiligence_PF.setDecision("End Relationship");
		objcustomerProfile_AddViewDueDiligence_PF.setRationaleforDecisionDetails();
		objcustomerProfile_AddViewDueDiligence_PF.selectCustomerRiskAssessment("Low");
		
		
		objcustomerProfile_AddViewDueDiligence_PF.saveDuediligenceRecord();
		//objCommonView.verifyConfirmationMessage("Are you sure you want to send this record for approval? Press");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnYes();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		
	
		
		objCustomerEntry_UsingDOBName_PF.clickOnCustomerTab();
		objCustomerEntry_UsingDOBName_PF.clickOnreceptionTab();
		objCustomerEntry_UsingDOBName_PF.searchCustomerInReception(getObjUtilities().dpString("CustomerNumber"));
		
		//objCustomerEntry_UsingDOBName_PF.verifyEDDMessageDisplayWhileLogVisit("Allow entry. Inform the duty manager - Open EDD file, 1st visit.");
		if(objCustomerEntry_UsingDOBName_PF.verifyConfirmationMessage("Customer has already visited today, enter again?"))
		{
			objcustomerProfile_AddViewDueDiligence_PF.clickOnYes();
		}
		//objCustomerEntry_UsingDOBName_PF.verifyMessageWindowDoesNotDisplay();
		
	}
	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerEntry_UsingDOBName_PF = null;
		objlogin_PF = null;
	}
}
