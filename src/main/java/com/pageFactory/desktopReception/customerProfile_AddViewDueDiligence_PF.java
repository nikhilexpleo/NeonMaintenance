package com.pageFactory.desktopReception;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_AddViewDueDiligence_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",refId_FE="";
	static int tempRandom,expiry_days,expiry_month,expiry_year ;
	private Pojo objPojo;

	public customerProfile_AddViewDueDiligence_PF(Pojo pojo)
	{
		this.objPojo = pojo;
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}

	private By customersMainTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By customersTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	private By yesBtn=By.xpath("//button[contains(text(),'Yes')]");

	private By findInputBox=By.xpath("//input[@id='Number']");	
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By headingTxt=By.xpath("//h1[@id='layoutCaption']");

	private By customerProfile_DueDiligenceTab=By.xpath("//section[@class='sidebar']//li[@id='tabDueDiligence']//a[contains(.,'Due Diligence')]");	
	private By customerProfile_DueDiligence_AddButton=By.xpath("//button[@id='buttonAddMessage'][contains(.,'Add')]");		
	private By customerProfile_DueDiligence_SelectReason=By.xpath("//select[@id='dropdownNewEDDReason']");
	private By customerProfile_DueDiligence_reasonForCreation=By.xpath("//input[@id='textboxNewEDDCreateReason']");

	private By customerProfile_DueDiligence_actualLossAmount = By.xpath("//input[@id='textboxNewEDDLossAmount']");


	private By customerProfile_DueDiligence_BusinessRelationshipStartDate=By.xpath("//div[@class='input-group']//input[@id='DueDiligence_BusinessRelationshipStartDate']");

	private By customerProfile_DueDiligence_Occupation=By.xpath("//input[@id='DueDiligence_Occupation']");
	private By customerProfile_DueDiligence_PositionHeld=By.xpath("//input[@id='DueDiligence_PositionHeld']");		
	private By customerProfile_DueDiligence_Employer=By.xpath("//input[@id='DueDiligence_Employer']");	
	private By customerProfile_DueDiligence_BusinessAddress=By.xpath("//textarea[@id='DueDiligence_BusinessAddress']");		
	private By customerProfile_DueDiligence_PropertyMarketValue=By.xpath("//input[@id='DueDiligence_PropertyMarketValue']");		
	private By customerProfile_DueDiligence_SourceOfInformation=By.xpath("//input[@id='DueDiligence_SourceOfInformation']");	

	private By customerProfile_DueDiligence_InformationAsAt=By.xpath("//input[@id='DueDiligence_InformationAsAt']");


	private By customerProfile_DueDiligence_PropertyType=By.xpath("//select[@id='PropertyTypeId']");

	private By customerProfile_DueDiligence_SourceOfFunds=By.xpath("//textarea[@id='DueDiligence_SourceOfFunds']");
	private By customerProfile_DueDiligence_SourceOfFundsEvidence=By.xpath("//textarea[@id='DueDiligence_SourceOfFundsEvidence']");	
	private By customerProfile_DueDiligence_AddNextStepButton=By.xpath("//button[@id='buttonAddNextSteps']");	

	private By customerProfile_DueDiligence_NextStepTextArea=By.xpath("//textarea[@id='textBoxNextStepModal']");	

	private By customerProfile_DueDiligence_AddConversationButton=By.xpath("//button[@id='buttonAddConversation']");	

	private By customerProfile_DueDiligence_RecordOfConversationModalTextArea=By.xpath("//textarea[@id='textBoxRecordOfConversationModal']");	

	private By customerProfile_DueDiligence_AddRGConversationButton=By.xpath("//button[@id='buttonAddRGConversation']");	

	private By customerProfile_DueDiligence_textBoxTESSNumberModal=By.xpath("//input[@id='textBoxTESSNumberModal']");	

	private By customerProfile_DueDiligence_AddOutcomeButton=By.xpath("//button[@id='buttonAddOutcome']");

	private By customerProfile_DueDiligence_ReasonForReview=By.xpath("//select[@id='textBoxReasonForReview']");

	private By customerProfile_DueDiligence_CustomerRiskAssessment=By.xpath("//select[@id='DueDiligence_Outcome_RiskAssessment']");

	private By customerProfile_DueDiligence_Outcome_Decision = By.xpath("//select[@id='DueDiligence_Outcome_Decision']");

	private By customerProfile_DueDiligence_Manager=By.xpath("//input[@id='textBoxManager']");



	private By customerProfile_DueDiligence_textAreaRationale=By.xpath("//textarea[@id='textAreaRationale']");

	private By customerProfile_DueDiligence_AddAttachmentButton=By.xpath("//button[@id='buttonAddAttachment']");

	private By customerProfile_DueDiligence_BrowseButton=By.xpath("//input[@id='textBoxEvidenceFile']");
	//input[@id='textBoxAttachmentFileName']

	private By customerProfile_DueDiligence_saveButton=By.xpath("//button[@id='buttonSave']");

	//attachment
	By customerProfile_DueDiligence_Attachment_TypeDropdown = By.xpath("//select[@id='dropDownEvidenceType']");
	By customerProfile_DueDiligence_Attachment_deascription = By.xpath("//input[@id='textBoxEvidenceDescription']");

	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll']");
	private By customerProfile_DueDiligence_detailsButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Details')]");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By closeButton=By.xpath("//button[@class='btn btn-default active'][@tabindex='-1'][@ng-click='tabClose($event)']");
	//private By okButton=By.xpath("//button[contains(.,'OK')]");

	private By okButton=By.xpath("//button[@data-ig-type='OK']");

	private By customerProfile_DueDiligence_Details_Customer=By.xpath("//div[@id='expanderEDDCustomer_info']//div//div//div//div");
	private By customerProfile_DueDiligence_Details_DDdETAILS=By.xpath("//div[@id='expanderEDDDetails_info']//div//div");	
	private By customerProfile_DueDiligence_Details_outcome=By.xpath("//div[@id='expanderEDDOutcome_info']//div//div");

	private By customerProfile_DueDiligence_Details_DDdETAILS1=By.xpath("//div[@id='expanderEDDDetails_info']//div//div//input");
	private By customerProfile_DueDiligence_Details_DDdETAILS3=By.xpath("//section[@id='sectionEnhancedDueDiligenceDetails']//div[@id='expanderEDDDetails_info']//div//div//div[2]//div//label");
	private By customerProfile_DueDiligence_Details_DDdETAILS4=By.xpath("//section[@id='sectionEnhancedDueDiligenceDetails']//div[@id='expanderEDDDetails_info']//div//div//div[2]//div//textarea");

	private By	customerProfile_DueDiligence_Details_DDdETAILS5=By.xpath("//section[@id='sectionEnhancedDueDiligenceDetails']//div[@id='expanderEDDDetails_info']//div//div//div[3]//div//label");
	private By customerProfile_DueDiligence_Details_DDdETAILS6=By.xpath("//section[@id='sectionEnhancedDueDiligenceDetails']//div[@id='expanderEDDDetails_info']//div//div//div[3]//div//input");


	//	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll']");
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");	
	private By tableHeader=By.xpath("//table[@class='grid datagrid']//thead//tr//th");

	private By tableRGConverstations=By.xpath("//div[@id='tableRGConverstations']//table[@class='grid datagrid table ig-table']//tbody//tr");	
	private By tableRGConverstationsHeader=By.xpath("//div[@id='tableRGConverstations']//table[@class='grid datagrid table ig-table']//thead//tr//th");


	private By tableNextSteps=By.xpath("//div[@id='tableNextSteps']//table[@class='grid datagrid table ig-table']//tbody//tr");	
	private By tableNextStepsHeader=By.xpath("//div[@id='tableNextSteps']//table[@class='grid datagrid table ig-table']//thead//tr//th");	

	private By tableConverstations=By.xpath("//div[@id='tableConversations']//table[@class='grid datagrid table ig-table']//tbody//tr");	
	private By tableConverstationsHeader=By.xpath("//div[@id='tableConversations']//table[@class='grid datagrid table ig-table']//thead//tr//th");	

	private By tablecolumn;
	private By customerProfile_DueDiligence_Details_Customer1;
	By DueDiligence_Status = By.xpath("//label[contains(text(),'Current State')]/following-sibling::p");

	public void navigateToCustomerTab()
	{
		objUtilities.logReporter("Click on Customers Menu tab", objWrapperFunctions.click(customersMainTab), false);
		//objWrapperFunctions.waitForElementToBeClickable(customersTab);
		objUtilities.logReporter("Click on Customers tab", objWrapperFunctions.click(customersTab), false);
	}	

	public void findCustomer()
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findInputBox,custNumber), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);
	}		

	public String getDueDiligenceStatus()
	{
		objPojo.getWaitMethods().sleep(8);
		return objPojo.getObjWrapperFunctions().getText(DueDiligence_Status);	
	}
	public void clickDueDiligenceTab()
	{
		objWrapperFunctions.scrollTab(customerProfile_DueDiligenceTab);
	}

	public void createNewDueDiligenceByClickingAddButton()
	{
		objUtilities.logReporter("Click on Add button", 
				objWrapperFunctions.click(customerProfile_DueDiligence_AddButton), false);	
	}

	public void selectReasonForCreation(String reason)
	{
		objUtilities.logReporter("Click on reson for dropdown ", 
				objWrapperFunctions.click(customerProfile_DueDiligence_SelectReason), false);	
		verifyOptionsfromResonForCreationDropdown("Black Card Customer");
		verifyOptionsfromResonForCreationDropdown("Cash Drop (Manual Record)");
		verifyOptionsfromResonForCreationDropdown("Change in Customer Behaviour");
		verifyOptionsfromResonForCreationDropdown("Periodic Review");
		verifyOptionsfromResonForCreationDropdown("Customer Loss (Manual Record)");
		//verifyOptionsfromResonForCreationDropdown("Other");
		verifyOptionsfromResonForCreationDropdown("Politically Exposed Person (PEP)");
		verifyOptionsfromResonForCreationDropdown("Suspicious Activity Report (SAR)");
		verifyOptionsfromResonForCreationDropdown("Third Party Information / C6");
		objUtilities.logReporter("Select reason", objWrapperFunctions.selectDropDownByVisibleText(customerProfile_DueDiligence_SelectReason,reason), false);	
	}

	public void setReason()
	{
		objUtilities.logReporter("Enter Reason", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_reasonForCreation,"test"), false);		
	}

	public void switchToALertNClick()
	{
		objWrapperFunctions.acceptMultipleAlert(okButton);
	}


	public void clickOnYes()
	{
		objWrapperFunctions.waitForElementPresence(yesBtn);
		objWrapperFunctions.waitForElementToBeClickable(yesBtn);
		objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(yesBtn), false);
	}
	public void clickOnOk()
	{
		objWrapperFunctions.waitForElementPresence(okButton);
		objWrapperFunctions.waitForElementToBeClickable(okButton);
		objUtilities.logReporter("Click on Ok button", objWrapperFunctions.click(okButton), false);
	}

	public void verifyDueDligenceTableHeadersOnCustomerProfile()
	{
		try {
			Thread.sleep(5000);
			By table = By.xpath("//table[@class='grid datagrid']");
			objUtilities.logReporter(" verifyDueDiligenceFilterTableHeaders ", 
					objWrapperFunctions.verifyTableHeaders(table,"Name","Reason For Creation","Loss Value","Casino","Date Opened","Date Closed","Last Visit","Visits Since Opened","Due Diligence State"), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void verifyLossValueDisplayedOnEDDRecord(String actualValue)
	{
		By lossValue = By.xpath("//label[contains(text(),'Loss Value')]/following-sibling::p");
		String value = objPojo.getObjWrapperFunctions().getText(lossValue);
		actualValue = "£"+actualValue+".00";
		System.out.println(value);
		System.out.println("actualValue "+actualValue);
		objUtilities.logReporter("loss value displayed correctly",value.equals(actualValue), false);

	}
	public void setLossValue(String lossValue)
	{
		objUtilities.logReporter("Enter Loss value", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_actualLossAmount,lossValue), false);	
	}
	public void verifyOptionsfromResonForCreationDropdown(String reason)
	{
		By webEle = By.xpath("//select[@id='dropdownNewEDDReason']//option[contains(text(),'"+ reason +"')]");
		objUtilities.logReporter("Verify option '"+reason+"' display in Reason for creation dropdown", 
				objWrapperFunctions.checkElementDisplyed(webEle), false);	
	}

	public void clickOnAddButtonFromAttachmentSection()
	{
		objUtilities.logReporter("Click on Add Attachment Button", objWrapperFunctions.click(customerProfile_DueDiligence_AddAttachmentButton), false);	
	}

	public void selectTypeFromDropdown()
	{
		objUtilities.logReporter("Click on type dropdown ", 
				objWrapperFunctions.click(customerProfile_DueDiligence_Attachment_TypeDropdown), false);	
		verifyTypeDropdownOption("Document");
		verifyTypeDropdownOption("Image");
		verifyTypeDropdownOption("Media File");
		verifyTypeDropdownOption("URL");
		objUtilities.logReporter("Select Type as Image", 
				objWrapperFunctions.selectDropDownByVisibleText(customerProfile_DueDiligence_Attachment_TypeDropdown,"Image"), false);	
	}

	public void verifyTypeDropdownOption(String types)
	{
		By webEle = By.xpath("//select[@id='dropDownEvidenceType']//option[contains(text(),'"+ types +"')]");	
		objUtilities.logReporter("Verify option '"+types+"' display in Reason for creation dropdown", 
				objWrapperFunctions.checkElementDisplyed(webEle), false);	
	}

	public void setDescription()
	{
		objUtilities.logReporter("Enter Description", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_Attachment_deascription,"test purpose only"), false);	

	}

	public void addFileAsAttachment()
	{
		browseFile();
		clickOnOk();
	}

	public void browseFile()
	{
		try {
			objUtilities.logReporter("Click on Browse Button ", objWrapperFunctions.click(customerProfile_DueDiligence_BrowseButton), false);
			objPojo.getWaitMethods().sleep(10);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/AutoIt3/attachedImage.exe");
			clickOnOk();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void addAttachement()
	{	
		try {
			objUtilities.logReporter("Click on Add Attachment Button", objWrapperFunctions.click(customerProfile_DueDiligence_AddAttachmentButton), false);
			objUtilities.logReporter("Click on Browse Button ", objWrapperFunctions.click(customerProfile_DueDiligence_BrowseButton), false);	
			Thread.sleep(10000);
			Runtime.getRuntime().exec("C:/SQS_Automation_Trinity_Framework/AutoIt3/attachedImage.exe");
			objWrapperFunctions.waitForElementPresence(okButton);
			objWrapperFunctions.waitForElementToBeClickable(okButton);
			//objWrapperFunctions.acceptMultipleAlert(okButton);
			objUtilities.logReporter("Click on OK button", objWrapperFunctions.click(okButton), false);
			objWrapperFunctions.waitForElementPresence(okButton);
			objWrapperFunctions.waitForElementToBeClickable(okButton);
			objUtilities.logReporter("Click on OK button", objWrapperFunctions.click(okButton), false);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
	
	public void setEnterBusinessRelationshipStartDate(String date)
	{
		objUtilities.logReporter("Set Business Relationship StartDate", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_BusinessRelationshipStartDate,date), false);	
	}
	
	public void setOccupation(String occupationDet)
	{
		objUtilities.logReporter("Enter Occupation", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_Occupation,occupationDet), false);
	}
	
	public void setPositionHeld(String PositionHeld)
	{
		objUtilities.logReporter("Enter Position held", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_PositionHeld,PositionHeld), false);
	}
	public void setEmployer(String EmployerDet)
	{
		objUtilities.logReporter("Enter Employer details", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_Employer,EmployerDet), false);
	}
	public void setBusinessAddress(String busAdd)
	{
		objUtilities.logReporter("Enter Business Address",
				objWrapperFunctions.setText(customerProfile_DueDiligence_BusinessAddress,busAdd), false);
	}
	
	public void setPropertyMarketValue(String propertyMarketValue)
	{
		objUtilities.logReporter("Enter Property Market Value", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_PropertyMarketValue,propertyMarketValue), false);
	}
	
	public void setSourceofInformation(String infoDetails)
	{
		objUtilities.logReporter("Enter source of information", 
				objWrapperFunctions.setText(customerProfile_DueDiligence_SourceOfInformation,infoDetails), false);
	}
	public void selectPropertyType(String type)
	{
		try {
		objWrapperFunctions.click(customerProfile_DueDiligence_PropertyType);
		
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//By propertyType_options = By.xpath("//select[@id='DueDiligence_PropertyType']//option[contains(.,'"+type+"')]");
		objUtilities.logReporter("Select PropertyType", 
				objWrapperFunctions.selectDropDownByVisibleText(customerProfile_DueDiligence_PropertyType,type), false);
	}
	
	  
	  
	  public void verifyInformationAsAtLabel()
	  {
		 By  customerProfile_DueDiligence_InformationAsAtlabel = By.xpath("//label[@class='control-label'][@text='Information As At']");
		  objUtilities.logReporter("verify InformationAsAtLabel", objWrapperFunctions.verifyIsElementPresent(customerProfile_DueDiligence_InformationAsAtlabel), false);
	  }
	
	  public void setSourceofFunds(String infoDetails)
		{
		  objUtilities.logReporter("Enter source of funds", objWrapperFunctions.setText(customerProfile_DueDiligence_SourceOfFunds,infoDetails), false);
		}
	  
	  public void setEvidencetosupportsourceoffunds(String fundsDetails)
		{
		  objUtilities.logReporter("Enter Evidence to support source of funds", 
				  objWrapperFunctions.setText(customerProfile_DueDiligence_SourceOfFundsEvidence,fundsDetails), false);
		}
	
	  
	public void addNewEnhancedDueDiligence()
	{
		try 
		{
			objUtilities.logReporter("Click on Add button", objWrapperFunctions.click(customerProfile_DueDiligence_AddButton), false);
			objUtilities.logReporter("Select reason", objWrapperFunctions.selectDropDownByIndex(customerProfile_DueDiligence_SelectReason,0), false);
			objUtilities.logReporter("Enter Reason", objWrapperFunctions.setText(customerProfile_DueDiligence_reasonForCreation,"test"), false);	
			objWrapperFunctions.acceptMultipleAlert(okButton);
			Thread.sleep(7000);
			String date=objUtilities.getCurrentDate("ddMMyyyy");
			System.out.println(date);
			//objWrapperFunctions.click(customerProfile_DueDiligence_BusinessRelationshipStartDate);
			
			

			//	objUtilities.logReporter("Enter Occupation", objWrapperFunctions.setText(customerProfile_DueDiligence_Occupation,"Test"), false);
			

		
			
			

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void clickOnAddNextStepButton()
	{
		objPojo.getWaitMethods().sleep(10);
		objUtilities.logReporter("Click on AddNextStep button", objWrapperFunctions.click(customerProfile_DueDiligence_AddNextStepButton), false);	
	}
	
	public void clickOnAddConversationButton()
	{
		By customerProfile_DueDiligence_AddConversationButton = By.xpath("//button[@id='buttonAddConversation']");
		objPojo.getWaitMethods().sleep(10);
		objUtilities.logReporter("Click on AddConversation button", objWrapperFunctions.click(customerProfile_DueDiligence_AddConversationButton), false);	
	}
	
	
	public void AddRecordOfConversation(String stepDet)
	{
		By customerProfile_DueDiligence_RecordOfConversation = By.xpath("//label[@class='control-label'][contains(.,'Record Of Conversation')]//following::textarea[@id='textBoxRecordOfConversationModal']");
		objPojo.getWaitMethods().sleep(10);
		objUtilities.logReporter("Enter RecordOfConversation details", objWrapperFunctions.setText(customerProfile_DueDiligence_RecordOfConversation,stepDet), false);
	}
	
	public void verifyNextStepHeaders()
	{
	By table =By.xpath("//div[@id='tableNextSteps']//table[@class='grid datagrid table ig-table']");
	objUtilities.logReporter(" verify NextStepHeaders ", 
			objWrapperFunctions.verifyTableHeaders(table,"Next Step","As At Date","User","Casino"), false);
	}
	
	public void verifyConversationTableHeaderDetails()
	{
	By table =By.xpath("//div[@id='tableConversations']//table[@class='grid datagrid table ig-table']");
	objUtilities.logReporter(" verify Conversation Table Headers ", 
			objWrapperFunctions.verifyTableHeaders(table,"Record Of Conversation","As At Date","User","Casino"), false);
	}
	
	public void verifyAttachmentTableHeaders()
	{
	By table =By.xpath("//div[@id='tableAttachments']//table[@class='grid datagrid table ig-table']");
	objUtilities.logReporter(" verify Conversation Table Headers ", 
			objWrapperFunctions.verifyTableHeaders(table,"Type","Description","File Name"), false);
	}
	
	public void addNextStepDetails(String stepDet)
	{
		objUtilities.logReporter("Enter Next Step details", objWrapperFunctions.setText(customerProfile_DueDiligence_NextStepTextArea,stepDet), false);	
	}

	public void addNextSteps()
	{
		try
		{
			Thread.sleep(5000);
			objUtilities.logReporter("Click on AddNextStep button", objWrapperFunctions.click(customerProfile_DueDiligence_AddNextStepButton), false);	
			objUtilities.logReporter("Enter Next Step details", objWrapperFunctions.setText(customerProfile_DueDiligence_NextStepTextArea,"test"), false);
			objWrapperFunctions.acceptMultipleAlert(okButton);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void addConversation()
	{
		try
		{
			Thread.sleep(6000);	
			objUtilities.logReporter("Click on AddConversation button", objWrapperFunctions.click(customerProfile_DueDiligence_AddConversationButton), false);	
			objUtilities.logReporter("Enter Record Of Conversation Modal details", objWrapperFunctions.setText(customerProfile_DueDiligence_RecordOfConversationModalTextArea,"test"), false);
			objWrapperFunctions.acceptMultipleAlert(okButton);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRGConversations()
	{
		try
		{
			Thread.sleep(6000);
			objWrapperFunctions.waitForElementPresence(customerProfile_DueDiligence_AddRGConversationButton);
			objWrapperFunctions.waitForElementToBeClickable(customerProfile_DueDiligence_AddRGConversationButton);
			objUtilities.logReporter("Click on Add RG Conversation button", objWrapperFunctions.click(customerProfile_DueDiligence_AddRGConversationButton), false);		
			objUtilities.logReporter("Enter Record Of Conversation Modal details", objWrapperFunctions.setText(customerProfile_DueDiligence_textBoxTESSNumberModal,"21"), false);
			objWrapperFunctions.acceptMultipleAlert(okButton);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void verifyAddOutcomeButton()
	{
		objUtilities.logReporter("Verify AddOutCome button", 
				objWrapperFunctions.checkElementDisplyed(customerProfile_DueDiligence_AddOutcomeButton), false);
	}
	public void clickOnAddOutcomeButton()
	{
		objUtilities.logReporter("Click on AddOutCome button", 
				objWrapperFunctions.click(customerProfile_DueDiligence_AddOutcomeButton), false);
	}

	public void saveDuediligenceRecord()
	{
		objPojo.getObjWrapperFunctions().waitForElementToBeClickable(customerProfile_DueDiligence_saveButton);
		objUtilities.logReporter("Click on Save button", 
				objWrapperFunctions.click(customerProfile_DueDiligence_saveButton), false);
	}

	public void selectReasonForReview(String reason)
	{
		objUtilities.logReporter("Select Reason For Review",
				objWrapperFunctions.selectDropDownByVisibleText(customerProfile_DueDiligence_ReasonForReview,reason), false);
	}

	public void selectCustomerRiskAssessment(String reason)
	{
		objUtilities.logReporter("Select customer RiskAssessment ",
				objWrapperFunctions.selectDropDownByVisibleText(customerProfile_DueDiligence_CustomerRiskAssessment,reason), false);
	}

	public void setRationaleforDecisionDetails()
	{
		objUtilities.logReporter("Enter Rationale for decision details",
				objWrapperFunctions.setText(customerProfile_DueDiligence_textAreaRationale,"test"), false);
	}
	public void setDecision(String option)
	{
		objUtilities.logReporter("Select decision as '"+option+"' ",
				objWrapperFunctions.selectDropDownByVisibleText(customerProfile_DueDiligence_Outcome_Decision,option), false);
	}
	public void addOutCome()
	{
		try
		{
			Thread.sleep(6000);	
			objWrapperFunctions.waitForElementToBeClickable(customerProfile_DueDiligence_AddOutcomeButton);
			objUtilities.logReporter("Click on AddOutCome button", objWrapperFunctions.click(customerProfile_DueDiligence_AddOutcomeButton), false);	

			objUtilities.logReporter("Select Reason For Review", objWrapperFunctions.selectDropDownByIndex(customerProfile_DueDiligence_ReasonForReview,1), false);
			objUtilities.logReporter("Select reason", objWrapperFunctions.selectDropDownByIndex(customerProfile_DueDiligence_CustomerRiskAssessment,1), false);
			objUtilities.logReporter("Enter Rationale for decision details", objWrapperFunctions.setText(customerProfile_DueDiligence_textAreaRationale,"test"), false);
			objUtilities.logReporter("Click on Save button", objWrapperFunctions.click(customerProfile_DueDiligence_saveButton), false);

			String msg=objWrapperFunctions.getText(text);
			System.out.println(msg);
			objWrapperFunctions.acceptMultipleAlert(okButton);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeTab()
	{
		//objUtilities.logReporter("Click on X ", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(closeButton, 1)), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeButton), false);	
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeButton), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeButton), false);

		/*objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);*/

	}

	public void ClickOnDetailsButton()
	{
		objPojo.getWaitMethods().sleep(10);
		objUtilities.logReporter("Click on Details Button ",
				objWrapperFunctions.clickByScript(customerProfile_DueDiligence_detailsButton), false);
	}
	public void viewCustomerDueDiligenceDetails()
	{
		navigateToCustomerTab();
		findCustomer();
		clickDueDiligenceTab();
		System.out.println("************Customer Due Diligence Details **************");		
		int tablesize=objWrapperFunctions.getElementSize(table);
		int columnSize=objWrapperFunctions.getElementSize(tableHeader);
		//System.out.println(columnSize);
		for(int i=1;i<=tablesize;i++)
		{
			for(int j=1;j<=columnSize;j++)
			{
				tableHeader=By.xpath("//table[@class='grid datagrid']//thead//tr[1]//th["+j+"]");			
				tablecolumn=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td["+j+"]");
				System.out.println(objWrapperFunctions.getText(tableHeader)+ "= " +objWrapperFunctions.getText(tablecolumn) );

			}
		}
		objUtilities.logReporter("Click on Details Button ", objWrapperFunctions.click(customerProfile_DueDiligence_detailsButton), false);
		//addAttachement();
		String headingText=objWrapperFunctions.getText(headingTxt);
		System.out.println("*********Customer " + headingText + "**********");	
		for(int j=1;j<=10;j++)
		{
			customerProfile_DueDiligence_Details_Customer=By.xpath("//div[@id='expanderEDDCustomer_info']//div//div//div//div["+j+"]//label");
			customerProfile_DueDiligence_Details_Customer1=By.xpath("//div[@id='expanderEDDCustomer_info']//div//div//div//div["+j+"]//p");		
			System.out.println(objWrapperFunctions.getText(customerProfile_DueDiligence_Details_Customer)+ "= " +objWrapperFunctions.getText(customerProfile_DueDiligence_Details_Customer1));

		}

		for(int i=1;i<=4;i++)
		{
			customerProfile_DueDiligence_Details_DDdETAILS=By.xpath("//section[@id='sectionEnhancedDueDiligenceDetails']//div[@id='expanderEDDDetails_info']//div//div//div//div["+i+"]//label");
			customerProfile_DueDiligence_Details_DDdETAILS1=By.xpath("//section[@id='sectionEnhancedDueDiligenceDetails']//div[@id='expanderEDDDetails_info']//div//div//div//div["+i+"]//input");
			//customerProfile_DueDiligence_Details_DDdETAILS1=By.xpath("//section[@id='sectionEnhancedDueDiligenceDetails']//div[@id='expanderEDDDetails_info']//div//div//div//div["+i+"]//div//div//input");
			System.out.println(objWrapperFunctions.getText(customerProfile_DueDiligence_Details_DDdETAILS)+ "= " +objWrapperFunctions.getAttributeValue(customerProfile_DueDiligence_Details_DDdETAILS1,"Value"));
		}

		System.out.println(objWrapperFunctions.getText(customerProfile_DueDiligence_Details_DDdETAILS3)+ "= " +objWrapperFunctions.getText(customerProfile_DueDiligence_Details_DDdETAILS4));		
		System.out.println(objWrapperFunctions.getText(customerProfile_DueDiligence_Details_DDdETAILS5)+ "= " +objWrapperFunctions.getAttributeValue(customerProfile_DueDiligence_Details_DDdETAILS6,"value"));
		System.out.println("Property Type = "+objWrapperFunctions.getSelectedValueFromDropDown(customerProfile_DueDiligence_PropertyType));
		System.out.println("Evidence To Support Source Of Funds  = "+objWrapperFunctions.getText(customerProfile_DueDiligence_SourceOfFundsEvidence));
		System.out.println("********* Outcome Details **********");
		System.out.println("ReasonForReview = "+objWrapperFunctions.getSelectedValueFromDropDown(customerProfile_DueDiligence_ReasonForReview));
		System.out.println("Customer Risk Assessment = "+objWrapperFunctions.getSelectedValueFromDropDown(customerProfile_DueDiligence_CustomerRiskAssessment));	
		System.out.println("Outcome_Decision = "+objWrapperFunctions.getSelectedValueFromDropDown(customerProfile_DueDiligence_Outcome_Decision));
		System.out.println("Rationale For Decision  = "+objWrapperFunctions.getText(customerProfile_DueDiligence_textAreaRationale));
		System.out.println("Manager = "+objWrapperFunctions.getAttributeValue(customerProfile_DueDiligence_Manager,"value"));
		System.out.println("********* Next Steps Details **********");
		viewNextStepsDetails();
		System.out.println("********* Conversation Details **********");
		viewConversation();
		System.out.println("********* RG Conversation Details **********");
		viewRGConversation();

	}


	public void viewRGConversation()
	{
		int tablesize=objWrapperFunctions.getElementSize(tableRGConverstations);
		int columnSize=objWrapperFunctions.getElementSize(tableRGConverstationsHeader);
		//System.out.println(columnSize);
		for(int i=1;i<=tablesize;i++)
		{
			for(int j=1;j<=columnSize;j++)
			{
				tableRGConverstationsHeader=By.xpath("//div[@id='tableRGConverstations']//table[@class='grid datagrid table ig-table']//thead//tr[1]//th["+j+"]");

				tablecolumn=By.xpath("//div[@id='tableRGConverstations']//table[@class='grid datagrid table ig-table']//tbody//tr["+i+"]//td["+j+"]");

				System.out.println(objWrapperFunctions.getText(tableRGConverstationsHeader)+ "= " +objWrapperFunctions.getText(tablecolumn) );

			}
		}
	}


	public void viewConversation()
	{
		int tablesize=objWrapperFunctions.getElementSize(tableConverstations);
		int columnSize=objWrapperFunctions.getElementSize(tableConverstationsHeader);
		//System.out.println(columnSize);
		for(int i=1;i<=tablesize;i++)
		{
			for(int j=1;j<=columnSize;j++)
			{
				tableConverstationsHeader=By.xpath("//div[@id='tableConversations']//table[@class='grid datagrid table ig-table']//thead//tr[1]//th["+j+"]");	

				tableConverstations=By.xpath("//div[@id='tableConversations']//table[@class='grid datagrid table ig-table']//tbody//tr["+i+"]//td["+j+"]");	
				//tablecolumn=By.xpath("//div[@id='tableRGConverstations']//table[@class='grid datagrid table ig-table']//tbody//tr["+i+"]//td["+j+"]");

				System.out.println(objWrapperFunctions.getText(tableConverstationsHeader)+ "= " +objWrapperFunctions.getText(tableConverstations) );

			}
		}
	}


	public void viewNextStepsDetails()
	{
		int tablesize=objWrapperFunctions.getElementSize(tableNextSteps);
		int columnSize=objWrapperFunctions.getElementSize(tableNextStepsHeader);
		//System.out.println(columnSize);
		for(int i=1;i<=tablesize;i++)
		{
			for(int j=1;j<=columnSize;j++)
			{		 
				tableNextStepsHeader=By.xpath("//div[@id='tableNextSteps']//table[@class='grid datagrid table ig-table']//thead//tr[1]//th["+j+"]");					
				tableNextSteps=By.xpath("//div[@id='tableNextSteps']//table[@class='grid datagrid table ig-table']//tbody//tr["+i+"]//td["+j+"]");
				System.out.println(objWrapperFunctions.getText(tableNextStepsHeader)+ "= " +objWrapperFunctions.getText(tableNextSteps) );

			}
		}
	}
}
