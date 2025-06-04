package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_AddSuspendedSuspension_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",user="",message="",temp="";
	static String refId_FE="";
	
	public customerProfile_AddSuspendedSuspension_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}
	
	private By customersMainTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By customersTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	private By findInputBox=By.xpath("//input[@id='Surname']");
	private By findCustomerInput = By.xpath("//input[@id='Number']");
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By headingTxt=By.xpath("//h2[@id='layoutCaption']");
	private By customerfind_Deatils;
	private By customerProfile_SuspensionsTab=By.xpath("//section[@class='sidebar']//li[@id='tabSuspensions']//a[contains(.,'Suspensions')]");
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");
	private By custStatus;	
	private By customerProfile_Suspensions_DetailsSection1=By.xpath("//div[@class='three-col']//div//fieldset//div");
	private By customerProfile_Suspensions_DetailsSection2=By.xpath("//div[@class='three-col']//div//fieldset[2]//div");
	private By customerProfile_Suspensions_DetailsSection3=By.xpath("//div[@class='three-col']//div//fieldset[3]//div");	
	private By customerProfile_Suspensions_AddButton=By.xpath("//button[@id='buttonAddSuspension'][contains(.,'Add')]");
	//private By customerProfile_Suspensions_LiftButton=By.xpath("//button[@class='btn-warning btn-secured'][contains(.,'Lift')]");
	private By customerProfile_Suspensions_LiftButton=By.xpath("(//button[@class='btn-warning btn-secured'][contains(.,'Lift')])[1]");
	private By customerProfile_Suspensions_Add_SuspensionType=By.xpath("//select[@id='dropDownSuspensionType']");
	private By customerProfile_Suspensions_Add_ExpiryDate=By.xpath("//input[@id='CustomerSuspension_ExpiryGamingDate']");
	private By customerProfile_Suspensions_Add_Notes=By.xpath("//textarea[@id='CustomerSuspension_Notes']");
	private By customerProfile_Suspensions_Add_Message=By.xpath("//textarea[@id='CustomerSuspension_Messages']");	
	private By customerProfile_Suspensions_Add_commit=By.xpath("//footer//button[contains(.,'Commit')]");
	
	private By createnewCreditAcc_selectManager= By.xpath("//td//span[@class='ng-binding'][contains(.,'Gadekar')]");
	private By customerProfile_Suspensions_Lift_authorisedUser_SurName=By.xpath("//div[@id='divEmployeeListController']//table[@class='grid datagrid']//tbody//tr[5]//td[1]");
	private By customerProfile_Suspensions_Lift_authorisedUser_ForeName=By.xpath("//div[@id='divEmployeeListController']//table[@class='grid datagrid']//tbody//tr[5]//td[2]");	
	private By customerProfile_Suspensions_Lift_Ok=By.xpath("//footer//button[contains(.,'OK')]");	
	
	
	private By customerProfile_Suspensions_Lift_message=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Suspension has already been lifted.')]");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	
	
	private By customerProfile_Suspensions_Lift_authorisedUserList=By.xpath("//div[@id='divEmployeeListController']//table[@class='grid datagrid']//tbody//tr");
	
	public void navigateToCustomerTab()
	{
	
		objUtilities.logReporter("Click on Customers Menu tab", objWrapperFunctions.click(customersMainTab), false);
		objWrapperFunctions.waitForElementToBeClickable(customersTab);
		objUtilities.logReporter("Click on Customers tab", objWrapperFunctions.click(customersTab), false);
	}	
		
	public void findCustomer(String custNum)
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findInputBox,custNum), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);
		/*int size1=objWrapperFunctions.getElementSize(table);			
			for(int i=1;i<=size1;i++)
			{
				custStatus=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9]");
				temp=objWrapperFunctions.getText(custStatus);
				//System.out.println(temp);
				if(temp.contains("Active")) 
				//if(temp.contains("Suspended"))
				{	
					customerfind_Deatils=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[10]");
					objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerfind_Deatils), false);
					break;
				}
				
			}*/
	}	
		
		
	public void clickSuspensionsTab()
	{
		try
		{
		Thread.sleep(3000);			
		//refId_FE=objWrapperFunctions.getText(headingTxt);
		objWrapperFunctions.waitForElementToBeClickable(customerProfile_SuspensionsTab);
		objWrapperFunctions.scrollTab(customerProfile_SuspensionsTab);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void viewSuspensioDetails()
	{
		System.out.println("****************** Customer Details ************************");
		System.out.println(refId_FE);
		objWrapperFunctions.displayAllElement(customerProfile_Suspensions_DetailsSection1);
		//objWrapperFunctions.displayAllElement(customerProfile_Suspensions_DetailsSection2);
		//objWrapperFunctions.displayAllElement(customerProfile_Suspensions_DetailsSection3);
	}
	
	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
	public void add_SuspendedSuspensionToCustAccount()
	{			
	try {
		Thread.sleep(3000);
		objUtilities.logReporter("Click on Add tab", objWrapperFunctions.click(customerProfile_Suspensions_AddButton), false);
		objUtilities.logReporter("Select suspension type as Suspended", objWrapperFunctions.selectDropDownByIndex(customerProfile_Suspensions_Add_SuspensionType,2), false);
		String date=objUtilities.getCurrentDate("ddMMyyyy");
		String convertedDate=objUtilities.modifyDaysFromDate(date,1,"ddMMyyyy");
		//System.out.println(convertedDate);
		objUtilities.logReporter("Set Expiry date", objWrapperFunctions.setText(customerProfile_Suspensions_Add_ExpiryDate,convertedDate), false);
		objUtilities.logReporter("Enter Notes", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Notes,"test"), false);
		objUtilities.logReporter("Enter Message", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Message,"test message"), false);		
		objUtilities.logReporter("Click on commit ", objWrapperFunctions.click(customerProfile_Suspensions_Add_commit), false);
		//System.out.println("Added Suspension type - Barred on a customer account");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addSuspensionToCustAccount()
	{			
	try {
		Thread.sleep(5000);
		objUtilities.logReporter("Click on Add tab", objWrapperFunctions.click(customerProfile_Suspensions_AddButton), false);
		//objUtilities.logReporter("Select suspension type as Suspended", objWrapperFunctions.selectDropDownByIndex(customerProfile_Suspensions_Add_SuspensionType,1), false);
		
		objUtilities.logReporter("Select suspension type as Suspended", objWrapperFunctions.selectDropDownOption(customerProfile_Suspensions_Add_SuspensionType,"Locally Resigned","text"), false);
		String date=objUtilities.getCurrentDate("ddMMyyyy");
		String convertedDate=objUtilities.modifyDaysFromDate(date,1,"ddMMyyyy");
		//System.out.println(convertedDate);
		objUtilities.logReporter("Set Expiry date", objWrapperFunctions.setText(customerProfile_Suspensions_Add_ExpiryDate,convertedDate), false);
		objUtilities.logReporter("Enter Notes", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Notes,"test"), false);
		objUtilities.logReporter("Enter Message", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Message,"test message"), false);		
		objUtilities.logReporter("Click on commit ", objWrapperFunctions.click(customerProfile_Suspensions_Add_commit), false);
		//System.out.println("Added Suspension type - Barred on a customer account");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addsuspension()
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findCustomerInput,custNumber), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);
		clickSuspensionsTab();
		addSuspensionToCustAccount();
		viewSuspensioDetails();
		liftSuspension();
	}
	
	public void liftSuspension()
	{
	 try
	 {
		clickOnLift();
		Thread.sleep(3000);
		if(objWrapperFunctions.checkElementDisplyed(customerProfile_Suspensions_Lift_message))
		{
			objWrapperFunctions.acceptMultipleAlert(customerProfile_Suspensions_Lift_Ok);
			//objUtilities.logReporter("Click on Ok ", objWrapperFunctions.click(customerProfile_Suspensions_Lift_Ok), false);
			add_SuspendedSuspensionToCustAccount();
			objUtilities.logReporter("Click on Lift tab", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(customerProfile_Suspensions_LiftButton, 0)), false);
		}
		
		
		
	/*	
		int size=objWrapperFunctions.getElementSize(customerProfile_Suspensions_Lift_authorisedUserList);
		System.out.println(size);
		for(int i=1;i<=size;i++)
		{
			//customerProfile_Suspensions_Lift_authorisedUser_SurName=By.xpath("//div[@id='divEmployeeListController']//table[@class='grid datagrid']//tbody//tr["+i+"]//td[1]");
			customerProfile_Suspensions_Lift_authorisedUser_ForeName=By.xpath("//div[@id='divEmployeeListController']//table[@class='grid datagrid']//tbody//tr["+i+"]//td[2]");
				
			String foreNameTxt=objWrapperFunctions.getText(customerProfile_Suspensions_Lift_authorisedUser_ForeName);
			System.out.println(foreNameTxt);
			if(foreNameTxt.contentEquals("Rank")==true)
			{
				objUtilities.logReporter("Click on Surname", objWrapperFunctions.click(customerProfile_Suspensions_Lift_authorisedUser_ForeName), false);
				break;
			}
		
		}
		*/
		
		
		
		
		//objUtilities.logReporter("Click on Lift tab", objWrapperFunctions.click(customerProfile_Suspensions_LiftButton), false);
		String surNameTxt=objWrapperFunctions.getText(customerProfile_Suspensions_Lift_authorisedUser_SurName);		
		String foreNameTxt=objWrapperFunctions.getText(customerProfile_Suspensions_Lift_authorisedUser_ForeName);
		//System.out.println("Authorised User : " +surNameTxt+ "  " +foreNameTxt);
		objUtilities.logReporter("Click on Surname", objWrapperFunctions.click(customerProfile_Suspensions_Lift_authorisedUser_SurName), false);
		//objUtilities.logReporter("Click on Surname", objWrapperFunctions.click(createnewCreditAcc_selectManager), false);	
		
		
		objUtilities.logReporter("Click on Ok ", objWrapperFunctions.click(customerProfile_Suspensions_Lift_Ok), false);
	 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnLift()
	{
		objWrapperFunctions.waitForElementPresence(customerProfile_Suspensions_LiftButton);
		objWrapperFunctions.waitForElementToBeClickable(customerProfile_Suspensions_LiftButton);
		objUtilities.logReporter("Click on Lift tab", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(customerProfile_Suspensions_LiftButton, 0)), false);
	}
}
