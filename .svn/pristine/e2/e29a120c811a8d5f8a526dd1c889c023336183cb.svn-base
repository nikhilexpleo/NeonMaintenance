package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_ViewCreditDetail_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",cardNumber="";
	static int tempRandom ;

	
	public customerProfile_ViewCreditDetail_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}
	
	private By customersMainTab=By.xpath("//li[@id='CustomerManagement_Menu']/a[contains(.,'Customers')]");
	private By customersTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	private By findInputBox=By.xpath("//input[@id='Number']");
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By customerProfile_ActionButton=By.xpath("//div[@class='actions']//button[@class='dropdown-toggle']");
	private By customerProfile_Action_CreditDetailsTab=By.xpath("//li//a[@id='buttonCreditAccount']");	
	
	//private By customerProfile_Action_CreditDetails_personalDetails=By.xpath("//div[@class='three-col']//div//fieldset");	
	private By customerProfile_Action_CreditDetails_personalDetails=By.xpath("//legend[text()='Personal Details']");
	private By customerProfile_Action_CreditDetails_personalDetails1=By.xpath("//div[@class='three-col']//div[2]//fieldset");
	private By customerProfile_CreditDetails_AccountLimit_limit=By.xpath("//input[@id='CreditAccount_Limit']");
	private By customerProfile_CreditDetails_AccountLimit_upperLimit=By.xpath("//input[@id='CreditAccount_SecondaryLimit']");		
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By okButton=By.xpath("//button[@data-ig-type='OK']");
	
	public void navigateToCustomerTab()
	{
		objUtilities.logReporter("Click on Customers Menu tab", objWrapperFunctions.click(customersMainTab), false);
		objUtilities.logReporter("Click on Customers tab", objWrapperFunctions.click(customersTab), false);
	}	
		
	public void findCustomer()
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findInputBox,custNumber), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);		
	}	
	
	public void viewCreditDetails()
	{
		try 
		{
		 Thread.sleep(5000);		
		 objUtilities.logReporter("Click on Action Button", objWrapperFunctions.click(customerProfile_ActionButton), false);
		 objUtilities.logReporter("Click on CreditDetailsTab", objWrapperFunctions.click(customerProfile_Action_CreditDetailsTab), false);	 	  
		 System.out.println("************Customer  Personal Details **********");
		 objWrapperFunctions.displayAllElement(customerProfile_Action_CreditDetails_personalDetails);
		 System.out.println("************ Account Limit Details **********");
		 System.out.println("Limit " +objWrapperFunctions.getAttributeValue(customerProfile_CreditDetails_AccountLimit_limit, "value"));
		 System.out.println("Upper Limit " +objWrapperFunctions.getAttributeValue(customerProfile_CreditDetails_AccountLimit_upperLimit, "value"));
		// objUtilities.logReporter("Click on ok button", objWrapperFunctions.click(okButton), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
}
