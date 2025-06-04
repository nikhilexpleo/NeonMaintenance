package com.scripts.desktopReception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerDueDiligenceFilter_PF;
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.login_PF;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import views.CommonView;

public class TC6692_6694_ManagerDueDiligence_001_003 extends BaseTest{
	
	private customerProfile_AddViewDueDiligence_PF objcustomerProfile_AddViewDueDiligence_PF;
	private login_PF objlogin_PF;
	private CustomerDueDiligenceFilter_PF objCustomerDueDiligenceFilter_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerDueDiligenceFilter_PF = new CustomerDueDiligenceFilter_PF(this);
		objcustomerProfile_AddViewDueDiligence_PF = new customerProfile_AddViewDueDiligence_PF(this);	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}


	@Title("TC6692_6694 ")
	@Description(" Manager Due Diligence_001_003 -ADD OUTCOME ")
	@Test
	public void tc6692_AddoUTCOMEToEDDRecord() throws FileNotFoundException, IOException
	{
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.clickOnCustomerMainMenu();
		objCustomerDueDiligenceFilter_PF.clickOnDueDiligence();

		//objCustomerDueDiligenceFilter_PF.searchRecordByNumber("1955158939");

		Properties objConfig = new Properties();
		objConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties"));
		String	custNumber = objConfig.getProperty("web.CustomerNumber");
		System.out.println(" custNumber : "+custNumber);
		
		objCustomerDueDiligenceFilter_PF.searchRecordByNumber(custNumber);
		objCustomerDueDiligenceFilter_PF.selectState("Open");
		System.out.println("Open state has been select successfully");
		
		objCustomerDueDiligenceFilter_PF.clickONFilter();

		
		objcustomerProfile_AddViewDueDiligence_PF.verifyAddOutcomeButton();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnAddOutcomeButton();
		
		objcustomerProfile_AddViewDueDiligence_PF.selectReasonForReview("Other");
		//Retain
		objcustomerProfile_AddViewDueDiligence_PF.setDecision("End Relationship");
		objcustomerProfile_AddViewDueDiligence_PF.setRationaleforDecisionDetails();
		objcustomerProfile_AddViewDueDiligence_PF.selectCustomerRiskAssessment("Low");
		
		//objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		objcustomerProfile_AddViewDueDiligence_PF.saveDuediligenceRecord();
		//objCommonView.verifyConfirmationMessage("Are you sure you want to send this record for approval? Press");
		objcustomerProfile_AddViewDueDiligence_PF.clickOnYes();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
	}

	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objcustomerProfile_AddViewDueDiligence_PF = null;
		objCustomerDueDiligenceFilter_PF = null;
		objlogin_PF = null;
	}
}


