package com.pageFactory.EDD;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;

public class CustomerProfile_Incidents 
{
	private Pojo objPojo;
	String custNumber="";
	static String refId_FE="";

	public CustomerProfile_Incidents(Pojo pojo)
	{
		this.objPojo = pojo;
	}

	By customerProfile_Incident_AddButton = By.xpath("//button[@id='buttonAddIncident']");
	By customersTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	By incidentGroupDropdown = By.xpath("//select[@id='dropDownSelectIncidentGroup']");
	By table = By.xpath("//table[@class='grid datagrid']");
	By casinoDropdown = By.xpath("//select[@id='dropDownCasino']");
	By incident_NotesTextArea = By.xpath("//textarea[@id='Incident_Notes']");
	By incident_WerePoliceCalledDropdown = By.xpath("//select[@id='customFields_0__ListValue']");
	By incident_MethodofExclusionDropdown = By.xpath("//select[@id='customFields_1__ListValue']");
	By incident_playerTypeDropdown = By.xpath("//select[@id='customFields_2__ListValue']");
	By incident_RiskRatingDropdown = By.xpath("//select[@id='customFields_3__ListValue']");
	By incident_ExclusionTermInput = By.xpath("//input[@id='customFields_4__IntegerValue']");
	By incident_ExcludefromDigitalDropdown = By.xpath("//select[@id='customFields_5__ListValue']");
	By incident_SENSEApplicatioMethodDropdown = By.xpath("//select[@id='customFields_6__ListValue']");
	By incident_SENSERejectionReasonDropdown = By.xpath("//select[@id='customFields_7__ListValue']");
	By incident_SENSE_URN_NO = By.xpath("//input[@id='customFields_8__Value']");

	By incidentTab = By.id("CustomerManagement_Incidents_Menu");
	By filterIncident_incidentNumber= By.xpath("//input[@id='IncidentId']");
	By filterIncident_newIncidentButton = By.xpath("//button[@id='buttonNewIncident']");

	By filterIncident_incidentDetails_AddButton = By.id("buttonAdd");
	By filterIncident_incidentDetails_Participent_Number = By.xpath("//input[@name='IncidentParticipant.DisplayNumber']");

	By filterIncident_incidentDetails_ParticipantTypeDropdown = By.xpath("//select[@id='dropDownParticipantType']");
	By filterIncident_incidentDetails_Participent_Role = By.xpath("//input[@id='textBoxRole']");

	By filterIncident_incidentDetails_Participent_Notes = By.id("IncidentParticipant_Notes");
	By incidentTypeDropdown = By.xpath("//select[@id='listBoxSelectIncidentType']");

	public void navigateToincidentTab()
	{
		objPojo.getObjUtilities().logReporter("Click on incidentTab ", 
				objPojo.getObjWrapperFunctions().clickByScript(incidentTab), false);		
	}
	public void serchIncidentByIncidentNumber(String incidentnumber)
	{
		objPojo.getObjUtilities().logReporter("Enter IncidentNumber ", 
				objPojo.getObjWrapperFunctions().setText(filterIncident_incidentNumber,incidentnumber), false);		
	}
	public void ClickNewIncidentButton()
	{
		objPojo.getObjUtilities().logReporter("Click on New", 
				objPojo.getObjWrapperFunctions().clickByScript(filterIncident_newIncidentButton), false);		
	}
	public void setNotesForParticipant()
	{
		objPojo.getObjUtilities().logReporter("Enter Notes ", 
				objPojo.getObjWrapperFunctions().setText(filterIncident_incidentDetails_Participent_Notes,"Test"), false);		
	}

