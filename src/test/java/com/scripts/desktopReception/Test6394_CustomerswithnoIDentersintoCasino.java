package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.Reception_Entry_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6394_CustomerswithnoIDentersintoCasino extends BaseTest{

	private Reception_Entry_PF objReception_Entry_PF;
	private login_PF objlogin_PF;
	
	
	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objReception_Entry_PF= new Reception_Entry_PF(this);
		objlogin_PF = new login_PF(this);
	}
	@Test
	public void VerifyCustomerswithnoIDentersintoCasino()
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		objReception_Entry_PF.navigateToReceptionTab();
		objReception_Entry_PF.customerEntry();
	
		objReception_Entry_PF.closeTab();
		objlogin_PF.logout();	
		
	}
	
		// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
	
	}
}