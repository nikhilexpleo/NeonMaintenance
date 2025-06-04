package com.scripts.noen.CashierAndManagerTC;

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



public class Customers_IntelligentDatabase extends BaseTest
{
	private TopNavigation_Customers objTopNavCustomer;
	private login_PF objlogin_PF;
	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void checkCustomersIntelligentDatabase()
	{
		//create New Credit Account
		objTopNavCustomer = new TopNavigation_Customers(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTopNavCustomer.intelligenceDataBase(); // This covers View customer details.
	
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
