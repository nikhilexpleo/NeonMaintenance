package com.scripts.EDD;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.customer_RegisterAndViewDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class suspensionSet extends BaseTest{

	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;
	private customer_RegisterAndViewDetails_PF objneonReg_PF;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objneonReg_PF = new customer_RegisterAndViewDetails_PF(this);
		objCommonView = new CommonView(this);
		objlogin_PF = new login_PF(this);
	}

//	@DataProvider(name = "TestDataProvider")
//	public Object[][] getDataProvider(Method method, ITestContext context) {
//		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
//		return testData;
//	}
	@Title("CENTRAL ACTION – Conversation Required Suspension")
	@Description("Verify a customer can be set to CENTRAL ACTION – Conversation Required ")
	@Test(enabled = false)
	public void setCentralActionConversationRequiredSuspensionToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("CENTRAL ACTION – Conversation Required");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("CENTRAL ACTION – Conversation Required");
		objCommonView.saveSuspension();
	}
	
	@Title("CENTRAL ACTION – Time Sensitive Suspension")
	@Description("Verify a customer can be set to CENTRAL ACTION – Time Sensitive ")
	@Test(enabled = false)
	public void setCentralActionTimeSensitiveSuspensionToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("CENTRAL ACTION – Time Sensitive");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("CENTRAL ACTION – Time Sensitive");
		objCommonView.saveSuspension();
	}
	
	@Title("EDD Pending - Refer to Duty Manager Suspension")
	@Description("Verify a customer can be set to EDD Pending - Refer to Duty Manager ")
	@Test(enabled = false)
	public void setEDDPendingRefertoDutyManagerSuspensionToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("EDD Pending - Refer to Duty Manager");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("EDD Pending - Refer to Duty Manager");
		objCommonView.saveSuspension();
	}

	@Title("Enforced Safer Gambling Exclusion Suspension")
	@Description("Verify a customer can be set to Enforced Safer Gambling Exclusion ")
	@Test(enabled = false)
	public void setEnforcedSaferGamblingExclusionToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Enforced Safer Gambling Exclusion");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Enforced Safer Gambling Exclusion");
		objCommonView.saveSuspension();
	}
	
	@Title("Test 14252")
	@Description("Verify a customer can be set to Groupwide Barred - Behaviour ")
	@Test(enabled = false,priority = 1)
	public void tc14252_SetGroupwideBarredBehaviourToCustomerProfile()
	{	
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		//objneonReg_PF.viewCustomerDetails();
		//String custNumber = objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Groupwide Barred - Behaviour");
		objCommonView.verifyFieldsOnSuspensionScreen();
		//objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage(getObjUtilities().dpString("Suspension Type"));
		//objCustomerProfile_Suspension.closeTab();
		objCommonView.saveSuspension();
	}
	
	@Title("Test 14262")
	@Description("Verify a customer suspension can be lifted when set to Groupwide Barred - Behaviour ")
	@Test(enabled = true,priority = 1)
	public void tc14252_LiftSuepensionGroupwideBarredBehaviour()
	{	
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Groupwide Barred - Behaviour");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCustomerProfile_Suspension.liftSuspension("Kalme");
		
		String actualDateLifted = objCustomerProfile_Suspension.getLabelValue("Date Lifted");
		System.out.println("Actual dateLifted "+actualDateLifted);
		String expectedDateLifted = this.getObjUtilities().getCurrentDate("dd/MM/yyyy");
		System.out.println(" Expected date Lifted "+expectedDateLifted);
		
		//objCustomerProfile_Suspension.verifyValues(actualDateLifted,expectedDateLifted);
		
		String AuthorisedBy = objCustomerProfile_Suspension.getAuthoriserValue("Kalme");
		System.out.println("AuthorisedBy "+AuthorisedBy);
		objCustomerProfile_Suspension.verifyValues(AuthorisedBy,"Kalme");
		
		objCommonView.saveSuspension();
		//objCustomerProfile_Suspension.verifySuspensionStatusDoesNotDisplayOnCustmerDetailsAfterLiftSuspension("Groupwide Barred - Behaviour");
	}
	
	@Title("Test 14253")
	@Description("Verify a customer can be set to GroupwideBarred_FailedEDD ")
	@Test(enabled = false)
	public void tc14253_SetGroupwideBarredFailedEDDToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Groupwide Barred - Failed EDD");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Groupwide Barred - Failed EDD");
		objCommonView.saveSuspension();
	}
	
	@Title("Groupwide Barred - Other Suspension")
	@Description("Verify a customer can be set to Groupwide Barred - Other ")
	@Test(enabled = false)
	public void setGroupwideBarredOtherSuspensionToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Groupwide Barred - Other");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Groupwide Barred - Other");
		objCommonView.saveSuspension();
	}
	
	@Title("Test 14254")
	@Description("Verify a customer can be set to Locally Barred - Behaviour ")
	@Test(enabled = false)
	public void tc14254_SetLocallyBarredBehaviourToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Locally Barred - Behaviour");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Locally Barred - Behaviour");
		objCommonView.saveSuspension();
	}
	
	@Title("Test 14255")
	@Description("Verify a customer can be set to LocallyResigned")
	@Test(enabled = false)
	public void tc14255_SetLocallyResignedToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Locally Resigned");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Locally Resigned");
		objCommonView.saveSuspension();
	}
	
	@Title("National Suspension")
	@Description("Verify a customer can be set to National Suspension")
	@Test(enabled = false)
	public void SetNationalSuspensionToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("National Suspension");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("National Suspension");
		objCustomerProfile_Suspension.closeTab();
	}
	
	@Title("Test 14256")
	@Description("Verify a customer can be set to Nationally Resigned ")
	@Test(enabled = false)
	public void tc14256_SetNationallyResignedToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Nationally Resigned");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Nationally Resigned");
		objCommonView.saveSuspension();
	}
	
	@Title("Reinstatement Available Venue to Review Suspension")
	@Description("Verify a customer can be set to Reinstatement Available Venue to Review suspension ")
	@Test(enabled = false)
	public void setReinstatementAvailableVenuetoReviewToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Nationally Resigned");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Nationally Resigned");
		objCommonView.saveSuspension();
	}
	
	@Title("Test 14258")
	@Description("Verify a customer can be set to Self-Excluded - Not on SENSE")
	@Test(enabled = false)
	public void tc14258_SetSelfExcludedNotOnSENSEToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Self-Excluded - Not on SENSE");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Self-Excluded - Not on SENSE");
		objCommonView.saveSuspension();
	}
	
	@Title("Test 14259")
	@Description("Verify a customer can be set to Self-Excluded - SENSE (External) ")
	@Test(enabled = false)
	public void tc14259_SetSelfExcludedSENSEExternalToCustomerProfile() 
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Self-Excluded - SENSE (External)");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Self-Excluded - SENSE (External)");
		objCommonView.saveSuspension();
	}

	@Title("Test 142560")
	@Description("Verify a customer can be set to Self-Excluded - SENSE (Grosvenor)")
	@Test(enabled = false)
	public void tc14260_SetSelfExcludedSENSEGrosvenorToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Self-Excluded - SENSE (Grosvenor)");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("Self-Excluded - SENSE (Grosvenor)");
		objCommonView.saveSuspension();
	}
	
	@Title("SG Pending - Conversation Required Suspension")
	@Description("Verify a customer can be set to SG Pending - Conversation Required")
	@Test(enabled = false)
	public void setSGPendingConversationRequiredToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("SG Pending - Conversation Required");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("SG Pending - Conversation Required");
		objCommonView.saveSuspension();
	}

	@Title("TESS – SOF REQUIRED")
	@Description("Verify a customer can be set to TESS – SOF REQUIRED")
	@Test(enabled = false)
	public void SetTessSofRequiredToCustomerProfile()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("TESS – SOF REQUIRED");
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage("TESS – SOF REQUIRED");
		objCommonView.saveSuspension();
	}

	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objCommonView = null;
		objlogin_PF = null;
		objneonReg_PF = null;
	}
}

