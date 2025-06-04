package com.scripts.noen.CustomerProfileTC;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CustomerProfileTC.TopNavigation_Customers;
import com.pageFactory.desktopReception.customerProfile_AddViewDeleteMessage_PF;
import com.pageFactory.desktopReception.login_PF;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class TC6413_14_CustomerProfileViewAndRemoveNotes extends BaseTest{
	private TopNavigation_Customers objTopNavCustomer;
	private login_PF objlogin_PF;
	customerProfile_AddViewDeleteMessage_PF objcustomerProfile_AddViewDeleteMessage_PF;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");
		objTopNavCustomer = new TopNavigation_Customers(this);
		objcustomerProfile_AddViewDeleteMessage_PF = new customerProfile_AddViewDeleteMessage_PF(this);
		objlogin_PF = new login_PF(this);
	}

	@Title("Test6413_14")
	@Description("Customer Profile_Edit ,view and Remove Notes ")
	@Test()
	public void tc6413_editRemoveNoteOnCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objcustomerProfile_AddViewDeleteMessage_PF.navigateToCustomerTab();
		objcustomerProfile_AddViewDeleteMessage_PF.findCustomer();
		objTopNavCustomer.verifyCustomerProfileTab("Notes");
		objTopNavCustomer.navigateToCustomerProfileTab("Notes");

		objTopNavCustomer.verifyReadiButtonOnCustProfileNotesScreen("Active");
		objTopNavCustomer.verifyReadiButtonOnCustProfileNotesScreen("Deleted");
		objTopNavCustomer.verifyReadiButtonOnCustProfileNotesScreen("All");

		objTopNavCustomer.verifyeditNotebutton();
		objTopNavCustomer.editNote();

		objcustomerProfile_AddViewDeleteMessage_PF.verifyPageHeader("Customer Note");

		objTopNavCustomer.verifyTypeDropdownDisplayed();
		//objTopNavCustomer.verifyLabel("Type");
		objTopNavCustomer.verifyLabel("Applications");
		objTopNavCustomer.verifyapplicationInputBoxDisplayed();
		objTopNavCustomer.verifyLabel("GamingDate");
		objTopNavCustomer.verifyLabel("Actual Date / Time");
		objTopNavCustomer.verifyLabel("Date Deleted");
		objTopNavCustomer.verifyLabel("Created At");
		objTopNavCustomer.verifyLabel("Created By");

		objTopNavCustomer.setNoteDetails("Automation Test purpose only");
		objcustomerProfile_AddViewDeleteMessage_PF.clickOk();
		objTopNavCustomer.verifyEditedNoteDisplayedOnTable("Automation Test purpose only");
		

		objTopNavCustomer.verifybutton("Delete");
		objTopNavCustomer.clickbutton("Delete");
		
		objTopNavCustomer.verifyReadiButtonOnCustProfileNotesScreen("Deleted");
		objTopNavCustomer.clickReadiButtonOnCustProfileNotesScreen("Deleted");
		
		objTopNavCustomer.verifybutton("Undelete");

		//objlogin_PF.logout();
	}

	@AfterMethod()
	private void tearDown(ITestResult result) 
	{
		//tearDownWebEnvironment();
		objTopNavCustomer =  null;
		objlogin_PF = null;

	}
}
