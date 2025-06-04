package com.scripts.noen.CustomerProfileTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.CashierManagerTC.SideNavigation_Transaction;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.CustomerProfileTC.TopNavigation_Customers;
import com.pageFactory.desktopReception.customerProfile_AddViewDeleteMessage_PF;
import com.pageFactory.desktopReception.login_PF;



public class CustomerProfile_AddViewEditRemoveNote extends BaseTest
{
	private TopNavigation_Customers objTopNavCustomer;
	private login_PF objlogin_PF;
	customerProfile_AddViewDeleteMessage_PF objcustomerProfile_AddViewDeleteMessage_PF;


	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")

	@BeforeClass
	private void setUp(){

		initializeWebEnvironment("Neon");
		objTopNavCustomer = new TopNavigation_Customers(this);
		objcustomerProfile_AddViewDeleteMessage_PF = new customerProfile_AddViewDeleteMessage_PF(this);
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void addViewDeleteNote()
	{	
		objlogin_PF.login();
		objTopNavCustomer.addViewDeleteNote();

		objTopNavCustomer.checkCustDetails();
		objTopNavCustomer.navigateToNotesTab();



		//objcustomerProfile_AddViewDeleteMessage_PF.navigateToCustomerTab();
		//objcustomerProfile_AddViewDeleteMessage_PF.findCustomer();
		//objcustomerProfile_AddViewDeleteMessage_PF.clickMessageTab();
		objcustomerProfile_AddViewDeleteMessage_PF.clickOnAddMessage();
		objcustomerProfile_AddViewDeleteMessage_PF.verifyPageHeader("Customer Note");
		objTopNavCustomer.verifyapplicationInputBoxDisplayed();
		objTopNavCustomer.verifyTypeDropdownDisplayed();
		
	//	objTopNavCustomer.verifyLabel("Type");
		objTopNavCustomer.verifyTypeDropdownDisplayed();
		objTopNavCustomer.verifyLabel("Customer Note");
		objTopNavCustomer.verifyLabel("Applications");
		objTopNavCustomer.verifyLabel("GamingDate");
		objTopNavCustomer.verifyLabel("Actual Date / Time");
		objTopNavCustomer.verifyLabel("Date Deleted");
		objTopNavCustomer.verifyLabel("Created At");
		objTopNavCustomer.verifyLabel("Created By");
		
		objcustomerProfile_AddViewDeleteMessage_PF.enterMessageDetailsInInputr("Test purpose only");
		objcustomerProfile_AddViewDeleteMessage_PF.clickOk();
		
		
		
		//objlogin_PF.logout();

	}
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();

	}
}
