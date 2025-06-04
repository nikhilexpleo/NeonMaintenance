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
import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerEntry_UsingDOBName_PF;
import com.pageFactory.desktopReception.login_PF;

public class TC14247_EnsureUserAlertedCorrectlyOnOpenEDDCustomersFirstVisitInSameCasinoOnSameDay extends BaseTest{
	private CustomerEntry_UsingDOBName_PF objCustomerEntry_UsingDOBName_PF;
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objlogin_PF = new login_PF(this);
		objCustomerEntry_UsingDOBName_PF = new CustomerEntry_UsingDOBName_PF(this);
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14247")
	@Description(" Ensure user is alerted correctly on open EDD customers first visit in same casino on same day")
	@Test(dataProvider = "TestDataProvider")
	public void tc14231_VerifyUserAlertedWhenCustomrWithEDDAwaitingApproval(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerEntry_UsingDOBName_PF.clickOnCustomerTab();
		objCustomerEntry_UsingDOBName_PF.clickOnreceptionTab();
		objCustomerEntry_UsingDOBName_PF.searchCustomerInReception(getObjUtilities().dpString("CustomerNumber"));
		//objCustomerEntry_UsingDOBName_PF.searchCustomerInReception("1955158952");
		
		objCustomerProfile_Suspension.verifyPageTitle("Messages");
		objCustomerEntry_UsingDOBName_PF.verifyEDDMessageDisplayWhileLogVisit("Allow entry. Inform the duty manager - Open EDD file, 1st visit.");
		
		objCustomerEntry_UsingDOBName_PF.clikOnOk();
		objCustomerEntry_UsingDOBName_PF.clickOnYes();
	/*	objCustomerEntry_UsingDOBName_PF.searchCustomerInReception("195515544");
		//objCustomerEntry_UsingDOBName_PF.searchCustomerInReception(getObjUtilities().dpString("CustomerNumber"));
		objCustomerProfile_Suspension.verifyPageTitle("Messages");
		objCustomerEntry_UsingDOBName_PF.verifyEDDMessageDisplayWhileLogVisit("Allow entry. Inform the duty manager - Open EDD file, 2nd visit.");
		*/
	}
	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerEntry_UsingDOBName_PF = null;
		objlogin_PF = null;
	}
}

