package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.OpenCashDesk_PF;
import com.pageFactory.desktopReception.login_PF;

public class OpenCashDesk extends BaseTest{
	
	private OpenCashDesk_PF objOpenCashDesk_PF;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void OpenCashDesk()
	{
		initializeWebEnvironment("Neon");
		objOpenCashDesk_PF= new OpenCashDesk_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objOpenCashDesk_PF.openCashesk();
	}
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
	
	}
	
}
