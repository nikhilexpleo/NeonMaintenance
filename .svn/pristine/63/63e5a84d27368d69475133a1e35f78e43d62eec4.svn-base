package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;
import com.typesafe.config.ConfigException.Parse;

public class customerProfile_AddAssociates_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",refId_FE="";
	static int tempRandom,expiry_days,expiry_month,expiry_year ;

	
	public customerProfile_AddAssociates_PF(Pojo pojo)
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
	private By headingTxt=By.xpath("//h2[@id='layoutCaption']");
	
	private By customer_Deatils;
	private By customerProfile_AssociatesTab=By.xpath("//section[@class='sidebar']//li[@id='tabAssociates']//a[contains(.,'Associates')]");
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");	
	private By customerProfile_Associates_AddButton=By.xpath("//button[@id='buttonAddMessage'][contains(.,'Add')]");	
	private By customerProfile_Associates_CustomeType=By.xpath("//div[@class='three-col']//fieldset//div//select[@id='LinkType']");
	private By customerProfile_Associates_CustomerNumberInput=By.xpath("//div[@id='combineAssociateCustomerNumber']//input[@id='textBoxAssociateCustomerNumber']");	
	private By customerProfile_Associates_AssociateType=By.xpath("//select[@id='dropDownAssociateType']");	
	private By customerProfile_Associates_Comment=By.xpath("//textarea[@id='Comment']");
	
	private By customerProfile_Associates_SaveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By okButton=By.xpath("//footer//button[contains(.,'OK')]");
	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll']");
	
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
		
		
	public void clickAssociatesTab()
	{
		try
		{
		Thread.sleep(4000);			
	//	refId_FE=objWrapperFunctions.getText(headingTxt);
		objWrapperFunctions.scrollTab(customerProfile_AssociatesTab);
		//objUtilities.logReporter("Click on customer Profile_AssociatesTab", objWrapperFunctions.click(customerProfile_AssociatesTab), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add_AssociatesToCustAccount()
	{	
		tempRandom=Integer.parseInt((custNumber)) - 1;
		//System.out.println(tempRandom);	
		objUtilities.logReporter("Click on Add tab", objWrapperFunctions.click(customerProfile_Associates_AddButton), false);
		objUtilities.logReporter("Select Customer Type ", objWrapperFunctions.selectDropDownByIndex(customerProfile_Associates_CustomeType,0), false);			
		objUtilities.logReporter("Set Customer Number ", objWrapperFunctions.setText(customerProfile_Associates_CustomerNumberInput,String.valueOf(tempRandom)), false);
		objWrapperFunctions.pressTabBtn(customerProfile_Associates_CustomerNumberInput);
		objUtilities.logReporter("Select Associate Type", objWrapperFunctions.selectDropDownByIndex(customerProfile_Associates_AssociateType,1), false);
		objUtilities.logReporter("Enter Comment", objWrapperFunctions.setText(customerProfile_Associates_Comment,"test"), false);
		objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(customerProfile_Associates_SaveButton), false);
		String msg=objWrapperFunctions.getText(text);		
		objWrapperFunctions.acceptMultipleAlert(okButton);
		System.out.println("Associates details "+msg);
		objUtilities.logReporter("Click on customer Profile_AssociatesTab", objWrapperFunctions.doubleClick(customerProfile_AssociatesTab), false);	
	}
	
	public void viewAssociatedUserDetails()
	{
		System.out.println("****************** Associated User Details ************************");
		int size=objWrapperFunctions.getElementSize(table);
			for(int i=1;i<=size;i++)
			{
				customer_Deatils=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td");
				objWrapperFunctions.displayAllElement(customer_Deatils);
		
			}
	}
	
	
	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
}
