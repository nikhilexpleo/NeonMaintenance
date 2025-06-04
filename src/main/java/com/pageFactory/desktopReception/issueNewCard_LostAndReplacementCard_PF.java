package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class issueNewCard_LostAndReplacementCard_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",cardNumber="";
	static int tempRandom ;

	
	public issueNewCard_LostAndReplacementCard_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}
	
	private By customersMainTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By customersTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	private By findInputBox=By.xpath("//input[@id='Number']");
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By customerProfile_ActionButton=By.xpath("//div[@class='actions']//button[@class='dropdown-toggle']");
	private By customerProfile_Action_IssueCard=By.xpath("//li//a[@id='buttonIssueCard']");	
	private By customerProfile_Action_IssueCard_LostCard=By.xpath("//div//label//input[@id='radioButtonLost']");
	private By customerProfile_Action_IssueCard_ReplacementCard=By.xpath("//div//label//input[@id='radioButtonReplaced']");
	private By customerProfile_Action_IssueCard_NewCardNumber=By.xpath("//input[@id='textBoxCardNumber']");
	//private By customerProfile_Action_IssueCard_SaveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");
	private By customerProfile_Action_IssueCard_message=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This card has already been issued.')]");
	private By customerProfile_Action_IssueCard_Ok=By.xpath("//footer//button[contains(.,'OK')]");	
	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll']");
	private By customerProfile_Action_IssueCard_Details=By.xpath("//div[1]//fieldset[1]//div");
	private By customerProfile_Action_IssueCard_oldCardNumber=By.xpath("//input[@id='OldCardNumber']");	
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By customerProfile_Action_IssueCard_SaveButton=By.xpath("//button[@data-ig-type='Commit']");  
	
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
	
	public void issueNewCard_lostCard()
	{
		try 
		{
		 Thread.sleep(5000);		
		 objUtilities.logReporter("Click on Action Button", objWrapperFunctions.click(customerProfile_ActionButton), false);
		 objUtilities.logReporter("Click on issue card", objWrapperFunctions.click(customerProfile_Action_IssueCard), false);	 
		 objUtilities.logReporter("Click on Lost card", objWrapperFunctions.click(customerProfile_Action_IssueCard_LostCard), false);
		 cardNumber=objWrapperFunctions.getAttributeValue(customerProfile_Action_IssueCard_oldCardNumber,"value");
		 temp=objWrapperFunctions.getRandomNumber();
		 objUtilities.logReporter("Enter New Card Number", objWrapperFunctions.setText(customerProfile_Action_IssueCard_NewCardNumber,temp), false);
		 viewCustomer();
		 objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(customerProfile_Action_IssueCard_SaveButton), false);
		 	if(objWrapperFunctions.checkElementDisplyed(customerProfile_Action_IssueCard_message))
		 	{
		 		objWrapperFunctions.acceptMultipleAlert(customerProfile_Action_IssueCard_Ok);
		 		temp=objWrapperFunctions.getRandomNumber();
		 		objUtilities.logReporter("Enter New Card Number", objWrapperFunctions.setText(customerProfile_Action_IssueCard_NewCardNumber,temp), false);
				objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(customerProfile_Action_IssueCard_SaveButton), false);
			 } 
		 System.out.println("New Number "+temp);
		 String msg=objWrapperFunctions.getText(text);		
		 objWrapperFunctions.acceptMultipleAlert(customerProfile_Action_IssueCard_Ok);
		 System.out.println(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void issueNewCard_ReplacementCard()
	{
		try 
		{
		 Thread.sleep(5000);		
		 objUtilities.logReporter("Click on Action Button", objWrapperFunctions.click(customerProfile_ActionButton), false);
		 objUtilities.logReporter("Click on issue card", objWrapperFunctions.click(customerProfile_Action_IssueCard), false);	 
		 objUtilities.logReporter("Click on Replacement Card", objWrapperFunctions.click(customerProfile_Action_IssueCard_ReplacementCard), false); 
		
		 cardNumber=objWrapperFunctions.getAttributeValue(customerProfile_Action_IssueCard_oldCardNumber,"value");
		 temp=objWrapperFunctions.getRandomNumber();
		 objUtilities.logReporter("Enter New Card Number", objWrapperFunctions.setText(customerProfile_Action_IssueCard_NewCardNumber,temp), false);
		 viewCustomer();
		 objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(customerProfile_Action_IssueCard_SaveButton), false);
		 	if(objWrapperFunctions.checkElementDisplyed(customerProfile_Action_IssueCard_message))
		 	{
		 		objWrapperFunctions.acceptMultipleAlert(customerProfile_Action_IssueCard_Ok);
		 		temp=objWrapperFunctions.getRandomNumber();
		 		objUtilities.logReporter("Enter New Card Number", objWrapperFunctions.setText(customerProfile_Action_IssueCard_NewCardNumber,temp), false);
				objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(customerProfile_Action_IssueCard_SaveButton), false);
			 } 
		 System.out.println("New Number "+temp);
		 String msg=objWrapperFunctions.getText(text);		
		 objWrapperFunctions.acceptMultipleAlert(customerProfile_Action_IssueCard_Ok);
		 System.out.println(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void viewCustomer()
	{
		System.out.println("****************** Associated User Details ************************");
		System.out.println(" Old Card Number "+cardNumber);
		objWrapperFunctions.displayAllElement(customerProfile_Action_IssueCard_Details);
	}
	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
}
