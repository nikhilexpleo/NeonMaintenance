package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_Delete_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",cardNumber="";
	static int tempRandom ;

	
	public customerProfile_Delete_PF(Pojo pojo)
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
	private By customerProfile_Action_DeleteTab=By.xpath("//li//a[@id='buttonDelete']");	
	private By text=By.xpath("//div[@class='modal-content']//div[@class='modal-body ig-modal-scroll']");
	private By yesBtn=By.xpath("//button[contains(.,'Yes')]");
	private By noBtn=By.xpath("//button[contains(.,'No')]");
	private By detailsButton=By.xpath("//button[contains(.,'Details')]");
	private By okButton=By.xpath("//footer//button[contains(.,'OK')]");		
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By customerProfileTab=By.xpath("//section[@class='sidebar']");
	
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
	
	public void deleteCustomerProfiles()
	{
		try 
		{
		 Thread.sleep(5000);		
		 objUtilities.logReporter("Click on Action Button", objWrapperFunctions.click(customerProfile_ActionButton), false);
		 objUtilities.logReporter("Click on Delete Tab", objWrapperFunctions.click(customerProfile_Action_DeleteTab), false);	 	  
		
		 if(objWrapperFunctions.checkElementDisplyed(okButton))
			 {
			 System.out.println("Message Displayed : "+objWrapperFunctions.getText(text));
			 objWrapperFunctions.acceptMultipleAlert(okButton);
			 }
		 else
		 	{
			 System.out.println("Message Displayed : "+objWrapperFunctions.getText(text));
			 //objUtilities.logReporter("Click on No button", objWrapperFunctions.click(noBtn), false);
			 //objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(yesBtn), false);
			 objWrapperFunctions.acceptMultipleAlert(yesBtn);
			 System.out.println("Message Displayed : "+objWrapperFunctions.getText(text));
			objWrapperFunctions.acceptMultipleAlert(okButton);
		 	}
		 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findDeletedAccount()
	{
		try 
		{
		 Thread.sleep(5000);	
		navigateToCustomerTab();
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findInputBox,custNumber), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);	
	
		if((objWrapperFunctions.checkElementDisplyed(customerProfileTab)))
		{
		System.out.println("Record not Deleted");
		}
		else
		{
			System.out.println("Record deleted successfully");
		}
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
