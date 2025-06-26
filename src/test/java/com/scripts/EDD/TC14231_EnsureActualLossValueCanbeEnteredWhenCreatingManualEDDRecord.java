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

public class TC14231_EnsureActualLossValueCanbeEnteredWhenCreatingManualEDDRecord extends BaseTest
{
	private customerProfile_AddViewDueDiligence_PF objcustomerProfile_AddViewDueDiligence_PF;
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_AddViewDueDiligence_PF = new customerProfile_AddViewDueDiligence_PF(this);	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objlogin_PF = new login_PF(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14231")
	@Description("Ensure the Actual Loss Value can be entered when creating a manual EDD record ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14231_SetActualLossValueCanbeEnteredWhenCreatingManualEDDRecord(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		//objCustomerProfile_Suspension.findCustomerByUsingNumber(getObjUtilities().dpString("CustomerNumber"));
		objCustomerProfile_Suspension.findCustomerByUsingNumber("1957866533");
		objCustomerProfile_Suspension.clickOnfindButton();
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Due Diligence");
		objcustomerProfile_AddViewDueDiligence_PF.createNewDueDiligenceByClickingAddButton();
		objCustomerProfile_Suspension.verifyPageTitle("Create New Due Diligence");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Reason For Creation");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Reason");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Loss Value");
		//objcustomerProfile_AddViewDueDiligence_PF.selectReasonForCreation(getObjUtilities().dpString("Reason"));
		objcustomerProfile_AddViewDueDiligence_PF.selectReasonForCreation("Periodic Review");
		objcustomerProfile_AddViewDueDiligence_PF.setReason();
		//objcustomerProfile_AddViewDueDiligence_PF.setLossValue(getObjUtilities().dpString("Loss Value"));
		objcustomerProfile_AddViewDueDiligence_PF.setLossValue("1");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		//objcustomerProfile_AddViewDueDiligence_PF.verifyLossValueDisplayedOnEDDRecord(getObjUtilities().dpString("Loss Value"));
		objcustomerProfile_AddViewDueDiligence_PF.verifyLossValueDisplayedOnEDDRecord("1");
	}
	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objcustomerProfile_AddViewDueDiligence_PF = null;
		objlogin_PF = null;
	}
}
