package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_ViewGamingDetails_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",refId_FE="";
	static int tempRandom,expiry_days,expiry_month,expiry_year ;

	
	public customerProfile_ViewGamingDetails_PF(Pojo pojo)
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
	private By customerProfile_GamingTab=By.xpath("//section[@class='sidebar']//li[@id='tabGaming']//a[contains(.,'Gaming')]");	
	private By customerProfile_Gaming_CollapsedButton=By.xpath("//button[@class='collapsor active']");
	private By customerProfile_Gaming_dateInputBox=By.xpath("//input[@id='StartGamingDate']");	
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");	
	private By tableHeader=By.xpath("//table[@class='grid datagrid']//thead//tr//th");	
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By tablecolumn;
	private By tableFooter;

	
	
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
	public void clickGamingTab()
	{
		objWrapperFunctions.scrollTab(customerProfile_GamingTab);	
	}

	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
		
	public void viewReords()
	{
		System.out.println("************Customer Gaming Details **************");
		
		//System.out.println("Customer Number : "+custNumber);
		int tablesize=objWrapperFunctions.getElementSize(table);
		int columnSize=objWrapperFunctions.getElementSize(tableHeader);
		//System.out.println(columnSize);
		for(int i=1;i<=tablesize;i++)
		{
			for(int j=1;j<=columnSize;j++)
			{
				tableHeader=By.xpath("//table[@class='grid datagrid']//thead//tr[1]//th["+j+"]");			
				tablecolumn=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td["+j+"]");
				tableFooter=By.xpath("//table[@class='grid datagrid']//tfoot//tr//td["+j+"]");
				System.out.println(objWrapperFunctions.getText(tableHeader)+ "= " +objWrapperFunctions.getText(tablecolumn) );
				
			}
		}
	//	System.out.println(objWrapperFunctions.getText(tableHeader)+ "= " +objWrapperFunctions.getText(tableFooter) );
	}
	
	public void setFilter()
	{
		objUtilities.logReporter("Click on Collpased button ", objWrapperFunctions.click(customerProfile_Gaming_CollapsedButton), false);
		String date=objUtilities.getCurrentDate("ddMMyyyy");
		String convertedDate=objUtilities.modifyDaysFromDate(date, -3,"ddMMyyyy");
		//System.out.println(convertedDate);
		objUtilities.logReporter("Click on Start date ", objWrapperFunctions.click(customerProfile_Gaming_dateInputBox), false);
		objUtilities.logReporter("set start date", objWrapperFunctions.setText(customerProfile_Gaming_dateInputBox,convertedDate), false);
		objUtilities.logReporter("Click on find button ", objWrapperFunctions.click(findButton), false);
	}
}
