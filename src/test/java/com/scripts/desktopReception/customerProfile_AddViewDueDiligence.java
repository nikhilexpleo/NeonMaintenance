package com.scripts.desktopReception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CustomerProfileTC.TopNavigation_Customers;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.customerProfile_AddViewDeleteMessage_PF;
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.login_PF;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import views.CommonView;

public class customerProfile_AddViewDueDiligence extends BaseTest{

	private customerProfile_AddViewDueDiligence_PF objcustomerProfile_AddViewDueDiligence_PF;
	private login_PF objlogin_PF;
	private TopNavigation_Customers objTopNavCustomer;
	customerProfile_AddViewDeleteMessage_PF objcustomerProfile_AddViewDeleteMessage_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_AddViewDueDiligence_PF = new customerProfile_AddViewDueDiligence_PF(this);
		objcustomerProfile_AddViewDeleteMessage_PF = new customerProfile_AddViewDeleteMessage_PF(this);
		objTopNavCustomer = new TopNavigation_Customers(this);
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}
	
	@Title("Test 6431 and 6693")
	@Description("Adding Due Diligence for a customer and Manager_Due Diligence_002")
	@Test(priority = 2)
	public void AddViewDueDiligenceDetailsToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		//add actual loss value
		objcustomerProfile_AddViewDeleteMessage_PF.navigateToCustomerTab();
		objcustomerProfile_AddViewDeleteMessage_PF.findCustomer();
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Due Diligence");		
		objcustomerProfile_AddViewDueDiligence_PF.verifyDueDligenceTableHeadersOnCustomerProfile();
		objcustomerProfile_AddViewDueDiligence_PF.createNewDueDiligenceByClickingAddButton();
		objCustomerProfile_Suspension.verifyPageTitle("Create New Due Diligence");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Reason For Creation");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Reason");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Loss Value");
		objcustomerProfile_AddViewDueDiligence_PF.selectReasonForCreation("Periodic Review");
		objcustomerProfile_AddViewDueDiligence_PF.setReason();
		objcustomerProfile_AddViewDueDiligence_PF.setLossValue("5");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		//objcustomerProfile_AddViewDueDiligence_PF.verifyLossValueDisplayedOnEDDRecord("5");

		
		//deatils section
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();	
		String BusinessRelationshipStartDate =  dateFormat.format(date);
		System.out.println(BusinessRelationshipStartDate);
		
		objcustomerProfile_AddViewDueDiligence_PF.setEnterBusinessRelationshipStartDate(BusinessRelationshipStartDate);
		objcustomerProfile_AddViewDueDiligence_PF.setOccupation("Manager");
		objcustomerProfile_AddViewDueDiligence_PF.setPositionHeld("test position");
		objcustomerProfile_AddViewDueDiligence_PF.setEmployer("Test");
		objcustomerProfile_AddViewDueDiligence_PF.setBusinessAddress("test purpose only");
		objcustomerProfile_AddViewDueDiligence_PF.setPropertyMarketValue("5");
		objcustomerProfile_AddViewDueDiligence_PF.selectPropertyType("Hotel");
		//objcustomerProfile_AddViewDueDiligence_PF.verifyInformationAsAtLabel();
		objcustomerProfile_AddViewDueDiligence_PF.setSourceofFunds("test purpose");
		objcustomerProfile_AddViewDueDiligence_PF.setSourceofInformation("test");
		objcustomerProfile_AddViewDueDiligence_PF.setEvidencetosupportsourceoffunds("Automation test purpose only");
		
		//add attachment
		objcustomerProfile_AddViewDueDiligence_PF.verifyAttachmentTableHeaders();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnAddButtonFromAttachmentSection();
		objCustomerProfile_Suspension.verifyPageTitle("Add Attachment");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Type");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("File Name");
		objcustomerProfile_AddViewDueDiligence_PF.selectTypeFromDropdown();
		objcustomerProfile_AddViewDueDiligence_PF.setDescription();
		objcustomerProfile_AddViewDueDiligence_PF.addFileAsAttachment();

		objcustomerProfile_AddViewDueDiligence_PF.switchToALertNClick();
		
		//add next step
		objcustomerProfile_AddViewDueDiligence_PF.verifyNextStepHeaders();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnAddNextStepButton();
		objCustomerProfile_Suspension.verifyPageTitle("Add Next Step");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Next Step");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Casino");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("As At Date");
		objcustomerProfile_AddViewDueDiligence_PF.addNextStepDetails("Test");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		
		
		//add coversation
		objcustomerProfile_AddViewDueDiligence_PF.verifyConversationTableHeaderDetails();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnAddConversationButton();
		objCustomerProfile_Suspension.verifyPageTitle("Add Conversation");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("User");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Casino");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("As At Date");
		objcustomerProfile_AddViewDueDiligence_PF.AddRecordOfConversation("Test");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		
		objcustomerProfile_AddViewDueDiligence_PF.saveDuediligenceRecord();

		objCommonView.verifyConfirmationMessage("This record has been saved successfully.");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
				
		//objlogin_PF.logout();
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF =null;
		objcustomerProfile_AddViewDueDiligence_PF =null;
	}
}


