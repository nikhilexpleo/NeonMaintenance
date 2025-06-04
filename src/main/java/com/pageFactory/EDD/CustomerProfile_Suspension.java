package com.pageFactory.EDD;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class CustomerProfile_Suspension {
	//	private Utilities objUtilities;
	//private WrapperFunctions 
	private Pojo objPojo;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",expiryDate,gamingDate,suspensionType;
	static String refId_FE="";

	public CustomerProfile_Suspension(Pojo pojo)
	{
		/*objUtilities = pojo.getObjUtilities();
		objPojo.getObjWrapperFunctions() = pojo.getObjWrapperFunctions();*/
		this.objPojo = pojo;
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}

	private By customersMainTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By customersTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");

	private By findCustomer_NumberInput = By.xpath("//input[@id='Number']");
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By headingTxt=By.xpath("//h2[@id='layoutCaption']");

	private By customerfind_Deatils;
	private By customerProfile_SuspensionsTab=By.xpath("//section[@class='sidebar']//li[@id='tabSuspensions']//a[contains(.,'Suspensions')]");
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");

	private By customerProfile_Suspensions_DetailsSection1=By.xpath("//div[@class='three-col']//div//fieldset//div");
	private By customerProfile_Suspensions_DetailsSection2=By.xpath("//div[@class='three-col']//div//fieldset[2]//div");
	private By customerProfile_Suspensions_DetailsSection3=By.xpath("//div[@class='three-col']//div//fieldset[3]//div");	

	private By customerProfile_Suspensions_AddButton=By.xpath("//button[@id='buttonAddSuspension'][contains(.,'Add')]");
	private By customerProfile_Suspensions_LiftButton=By.xpath("//button[@class='btn-warning btn-secured'][contains(.,'Lift')]");
	private By customerProfile_Suspensions_Add_SuspensionType=By.xpath("//select[@id='dropDownSuspensionType']");
	private By customerProfile_Suspensions_Add_gamingDateDropdown = By.cssSelector("input#CustomerSuspension_GamingDate");
	private By customerProfile_Suspensions_Add_casinoDropdown = By.cssSelector("select#dropDownSuspensionCasino");
	private By customerProfile_Suspensions_Add_ExpiryDate=By.xpath("//input[@id='CustomerSuspension_ExpiryGamingDate']");
	private By customerProfile_Suspensions_Add_Notes=By.xpath("//textarea[@id='CustomerSuspension_Notes']");
	private By customerProfile_Suspensions_Add_Message=By.xpath("//textarea[@id='CustomerSuspension_Messages']");	
	private By customerProfile_Suspensions_Add_commit=By.xpath("//footer//button[contains(.,'Commit')]");
	private By customerProfile_Suspensions_Add_cancel=By.xpath("//button[@data-ig-type='Cancel']");

	private By customerProfile_Suspensions_Lift_authorisedUser = By.xpath("//span[@class='ng-binding'][contains(text(),'Gadekar')]");
	private By customerProfile_Suspensions_Lift_Ok = By.xpath("//button[@data-ig-type='OK']");	

	private By customerProfile_Suspensions_Lift_message=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Suspension has already been lifted.')]");
	private By closeIconTab=By.xpath("//div[@class='buttonbar']//div//button");


	public void navigateToCustomerTab()
	{
		objPojo.getWaitMethods().sleep(8);
		objPojo.getObjWrapperFunctions().waitForElementToBeClickable(customersMainTab);
		objPojo.getObjUtilities().logReporter("Click on Customers Menu tab", objPojo.getObjWrapperFunctions().click(customersMainTab), false);
		objPojo.getObjWrapperFunctions().waitForElementToBeClickable(customersTab);
		objPojo.getObjUtilities().logReporter("Click on Customers tab", objPojo.getObjWrapperFunctions().click(customersTab), false);
	}	

	public void clickOnCustomerMainMenu()
	{
		objPojo.getObjUtilities().logReporter("Click on Customers Menu tab", objPojo.getObjWrapperFunctions().clickByScript(customersMainTab), false);	
	}
	public void navigateToCustomerProfileandSelectTab(String sideTab)
	{	

		By webEle = By.xpath("//div[@ng-controller='customerMaintenanceController']/section[@class='sidebar']//following-sibling::ul/li/a[contains(text(),'"+sideTab+"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+sideTab+"'", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
		objPojo.getObjUtilities().logReporter("Click on '"+webEle+"'", 
				objPojo.getObjWrapperFunctions().clickByScript(webEle), false);
		objPojo.getWaitMethods().sleep(8);
	}


	public void verifyPageTitle(String title)
	{
		//Customer Suspension
		By pageTitle = By.xpath("//*[@class='modal-title'][contains(text(),'"+ title +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+pageTitle+"' display", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(pageTitle), false);	
	}

	public String verifyGamingDateDropdown()
	{
		objPojo.getObjUtilities().logReporter("Verify Gaming Date Dropdown ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(customerProfile_Suspensions_Add_gamingDateDropdown), false);	
		return objPojo.getObjWrapperFunctions().getAttributeValue(customerProfile_Suspensions_Add_gamingDateDropdown,"value");
	}


	public void selectCasinoDropdown(String casino)
	{
		if(objPojo.getObjWrapperFunctions().checkElementDisplyed(customerProfile_Suspensions_Add_casinoDropdown))
		{		
			objPojo.getObjUtilities().logReporter("Click on Casino Dropdown ",
					objPojo.getObjWrapperFunctions().click(customerProfile_Suspensions_Add_casinoDropdown), false);
			objPojo.getObjUtilities().logReporter("Select Casino as  '"+casino+"'",
					objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(customerProfile_Suspensions_Add_casinoDropdown,casino), false);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void findCustomerByUsingNumber(String custNumber )
	{
		objPojo.getObjUtilities().logReporter("search Customer Number '"+ custNumber +"'",
				objPojo.getObjWrapperFunctions().setText(findCustomer_NumberInput,custNumber), false);	
	}
	public void clickOnfindButton()
	{
		objPojo.getObjUtilities().logReporter("Click on Find button", objPojo.getObjWrapperFunctions().click(findButton), false);
	}	


	public void clickSuspensionsTab()
	{
		objPojo.getWaitMethods().sleep(4);	
		objPojo.getObjWrapperFunctions().click(customerProfile_SuspensionsTab);
		/*objPojo.getObjWrapperFunctions().waitForElementToBeClickable(customerProfile_SuspensionsTab);
		objPojo.getObjWrapperFunctions().scrollTab(customerProfile_SuspensionsTab);*/	
	}

	public void verifyAddButtonOnCustomerProfileSuspensionTab()
	{
		//objPojo.getWaitMethods().sleep(objPojo.getConfiguration().getConfigIntegerValue("minwait"));
		objPojo.getObjUtilities().logReporter("Verify Add button ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(customerProfile_Suspensions_AddButton), false);	
	}

	public void clickOnAddButton()
	{
		objPojo.getObjUtilities().logReporter("Click on Add tab", 
				objPojo.getObjWrapperFunctions().click(customerProfile_Suspensions_AddButton), false);
	}

	public void selectSuspensionType(String suspension)
	{
		suspensionType = suspension;
		objPojo.getObjUtilities().logReporter("Click on Suspension TypeDropdown ",
				objPojo.getObjWrapperFunctions().click(customerProfile_Suspensions_Add_SuspensionType), false);
		objPojo.getObjUtilities().logReporter("Select suspension type as ",suspension, 
				objPojo.getObjWrapperFunctions().selectDropDownByVisibleText(customerProfile_Suspensions_Add_SuspensionType,suspension), false);
	}

	public void closeTab()
	{
		objPojo.getObjUtilities().logReporter("Click on X ", objPojo.getObjWrapperFunctions().clickByScript(closeIconTab), false);
		objPojo.getObjUtilities().logReporter("Click on X ", objPojo.getObjWrapperFunctions().clickByScript(closeIconTab), false);
	}

	public boolean checkCloseButtonDisplay()
	{
		return objPojo.getObjWrapperFunctions().checkElementDisplyed(closeIconTab);
	}
	public void verifyCancelButton()
	{
		objPojo.getObjUtilities().logReporter("Verify Cancel button ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(customerProfile_Suspensions_Add_cancel), false);	
	}
	public void clickOnCancel()
	{
		objPojo.getObjUtilities().logReporter("Click on cancel ", 
				objPojo.getObjWrapperFunctions().click(customerProfile_Suspensions_Add_cancel), false);	
	}
	public void verifyCommitButton()
	{
		objPojo.getObjUtilities().logReporter("Verify Commit ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(customerProfile_Suspensions_Add_commit), false);	
	}

	public void clickOnCommit()
	{
		objPojo.getObjUtilities().logReporter("Click on commit ", 
				objPojo.getObjWrapperFunctions().click(customerProfile_Suspensions_Add_commit), false);	
	}
	public void setNotes()
	{
		objPojo.getObjUtilities().logReporter("Enter Notes", 
				objPojo.getObjWrapperFunctions().setText(customerProfile_Suspensions_Add_Notes,"test"), false);
	}

	public void setExpiryDate()
	{
		String date = objPojo.getObjUtilities().getCurrentDate("ddMMyyyy");
		expiryDate = objPojo.getObjUtilities().modifyDaysFromDate(date,2,"ddMMyyyy");
		//System.out.println(convertedDate);
		objPojo.getObjUtilities().logReporter("Set Expiry date", objPojo.getObjWrapperFunctions().setText(customerProfile_Suspensions_Add_ExpiryDate,expiryDate), false);	
	}

	public void setMessage()
	{
		objPojo.getObjUtilities().logReporter("Enter Message", 
				objPojo.getObjWrapperFunctions().setText(customerProfile_Suspensions_Add_Message,"test message"), false);			
	}

	public void verifyLabelsOnSuspensionScreens(String fieldName)
	{
		By webEle = By.xpath("//label[contains(text(),'"+ fieldName +"')]");
		objPojo.getObjUtilities().logReporter("Verify '"+fieldName+"' display on page ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);	
	}

	public String getLabelValue(String fieldName)
	{
		objPojo.getWaitMethods().sleep(8);	
		By webEle = By.xpath("//div/label[contains(.,'"+ fieldName +"')]/following-sibling::span");
		System.out.println(webEle);
		return  objPojo.getObjWrapperFunctions().getText(webEle); 
	}

	public void verifyValueDisplayCorrectlyOrNot(String temp,String temp2)
	{
		if(temp.equalsIgnoreCase(temp2))
		{
			objPojo.getObjUtilities().logReporter("Field Values display correctly ", 
					true, false);		
		}
		else
		{
			objPojo.getObjUtilities().logReporter("Wrong values displayed ", 
					false, false);	
		}
	}

	public void verifyValues(String temp,String temp2)
	{
		if(temp.contains(temp2))
		{
			objPojo.getObjUtilities().logReporter("Field Values display correctly ", 
					true, false);		
		}
		else
		{
			objPojo.getObjUtilities().logReporter("Wrong values displayed ", 
					false, false);	
		}	
	}

	public void verifySuspensionStatusDisplayedOnCustomerDetailsPage(String suspensionStatus)
	{
		By webEle = By.xpath("//span[@id='labelCustomerStatus'][contains(text(),'"+suspensionStatus+"')]");
		objPojo.getObjUtilities().logReporter("Verify Suspension Status Displayed as '"+suspensionStatus+"' on Customer Details Page  ", 
				objPojo.getObjWrapperFunctions().checkElementDisplyed(webEle), false);			
	}

	public void verifySuspensionStatusDoesNotDisplayOnCustmerDetailsAfterLiftSuspension(String suspensionStatus)
	{
		By webEle = By.xpath("//span[@id='labelCustomerStatus'][contains(text(),'"+suspensionStatus+"')]");
		objPojo.getObjUtilities().logReporter("Verify Suspension Status Displayed as '"+suspensionStatus+"' on Customer Details Page  ", 
				objPojo.getObjWrapperFunctions().checkElementNotDisplyed(webEle), false);	
	}
	public void liftSuspension(String user)
	{
		clickOnLift();	
		if(objPojo.getObjWrapperFunctions().checkElementDisplyed(customerProfile_Suspensions_Lift_message))
		{
			objPojo.getObjWrapperFunctions().acceptMultipleAlert(customerProfile_Suspensions_Lift_Ok);
			objPojo.getObjUtilities().logReporter("Click on Lift tab", objPojo.getObjWrapperFunctions().click(objPojo.getObjWrapperFunctions().getElementOfIndex(customerProfile_Suspensions_LiftButton, 0)), false);
		}

		selectAuthoriseUser(user);
		objPojo.getObjUtilities().logReporter("Click on Ok ", objPojo.getObjWrapperFunctions().click(customerProfile_Suspensions_Lift_Ok), false);	
	}

	public void selectAuthoriseUser(String user)
	{
		customerProfile_Suspensions_Lift_authorisedUser = By.xpath("//span[@class='ng-binding'][contains(text(),'"+ user +"')]");
		objPojo.getObjUtilities().logReporter("Select Authorise user ", objPojo.getObjWrapperFunctions().click(customerProfile_Suspensions_Lift_authorisedUser), false);
	}
	public void clickOnLift()
	{
		objPojo.getWaitMethods().sleep(10);
		objPojo.getObjWrapperFunctions().waitForElementPresence(customerProfile_Suspensions_LiftButton);
		objPojo.getObjWrapperFunctions().waitForElementToBeClickable(customerProfile_Suspensions_LiftButton);
		objPojo.getObjUtilities().logReporter("Click on Lift tab", objPojo.getObjWrapperFunctions().click(objPojo.getObjWrapperFunctions().getElementOfIndex(customerProfile_Suspensions_LiftButton, 0)), false);
	}

	public void viewSuspensioDetails()
	{
		System.out.println("****************** Customer Details ************************");
		System.out.println(refId_FE);
		objPojo.getObjWrapperFunctions().displayAllElement(customerProfile_Suspensions_DetailsSection1);
		//objPojo.getObjWrapperFunctions().displayAllElement(customerProfile_Suspensions_DetailsSection2);
		//objPojo.getObjWrapperFunctions().displayAllElement(customerProfile_Suspensions_DetailsSection3);
	}
}


