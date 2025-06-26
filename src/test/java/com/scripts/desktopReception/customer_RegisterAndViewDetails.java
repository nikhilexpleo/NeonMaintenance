package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.generic.BaseTest;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.customer_RegisterAndViewDetails_PF;


public class customer_RegisterAndViewDetails extends BaseTest
{
	private customer_RegisterAndViewDetails_PF objneonReg_PF;
	private login_PF objlogin_PF;
	
		//@Test(priority = 0,invocationCount =2)
	@Test(priority = 1)
	public void RegisterAndViewCustomerDetails()
	{
		initializeWebEnvironment("Neon");
		objneonReg_PF = new customer_RegisterAndViewDetails_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objneonReg_PF.registration();
		objneonReg_PF.viewCustomerDetails();
		objlogin_PF.logout();	
	}
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objneonReg_PF = null;
		objlogin_PF = null;

	}
}
