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
import com.pageFactory.desktopReception.login_PF;



public class CustomerProfile_ViewAllTransactions extends BaseTest
{
	private TopNavigation_Customers objTopNavCustomer;
	private login_PF objlogin_PF;
	@Title("Customer  transcation details  ")
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void checkCustomerProfileViewAllTransactions()
	{
		//create New Credit Account
		objTopNavCustomer = new TopNavigation_Customers(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTopNavCustomer.viewAllTransactions();
		objlogin_PF.logout();
		tearDown();
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
	
	}
}
