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
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.login_PF;

public class TC14250_VerifyAnEDDChangesToAwaitingApprovalWhenUserDoesntHaveCorrectAuthorisationLimit extends BaseTest
{
	private customerProfile_AddViewDueDiligence_PF objcustomerProfile_AddViewDueDiligence_PF;
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_AddViewDueDiligence_PF = new customerProfile_AddViewDueDiligence_PF(this);	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
		
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14250")
	@Description("Verify an EDD changes to Awaiting Approval when user doesn’t have correct authorisation limit ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14250_VerifyAnEDDChangesToAwaitingApproval(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objCommonView.login(getObjUtilities().dpString("UserName"), getObjUtilities().dpString("Password"));
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(getObjUtilities().dpString("CustomerNumber"));
		//objCustomerProfile_Suspension.findCustomerByUsingNumber("1955155551");
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
		objcustomerProfile_AddViewDueDiligence_PF.verifyLossValueDisplayedOnEDDRecord(getObjUtilities().dpString("Loss Value"));
	
	//	objcustomerProfile_AddViewDueDiligence_PF.ClickOnDetailsButton();
		objcustomerProfile_AddViewDueDiligence_PF.verifyAddOutcomeButton();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnAddOutcomeButton();
		
		objcustomerProfile_AddViewDueDiligence_PF.selectReasonForReview("Other");
		//Retain
		objcustomerProfile_AddViewDueDiligence_PF.setDecision("End Relationship");
		objcustomerProfile_AddViewDueDiligence_PF.setRationaleforDecisionDetails();
		objcustomerProfile_AddViewDueDiligence_PF.selectCustomerRiskAssessment("Low");
		
		
		objcustomerProfile_AddViewDueDiligence_PF.saveDuediligenceRecord();
		objCommonView.verifyConfirmationMessage("Are you sure you want to send this record for approval? Press");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnYes();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		
		String status = objcustomerProfile_AddViewDueDiligence_PF.getDueDiligenceStatus();
		System.out.println("status : "+status);
		objCustomerProfile_Suspension.verifyValueDisplayCorrectlyOrNot(status,"Awaiting Approval");
	}
	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objcustomerProfile_AddViewDueDiligence_PF = null;
		objlogin_PF = null;
	}
}
