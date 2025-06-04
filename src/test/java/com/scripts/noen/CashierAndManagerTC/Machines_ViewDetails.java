package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.CashierManagerTC.SideNavigation_Transaction;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.CashierManagerTC.TopNavigation_PlayerTracking;
import com.pageFactory.CustomerProfileTC.TopNavigation_Customers;
import com.pageFactory.desktopReception.login_PF;



public class Machines_ViewDetails extends BaseTest
{
	private TopNavigation_PlayerTracking objTopNavCustomer;
	private login_PF objlogin_PF;
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test
	public void checkAndVerifyMachinesViewDetails()
	{
		//create New Credit Account
		objTopNavCustomer = new TopNavigation_PlayerTracking(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTopNavCustomer.viewMachineDetails(); // This covers View customer details.
	//	objTopNavCustomer.viewHospitalityTransaction();
		objlogin_PF.logout();
		tearDown();
		
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
	
	}
}
