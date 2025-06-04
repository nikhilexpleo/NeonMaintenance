package com.scripts.desktopReception;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.customerProfile_AddSuspendedSuspension_PF;
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.login_PF;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class customerProfile_AddSuspendedSuspension extends BaseTest
{
	private customerProfile_AddSuspendedSuspension_PF objcustomerProfile_AddSuspendedSuspension_PF;
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	
	public void setEnviorment()
	{	
		initializeWebEnvironment("Neon");	
		objcustomerProfile_AddSuspendedSuspension_PF= new customerProfile_AddSuspendedSuspension_PF(this);
		objlogin_PF = new login_PF(this);
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
	}
	
	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/CustomerDetails");
		return testData;
	}

	@Title("Test 6421")
	@Description("Customer Profile_Add/edit/view new suspension - Suspended")
	@Test(dataProvider = "TestDataProvider")
	public void tc6421_addEditLiftSuspendedSuspensionToCustomerProfile(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
	
	/*@Test(priority = 0)
	public void addEditLiftSuspendedSuspensionToCustomerProfile()
	{*/
		
		objlogin_PF.login();
		objcustomerProfile_AddSuspendedSuspension_PF.navigateToCustomerTab();
	//	objcustomerProfile_AddSuspendedSuspension_PF.findCustomer(getObjUtilities().dpString("CustomerNumber"));
		objCustomerProfile_Suspension.findCustomerByUsingNumber(getObjUtilities().dpString("CustomerNumber"));
		//objCustomerProfile_Suspension.findCustomerByUsingNumber("1955155551");
		objCustomerProfile_Suspension.clickOnfindButton();
		objcustomerProfile_AddSuspendedSuspension_PF.clickSuspensionsTab();
		objcustomerProfile_AddSuspendedSuspension_PF.add_SuspendedSuspensionToCustAccount();
		objcustomerProfile_AddSuspendedSuspension_PF.viewSuspensioDetails();
		objcustomerProfile_AddSuspendedSuspension_PF.liftSuspension();
		objcustomerProfile_AddSuspendedSuspension_PF.viewSuspensioDetails();
		objcustomerProfile_AddSuspendedSuspension_PF.closeTab();	
		objlogin_PF.logout();	
		
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objcustomerProfile_AddSuspendedSuspension_PF = null;
	}
}
