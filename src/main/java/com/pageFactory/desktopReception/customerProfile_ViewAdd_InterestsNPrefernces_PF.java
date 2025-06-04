package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_ViewAdd_InterestsNPrefernces_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",cardNumber="";
	static int tempRandom ;


	public customerProfile_ViewAdd_InterestsNPrefernces_PF(Pojo pojo)
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
	private By customerProfile_Action_InterestsNPreferncesTab=By.xpath("//li//a[@id='buttonInterestsAndPreferences']");	

	private By customerProfile_Action_InterestsNPrefernces_checklist=By.xpath("//div//ol//li//ol//li[1]//label//input");	
	private By customerProfile_Action_InterestsNPrefernces_textArea=By.xpath("//textarea[@id='Customer_PreferencesFormatted']");
	private By customerProfile_Action_InterestsNPrefernces_Ok=By.xpath("//footer//button[contains(.,'OK')]");	
	private By closeIconTab=By.xpath("//div[@class='buttonbar']//div//button[@accesskey='x']");


	public void navigateToCustomerMenu()
	{
		objWrapperFunctions.waitForElementPresence(customersMainTab);
		objUtilities.logReporter("Click on Customers Menu tab", objWrapperFunctions.click(customersMainTab), false);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void navigateToCustomerTab()
	{
		navigateToCustomerMenu();	
		objUtilities.logReporter("Click on Customers tab", objWrapperFunctions.click(customersTab), false);
	}	

	public void findCustomer()
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findInputBox,custNumber), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);		
	}	

	public void clickOnActionButton()
	{
		objWrapperFunctions.waitForElementPresence(customerProfile_ActionButton);
		objWrapperFunctions.waitForElementToBeClickable(customerProfile_ActionButton);
		objUtilities.logReporter("Click on Action Button", objWrapperFunctions.click(customerProfile_ActionButton), false);
	}
	public void addInterestsNPrefernces()
	{
		try 
		{
			Thread.sleep(5000);		
			// objUtilities.logReporter("Click on Action Button", objWrapperFunctions.click(customerProfile_ActionButton), false);
			objUtilities.logReporter("Click on InterestsNPreferncesTab", objWrapperFunctions.click(customerProfile_Action_InterestsNPreferncesTab), false);	 
			for(int i=1;i<=2;i++)
			{
				customerProfile_Action_InterestsNPrefernces_checklist=By.xpath("//div//ol//li//ol//li["+i+"]//label//input");	
				//System.out.println("Interest and Prefernces Option ="+objWrapperFunctions.getAttributeValue(customerProfile_Action_InterestsNPrefernces_checklist,"value"));
				objUtilities.logReporter("Click on Find button", objWrapperFunctions.click( customerProfile_Action_InterestsNPrefernces_checklist), false);	
			}		 
			objWrapperFunctions.acceptMultipleAlert(customerProfile_Action_InterestsNPrefernces_Ok);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewInterestsNPrefernces()
	{
		System.out.println("************Customer Interests and Preferences Details");
		System.out.println(objWrapperFunctions.getAttributeValue(customerProfile_Action_InterestsNPrefernces_textArea, "value"));
	}

	public void closeTab()
	{
		objWrapperFunctions.waitForElementPresence(closeIconTab);
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
}
