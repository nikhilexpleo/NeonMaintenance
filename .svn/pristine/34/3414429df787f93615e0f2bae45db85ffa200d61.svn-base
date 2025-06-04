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
import com.pageFactory.desktopReception.login_PF;

public class TC14263_VerifyCustomerSuspensionCanbeLifted_to_GroupwideBarredFailureEDD extends BaseTest{
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objCommonView = new CommonView(this);
		objlogin_PF = new login_PF(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14263")
	@Description("Verify a customer suspension can be lifted when set to Groupwide Barred Failure EDD ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14253_LiftSuepensionGroupwideBarredFailureEDD(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(getObjUtilities().dpString("CustomerNumber"));
		objCustomerProfile_Suspension.clickOnfindButton();
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Suspensions");
		objCommonView.liftSuspension(getObjUtilities().dpString("Authorised User"));
		
		String actualDateLifted = objCustomerProfile_Suspension.getLabelValue("Date Lifted");
		System.out.println("dateLifted "+actualDateLifted);
		
		String AuthorisedBy = objCustomerProfile_Suspension.getLabelValue("Authorised By");
		System.out.println("AuthorisedBy "+AuthorisedBy);
		
		String expectedDateLifted = this.getObjUtilities().getCurrentDate("dd/MM/yyyy");
		System.out.println("dateLifted "+expectedDateLifted);
		
		//objCustomerProfile_Suspension.verifyValueDisplayCorrectlyOrNot(actualDateLifted, expectedDateLifted);
		objCustomerProfile_Suspension.verifyValues(AuthorisedBy,getObjUtilities().dpString("Authorised User"));
		objCustomerProfile_Suspension.closeTab();
	}
	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objCommonView = null;
		objlogin_PF = null;
	}
}
