package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.customerProfile_AddEditViewBarredSuspension_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_AddEditViewBarredsuspension extends BaseTest {

	private customerProfile_AddEditViewBarredSuspension_PF objcustomerProfile_AddEditViewsuspension_PF;;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void addBarredSuspensionToCustomerProfile()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_AddEditViewsuspension_PF= new customerProfile_AddEditViewBarredSuspension_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_AddEditViewsuspension_PF.navigateToCustomerTab();
		objcustomerProfile_AddEditViewsuspension_PF.findCustomer();
		objcustomerProfile_AddEditViewsuspension_PF.clickSuspensionsTab();
		objcustomerProfile_AddEditViewsuspension_PF.add_barredSuspensionToCustAccount();
		objcustomerProfile_AddEditViewsuspension_PF.clickOnOk();//snehal
		objcustomerProfile_AddEditViewsuspension_PF.clickOnCancel();//snehal
		/*objcustomerProfile_AddEditViewsuspension_PF.viewSuspensioDetails();
		objcustomerProfile_AddEditViewsuspension_PF.editSuspension();
		objcustomerProfile_AddEditViewsuspension_PF.viewSuspensioDetails();
		objcustomerProfile_AddEditViewsuspension_PF.closeTab();	*/
		objlogin_PF.logout();	
		//tearDown();
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objcustomerProfile_AddEditViewsuspension_PF = null;
		objlogin_PF = null;
	}
}
