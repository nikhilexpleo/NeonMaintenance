package com.scripts.EDD;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerDueDiligenceFilter_PF;
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.login_PF;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import views.CommonView;

public class TC14245_EnsureUserCanAddAnAttachementToEDDRecord extends BaseTest{
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
		objCommonView = new CommonView(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14245")
	@Description(" Ensure user can add an attachement to a EDD record ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14231_AddNextStepToEDDRecord(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.clickOnCustomerMainMenu();
		objCustomerDueDiligenceFilter_PF.clickOnDueDiligence();
		//objCustomerDueDiligenceFilter_PF.searchRecordByNumber(getObjUtilities().dpString("CustomerNumber"));
		//objCustomerDueDiligenceFilter_PF.searchRecordByNumber("1957866621");
		objCustomerDueDiligenceFilter_PF.selectDateRange("Custom"); //Custom 
		objCustomerDueDiligenceFilter_PF.clickOnFromDate();
		objCustomerDueDiligenceFilter_PF.setFromDate("07/06/2023");
		objCustomerDueDiligenceFilter_PF.clickONFilter();
		objCustomerDueDiligenceFilter_PF.ClickOnDetailsButton();
		//Click on details
		objcustomerProfile_AddViewDueDiligence_PF.clickOnAddButtonFromAttachmentSection();
		objCustomerProfile_Suspension.verifyPageTitle("Add Attachment");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Type");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("File Name");
		objcustomerProfile_AddViewDueDiligence_PF.selectTypeFromDropdown();
		objcustomerProfile_AddViewDueDiligence_PF.setDescription();
		objcustomerProfile_AddViewDueDiligence_PF.addFileAsAttachment();

		//objcustomerProfile_AddViewDueDiligence_PF.switchToALertNClick();
//		objcustomerProfile_AddViewDueDiligence_PF.saveDuediligenceRecord();
//
//		objCommonView.verifyConfirmationMessage("This record has been saved successfully.");
//		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();

	}

	@AfterMethod
	private void tearDown(ITestResult result) {
			tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objcustomerProfile_AddViewDueDiligence_PF = null;
		objlogin_PF = null;
	}

}
