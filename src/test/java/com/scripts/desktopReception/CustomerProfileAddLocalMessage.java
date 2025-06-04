package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_AddViewDeleteMessage_PF;
import com.pageFactory.desktopReception.login_PF;

public class CustomerProfileAddLocalMessage extends BaseTest{

	private customerProfile_AddViewDeleteMessage_PF objcustomerProfile_AddViewDeleteMessage_PF;
	private login_PF objlogin_PF;
	
	@Test
	public void AddLocalMessageToCustomerProfile()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_AddViewDeleteMessage_PF= new customerProfile_AddViewDeleteMessage_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_AddViewDeleteMessage_PF.navigateToCustomerTab();
		objcustomerProfile_AddViewDeleteMessage_PF.findCustomer();
		objcustomerProfile_AddViewDeleteMessage_PF.clickMessageTab();
		objcustomerProfile_AddViewDeleteMessage_PF.clickOnAddMessage();
		objcustomerProfile_AddViewDeleteMessage_PF.addLocalMessageToCustAccount();
		//objcustomerProfile_AddViewDeleteMessage_PF.viewMessageDetails();
	//objcustomerProfile_AddViewDeleteMessage_PF.closeTab();
	//	objlogin_PF.logout();	
		
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objcustomerProfile_AddViewDeleteMessage_PF = null;
		objlogin_PF = null;
	}
}


