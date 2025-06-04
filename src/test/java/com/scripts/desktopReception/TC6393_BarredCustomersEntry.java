package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.Reception_Entry_PF;
import com.pageFactory.desktopReception.login_PF;

import ru.yandex.qatools.allure.annotations.Title;

public class TC6393_BarredCustomersEntry extends BaseTest{


	private Reception_Entry_PF objReception_Entry_PF;
	private login_PF objlogin_PF;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");
		objReception_Entry_PF= new Reception_Entry_PF(this);
		objlogin_PF = new login_PF(this);
	}
	@Title("TC6393_BarredCustomersEntry  & 6380 | Logging a suspended customer  ")
	@Test
	public void TC6393_VerifyBarredCustomersEntry()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objReception_Entry_PF.navigateToReceptionTab();;
		objReception_Entry_PF.suspendedCustomer();
		
		objlogin_PF.logout();	
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objReception_Entry_PF = null;
		objlogin_PF = null;
	}
}
