package views;


import ru.yandex.qatools.allure.annotations.Step;

import com.generic.Pojo;
import com.pageFactory.EDD.CustomerProfile_Incidents;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerDueDiligenceFilter_PF;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.customerProfile_AddViewDueDiligence_PF;
import com.pageFactory.desktopReception.homeNavigations;
import com.pageFactory.desktopReception.login_PF;

public class CommonView 
{
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CustomerProfile_Incidents objCustomerProfile_Incidents;
	private CustomerDueDiligenceFilter_PF objCustomerDueDiligenceFilter_PF;
	private customerProfile_AddViewDueDiligence_PF objcustomerProfile_AddViewDueDiligence_PF;
	private login_PF objlogin_PF;
	private accountTransactions_PF objaccountTransactions_PF;
	private homeNavigations objhomeNavigations;
	
	public CommonView(Pojo objPojo)
	{
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(objPojo);
		objCustomerProfile_Incidents = new CustomerProfile_Incidents(objPojo);
		objCustomerDueDiligenceFilter_PF = new CustomerDueDiligenceFilter_PF(objPojo);
		objcustomerProfile_AddViewDueDiligence_PF = new customerProfile_AddViewDueDiligence_PF(objPojo);
		objlogin_PF = new login_PF(objPojo);
		objaccountTransactions_PF= new accountTransactions_PF(objPojo);
		objhomeNavigations = new homeNavigations(objPojo);	
	}

	public void verifyConfirmationMessage(String msg)
	{
	objCustomerProfile_Incidents.verifyConfirmationMessage(msg);
	}
	@Step("Login to Neon")
	public void login(String userName,String password)
	{
		objlogin_PF.setNeonUserName(userName);
		objlogin_PF.setNeonPassword(password);
		objlogin_PF.clickSignInButton();
		objlogin_PF.clickOnOkButton();

	}
	@Step("Set suspension to customer profile ")
	public void setSuspension(String suspensionType)
	{
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Suspensions");
		objCustomerProfile_Suspension.verifyAddButtonOnCustomerProfileSuspensionTab();
		objCustomerProfile_Suspension.clickOnAddButton();
		objCustomerProfile_Suspension.verifyPageTitle("Customer Suspension");
		objCustomerProfile_Suspension.selectSuspensionType(suspensionType);
		//objCustomerProfile_Suspension.selectCasinoDropdown("_Maidenhead (FF NT7)");
		
		String actualGamingDate = objCustomerProfile_Suspension.verifyGamingDateDropdown();
		System.out.println(" actualGamingDate : "+actualGamingDate);
		objCustomerProfile_Suspension.setNotes();
		objCustomerProfile_Suspension.setMessage();
		objCustomerProfile_Suspension.verifyCancelButton();
		objCustomerProfile_Suspension.clickOnCommit();

		//objCustomerProfile_Suspension.clickOnCancel();
		String gamingDate = objCustomerProfile_Suspension.getLabelValue("Gaming Date");
		System.out.println(" gamingDate : "+gamingDate);
		String actualSuspensionType = objCustomerProfile_Suspension.getLabelValue("Type");
		System.out.println(" suspensionType : "+actualSuspensionType);
		objCustomerProfile_Suspension.verifyValueDisplayCorrectlyOrNot(actualGamingDate,gamingDate);
		//objCustomerProfile_Suspension.verifyValueDisplayCorrectlyOrNot(actualSuspensionType,suspensionType);
		
	}
	@Step("Verify fields on customer suspension screen ")
	public void verifyFieldsOnSuspensionScreen()
	{
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("All Casinos");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Notes");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Employee Messages");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Expiry Date");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Date Lifted");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Authorised By");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Casino");	
	}

	@Step("Lift the suspension ")
	public void liftSuspension(String user)
	{
		objCustomerProfile_Suspension.liftSuspension(user);
	}

	@Step("Verify added suspension displayed on customer details page ")
	public void verifySuspensionStatusDisplayOnCustomerDetailsPage(String suspensionType)
	{
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Details");
		objCustomerProfile_Suspension.verifySuspensionStatusDisplayedOnCustomerDetailsPage(suspensionType);
	}

	@Step("Verify suspension does not display on customer details page after lift suspension")
	public void verifySuspensionStatusDoesNotDisplayOnCustomerDetailsPage(String suspensionType)
	{
		objCustomerProfile_Suspension.navigateToCustomerProfileandSelectTab("Details");
		objCustomerProfile_Suspension.verifySuspensionStatusDoesNotDisplayOnCustmerDetailsAfterLiftSuspension(suspensionType);
	}
	@Step("Create incident")
	public void createIncident(String incidentType)
	{
		objCustomerProfile_Suspension.verifyPageTitle("Select New Incident Type");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Group");
		objCustomerProfile_Incidents.selectGroupFromDropdown();
		objCustomerProfile_Incidents.selectIncidentTypeFromDropdown(incidentType);
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
		objCustomerProfile_Incidents.verifyIncidentTitle(incidentType);
	}
	@Step("Add Participant To Incident")
	public void addParticipantToIncident(String CustomerNumber )
	{
		objCustomerProfile_Incidents.clickOnAddParticipant();
		objCustomerProfile_Suspension.verifyPageTitle("Participants");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Type");
		objCustomerProfile_Incidents.selectParticipantTypeFromDropdown();

		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Number");
		objCustomerProfile_Incidents.setParticipantNumber(CustomerNumber);
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Name");
		String name = 	objCustomerProfile_Suspension.getLabelValue("Name");
		System.out.println(" name : "+name);

		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Role");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Notes");
		objCustomerProfile_Incidents.setNotesForParticipant();
		objcustomerProfile_AddViewDueDiligence_PF.clickOnOk();
	}

	@Step("Verify sidebar tabs from Incident page")
	public void verifySideBarTabsFromIncident()
	{
		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Associated Incidents");
		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Audit");
		objCustomerProfile_Incidents.verifyCustomerProfileSideNavigationOption("Evidence");
	}

	@Step("Verify Labels Incident page")
	public void verifyFieldLabelsFromIncidentPage()
	{
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Incident Number");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Actual Date / Time");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Gaming Date");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Category");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Status");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Date Closed");
		objCustomerProfile_Incidents.selectCasinoDropdownOptionFromIncidentPage("_SAW 1");
	}
	@Step("Set amount and save details")
	public void verifyAccountTypeAndSetAmmount(String actType,String amt,String confirmationMessage)
	{
		objaccountTransactions_PF.verifyAccountType(actType);
		objaccountTransactions_PF.setAmount(amt);
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();
		
		objaccountTransactions_PF.getConfirmationMessage(confirmationMessage);
	    objaccountTransactions_PF.clickOnYes();
		
		//if(objaccountTransactions_PF.getConfirmationMessage(confirmationMessage))
		//{objaccountTransactions_PF.clickOnYes();}
		
		objaccountTransactions_PF.getConfirmationMessage("Transaction completed");
	    objaccountTransactions_PF.clickOnOk();
		
		objaccountTransactions_PF.verifyNewButtonDisplayed();
		objaccountTransactions_PF.clickOnNewButton();
		objaccountTransactions_PF.clickcloseButton();
	}
	@Step("Save suspension Button ")
	public void saveSuspension()
	{
		objaccountTransactions_PF.clickOnSave();
		objaccountTransactions_PF.clickOnOk();
			
	}
}