	public void setParticipantNumber(String custNumber)
	{
		objPojo.getObjUtilities().logReporter("Enter Participant Number ", 
				objPojo.getObjWrapperFunctions().setText(filterIncident_incidentDetails_Participent_Number,custNumber), false);
		objPojo.getObjWrapperFunctions().pressTabBtn(filterIncident_incidentDetails_Participent_Number);
	}
	public void verifyParticipantType(String option)
	{
		By webEle = By.xpath("//select[@id='dropDownParticipantType']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}

	public void selectParticipantTypeFromDropdown()
	{
		objPojo.getObjUtilities().logReporter("Click on ParticipantType dropdown ", 
				objPojo.getObjWrapperFunctions().click(filterIncident_incidentDetails_ParticipantTypeDropdown), false);	
		verifyParticipantType("Customer");
		verifyParticipantType("Employee");
		verifyParticipantType("Other");
		verifyParticipantType("Security Entry");
		objPojo.getObjUtilities().logReporter("Select ParticipantType as Customer ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(filterIncident_incidentDetails_ParticipantTypeDropdown,"Customer"), false);	
	}
	public void clickOnAddButton()
	{
		objPojo.getObjUtilities().logReporter("Click on customerProfile_Incident_AddButton ", 
				objPojo.getObjWrapperFunctions().click(customerProfile_Incident_AddButton), false);	
	}
	public void clickOnAddParticipant()
	{

		objPojo.getObjUtilities().logReporter("Click on AddButton ", 
				objPojo.getObjWrapperFunctions().click(filterIncident_incidentDetails_AddButton), false);	

	}
	public void selectGroupFromDropdown()
	{
		objPojo.getObjUtilities().logReporter("Click on Group dropdown ", 
				objPojo.getObjWrapperFunctions().click(incidentGroupDropdown), false);	
		verifyGroupDropdownOption("Datafix");
		verifyGroupDropdownOption("Machines");
		objPojo.getObjUtilities().logReporter("Select Group as Responsible Gambling", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incidentGroupDropdown,"Safer Gambling"), false);	
//		objPojo.getObjUtilities().logReporter("Click on Incident type dropdown ", 
//				objPojo.getObjWrapperFunctions().click(incidentTypeDropdown), false);	
//		objPojo.getObjUtilities().logReporter("Select Group as Responsible Gambling", 
//				objPojo.getObjWrapperFunctions().selectDropDownByValue(incidentTypeDropdown,"10"), false);	
	}

	public void verifyGroupDropdownOption(String option)
	{
		By webEle = By.xpath("//select[@id='dropDownSelectIncidentGroup']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}
	public void verifyFindIncidentSearchResult(String incidentNumber)
	{
		objPojo.getObjUtilities().logReporter("Verify FindIncidentSearchResult ", 
				objPojo.getObjWrapperFunctions().verifyTableHeaders(table,"Number","Incident Date","Date / Time","Type","Category","Location Name","Status"), false);	

		objPojo.getObjUtilities().logReporter("Verify incident Id display as per search result ", 
				objPojo.getObjWrapperFunctions().verifyTableContent(table,"Number",incidentNumber), false);	
	}
	public void verifyCheckListTable()
	{

		By checkListTable = By.xpath("//legend[contains(text(),'Check List')]/following-sibling::div/grid/div/table[@class='grid datagrid']");
		By checkList_CompletedCheckBox = By.xpath("//column-input/following-sibling::input[@type='checkbox']");	

		objPojo.getObjUtilities().logReporter("Verify checkList Headers", 
				objPojo.getObjWrapperFunctions().verifyTableContent(checkListTable,"Item","Deleted"), false);	
		objPojo.getObjUtilities().logReporter("Verify checkList Headers", 
				objPojo.getObjWrapperFunctions().verifyTableHeaders(checkListTable,"Item","Completed"), false);	
	}
	public void selectIncidentTypeFromDropdown(String type)
	{
		By incidentTypeDropdown = By.xpath("//select[@id='listBoxSelectIncidentType']");
		/*objPojo.getObjUtilities().logReporter("Click on Group dropdown ", 
				objPojo.getObjWrapperFunctions().click(incidentGroupDropdown), false);	*/
		verifyIncidentTypeDropdownOption("Enforced Exclusion");
		verifyIncidentTypeDropdownOption("Affordability");
		verifyIncidentTypeDropdownOption("Customer Under Monitoring");
		verifyIncidentTypeDropdownOption("Digital Account Limits");
		verifyIncidentTypeDropdownOption("Self Exclusion");
		verifyIncidentTypeDropdownOption("Problem Gambling Reinstatement Request");

		objPojo.getObjWrapperFunctions().deSelectDropDown(incidentTypeDropdown);
		objPojo.getWaitMethods().sleep(5);
		objPojo.getObjUtilities().logReporter("Select Group as Responsible Gambling", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incidentTypeDropdown,type), false);	
	}

	public void verifyIncidentTypeDropdownOption(String option)
	{
		By webEle = By.xpath("//select[@id='listBoxSelectIncidentType']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}


	public void verifyIncidentTitle(String option)
	{
		try {
		Thread.sleep(5000);
		By webEle = By.xpath("//*[@id='layoutCaption'][contains(text(),'New Incident - " + option +"')]");
		objPojo.getObjUtilities().logReporter("Verify Incident header display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
		}
		catch(Exception e) {	
		}
	}

	public void verifyCasinoDropdownOptionFromIncidentPage(String option)
	{
		By webEle = By.xpath("//select[@id='dropDownCasino']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}

	public void selectCasinoDropdownOptionFromIncidentPage(String casino)
	{
		objPojo.getObjUtilities().logReporter("Click on Casino dropdown ", 
				objPojo.getObjWrapperFunctions().click(casinoDropdown), false);	
		objPojo.getObjUtilities().logReporter("Select Casino as '"+casino+"'", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(casinoDropdown,casino), false);	
	}


	public void verifyStatusDropdownOptionFromIncidentPage(String option)
	{
		By webEle = By.xpath("//select[@id='Incident_Status']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}
	By Incident_statusDropdown = By.xpath("//select[@id='Incident_Status']");

	public void selectStatusDropdownOptionFromIncidentPage(String status)
	{
		objPojo.getObjUtilities().logReporter("Click on Casino dropdown ", 
				objPojo.getObjWrapperFunctions().click(Incident_statusDropdown), false);	
		verifyStatusDropdownOptionFromIncidentPage("Closed");
		verifyStatusDropdownOptionFromIncidentPage("Open");
		verifyStatusDropdownOptionFromIncidentPage("Pending");

		objPojo.getObjUtilities().logReporter("Select Casino as '"+status+"'", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(Incident_statusDropdown,status), false);	
	}


	public void verifySubsectionOnIncidentPage(String option)
	{

		By webEle = By.xpath("//legend[contains(text(),'"+option+"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}

	public void setNotes()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objPojo.getObjWrapperFunctions().checkElementDisplyed(incident_NotesTextArea);
		objPojo.getObjWrapperFunctions().waitForElementToBeClickable(incident_NotesTextArea);
		objPojo.getObjUtilities().logReporter("Enter notes  ", 
				objPojo.getObjWrapperFunctions().setText(incident_NotesTextArea, "test purpose only "), false);	
	}


	public void verifyParticipantTableHeaders()
	{

		objPojo.getObjUtilities().logReporter("Verify participant table headers  ", 
				objPojo.getObjWrapperFunctions().verifyTableHeaders(table,"Number","Name","Type","Role","Notes"), false);	
	}

	public void verifyParticipantTableContent(String customerNumber)
	{
		objPojo.getObjUtilities().logReporter("Verify content dispaly in table against column ", 
				objPojo.getObjWrapperFunctions().verifyTableContent(table,"Number",customerNumber), false);	
	}
	public void verifyWerePoliceCalledDropdownOptions(String option)
	{
		By webEle = By.xpath("//select[@id='customFields_0__ListValue']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}

	public void selectWerePoliceCalled()
	{

		//
		objPojo.getObjUtilities().logReporter("Click on WerePoliceCalled dropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_WerePoliceCalledDropdown), false);	
		verifyWerePoliceCalledDropdownOptions("No");
		verifyWerePoliceCalledDropdownOptions("Yes, but the police did not attend");
		verifyWerePoliceCalledDropdownOptions("Yes, and the police attended");

		objPojo.getObjUtilities().logReporter("Select No ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_WerePoliceCalledDropdown,"No"), false);	
	}

	public void verifyMethodofExclusionDropdownOptions(String option)
	{
		By webEle = By.xpath("//select[@id='customFields_1__ListValue']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}

	public void selectMethodofExclusion()
	{
		//
		objPojo.getObjUtilities().logReporter("Click on Casino dropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_MethodofExclusionDropdown), false);	
		verifyMethodofExclusionDropdownOptions("Email");
		verifyMethodofExclusionDropdownOptions("Letter");
		verifyMethodofExclusionDropdownOptions("Self-Exclusion Form");
		verifyMethodofExclusionDropdownOptions("Support Office Correspondence");
		verifyMethodofExclusionDropdownOptions("Telephone");
		verifyMethodofExclusionDropdownOptions("Verbal");
		objPojo.getObjUtilities().logReporter("Select Email ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_MethodofExclusionDropdown,"Email"), false);	
	}

	public void verifyPlayerTypeDropdownOptions(String option,String fieldNumber)
	{
		By webEle = By.xpath("//select[@id='customFields_"+fieldNumber+"__ListValue']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}

	public void selectPlayerType(String fieldNumber)
	{
		//
		By incident_playerTypeDropdown = By.xpath("//select[@id='customFields_"+fieldNumber+"__ListValue']");
		objPojo.getObjUtilities().logReporter("Click on incident_playerTypeDropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_playerTypeDropdown), false);	
		verifyPlayerTypeDropdownOptions("Electronic Gaming",fieldNumber);
		verifyPlayerTypeDropdownOptions("Poker Room",fieldNumber);
		verifyPlayerTypeDropdownOptions("Slot Machine",fieldNumber);
		verifyPlayerTypeDropdownOptions("Tables",fieldNumber);
		verifyPlayerTypeDropdownOptions("Unspecified / Other",fieldNumber);

		objPojo.getObjUtilities().logReporter("Select Unspecified/Other ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_playerTypeDropdown,"Unspecified / Other"), false);	
	}

	public void verifyRiskRatingDropdownOptions(String option,String fieldNumber)
	{
		By webEle = By.xpath("//select[@id='customFields_"+fieldNumber+"__ListValue']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}


	public void selectRiskRating(String fieldNumber)
	{
		//Player Type
		By incident_RiskRatingDropdown = By.xpath("//select[@id='customFields_"+fieldNumber+"__ListValue']");
		objPojo.getObjUtilities().logReporter("Click on incident_RiskRatingDropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_RiskRatingDropdown), false);	
		verifyRiskRatingDropdownOptions("High",fieldNumber);
		verifyRiskRatingDropdownOptions("Low",fieldNumber);
		verifyRiskRatingDropdownOptions("Medium",fieldNumber);
		objPojo.getObjUtilities().logReporter("Select Unspecified/Other ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_RiskRatingDropdown,"Low"), false);	
	}

	public void setExclusionTermMonths()
	{
		//
		objPojo.getObjUtilities().logReporter("Enter ExclusionTermMonths  ", 
				objPojo.getObjWrapperFunctions().setText(incident_ExclusionTermInput, "7"), false);	
	}
	public void verifyExcludefromDigitalDropdownOptions(String option)
	{
		By webEle = By.xpath("//select[@id='customFields_5__ListValue']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}


	public void selectExcludefromDigital()
	{
		//Player Type
		//	

		objPojo.getObjUtilities().logReporter("Click Exclude from Digital Dropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_ExcludefromDigitalDropdown), false);	
		verifyExcludefromDigitalDropdownOptions("No");
		verifyExcludefromDigitalDropdownOptions("Yes");		
		objPojo.getObjUtilities().logReporter("Select No ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_ExcludefromDigitalDropdown,"No"), false);	
	}
	public void verifySENSEApplicatioMethodDropdownOptions(String option)
	{
		By webEle = By.xpath("//select[@id='customFields_6__ListValue']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}


	public void selectSENSEApplicatioMethod()
	{
		//				
		objPojo.getObjUtilities().logReporter("Click SENSEApplicatioMethodDropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_SENSEApplicatioMethodDropdown), false);	
		verifySENSEApplicatioMethodDropdownOptions("By Post");
		verifySENSEApplicatioMethodDropdownOptions("In Person");	
		verifySENSEApplicatioMethodDropdownOptions("Not Applicable");	
		objPojo.getObjUtilities().logReporter("Select No ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_SENSEApplicatioMethodDropdown,"Not Applicable"), false);	
	}

	public void verifySENSERejectionReasonDropdownOptions(String option)
	{
		By webEle = By.xpath("//select[@id='customFields_7__ListValue']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}


	public void selectSENSERejectionReason()
	{

		//	

		objPojo.getObjUtilities().logReporter("Click SENSEApplicatioMethodDropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_SENSERejectionReasonDropdown), false);	
		verifySENSERejectionReasonDropdownOptions("No reason given by the customer");
		verifySENSERejectionReasonDropdownOptions("Other (explain in notes field)");	
		verifySENSERejectionReasonDropdownOptions("Not applicable");	
		verifySENSERejectionReasonDropdownOptions("Request received by letter/phone/email");
		verifySENSERejectionReasonDropdownOptions("Technical issues with SENSE");	
		verifySENSERejectionReasonDropdownOptions("Customer claims to play only with Grosvenor");	
		verifySENSERejectionReasonDropdownOptions("Customer employed by another operator");	

		objPojo.getObjUtilities().logReporter("Select No ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_SENSERejectionReasonDropdown,"No reason given by the customer"), false);	
	}

	public void verifyCustomerProfileSideNavigationOption(String sideTab)
	{
		By webEle = By.xpath("//div[@ng-controller='incidentController']/section[@class='sidebar']//following-sibling::ul/li/a[contains(text(),'"+sideTab+"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+sideTab+"'", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);		
	}
	public void setSENSEURNNO()
	{
		//
		objPojo.getObjUtilities().logReporter("Enter ExclusionTermMonths  ", 
				objPojo.getObjWrapperFunctions().setText(incident_SENSE_URN_NO, "NA"), false);	
	}
	By incident_saveButton = By.xpath("//button[@type='submit'][contains(text(),'Save')]");

	public void clickOnSaveButton()
	{
		objPojo.getObjUtilities().logReporter("Click on Save ", objPojo.getObjWrapperFunctions().click(incident_saveButton), false);
		objPojo.getWaitMethods().sleep(8);
	}

	public void verifyConfirmationMessage(String message)
	{
		//div[@class='modal-body ig-modal-scroll'][contains(text(),'This record has been saved successfully.')]
		By incident_ConfirmationMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(text(),'"+ message +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+message+"' display  ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(incident_ConfirmationMessage), false);	
	}
	public String getIncidentNumber()	{
		objPojo.getWaitMethods().sleep(8);	
		By webEle = By.xpath("//span[@name='Incident.Id']");
		System.out.println(webEle);
		return  objPojo.getObjWrapperFunctions().getText(webEle); 
	}
	public void selectActionTakenDropDown()
	{
		//Action Taken
		objPojo.getObjUtilities().logReporter("Click on Action Taken ", 
				objPojo.getObjWrapperFunctions().click(incident_WerePoliceCalledDropdown), false);	
		verifyWerePoliceCalledDropdownOptions("Commence Monitoring");
		verifyWerePoliceCalledDropdownOptions("Continue to Monitor");
		verifyWerePoliceCalledDropdownOptions("Held Conversation");
		verifyWerePoliceCalledDropdownOptions("No Action as no Gambling Concerns Identified");

		objPojo.getObjUtilities().logReporter("Select Commence Monitoring ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_WerePoliceCalledDropdown,"Commence Monitoring"), false);	
	}

	/*
	Actual Date / Time
	//input[@id='Incident_ActualDateTime']


	Date Closed
	//input[@id='dateDateClosed']


	//select[@id='customFields_1__ListValue']

	incident id =//label[]//span





	positive incident/gambling conversion
	additional

	//
	//select[@id='customFields_0__ListValue']




	Player Type

	//select[@id='customFields_1__ListValue']

	Risk Rating
	//select[@id='customFields_1__ListValue']

	public void navigateToCustomerTab()
	{
		objPojo.getObjUtilities().logReporter("Click on Customers Menu tab", objPojo.getObjWrapperFunctions().click(customersMainTab), false);
		objPojo.getObjWrapperFunctions().waitForElementToBeClickable(customersTab);
		objPojo.getObjUtilities().logReporter("Click on Customers tab", objPojo.getObjWrapperFunctions().click(customersTab), false);
	}

	 */

	public void verifyDropdownOptions(String option,String fieldNumber)
	{
		By webEle = By.xpath("//select[@id='customFields_"+fieldNumber+"__ListValue']//option[contains(text(),'"+ option +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+option+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}


	public void selectDropdownOption(String fieldNumber,String option)
	{
		//Player Type
		By incident_Dropdown = By.xpath("//select[@id='customFields_"+fieldNumber+"__ListValue']");
		objPojo.getObjUtilities().logReporter("Click on incident_RiskRatingDropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_Dropdown), false);	

		objPojo.getObjUtilities().logReporter("Select  ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_Dropdown,option), false);	
	}
	By incident_ProblemGamblingReinstatement_HowResolved = By.xpath("//textarea[@id='Incident_HowResolved']");

	public void setHowResolved()
	{
		objPojo.getObjUtilities().logReporter("Enter IncidentNumber ", 
				objPojo.getObjWrapperFunctions().setText(incident_ProblemGamblingReinstatement_HowResolved,"Test purpose only"), false);		
	}
	
	public void setText(String fieldNumber)
	{
		By incident_teaxtArea = By.xpath("//textarea[@id='customFields_"+fieldNumber+"__Value']");
		objPojo.getObjUtilities().logReporter("Enter IncidentNumber ", 
				objPojo.getObjWrapperFunctions().setText(incident_teaxtArea,"Test purpose only"), false);		
	}
	
	public void selectCategoryDropdownOption(String option)
	{
		//category dropdown
		By incident_Dropdown = By.xpath("//select[@id='Incident_CategoryId']");
		objPojo.getObjUtilities().logReporter("Click on incident_catagory dropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_Dropdown), false);	

		objPojo.getObjUtilities().logReporter("Select  ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_Dropdown,option), false);	
	}
	
	public void casinoDropdownOption(String option)
	{
		//casino dropdown
		By incident_Dropdown = By.xpath("//select[@id='Casino_Id']");
		objPojo.getObjUtilities().logReporter("Click on casino dropdown ", 
				objPojo.getObjWrapperFunctions().click(incident_Dropdown), false);	

		objPojo.getObjUtilities().logReporter("Select  ", 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(incident_Dropdown,option), false);	
	}
}
