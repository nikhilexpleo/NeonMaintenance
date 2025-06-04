package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_ViewSummaryDetails_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",refId_FE="";
	static int tempRandom,expiry_days,expiry_month,expiry_year ;
	
	public customerProfile_ViewSummaryDetails_PF(Pojo pojo)
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
	
	private By customerProfile_Summary_customerDeatils=By.xpath("//div[@class='quarter-col-threequarter-col']//div//fieldset//div");;
	private By customerProfile_SummaryTab=By.xpath("//section[@class='sidebar']//li[@id='tabSummary']//a[contains(.,'Summary')]");
	
	
	private By table=By.xpath("//div//div//grid//div[@class='ng-scope']//table[@class='grid datagrid']//tbody//tr");	
	private By tableHeader=By.xpath("//div[@class='ng-scope']//table[@class='grid datagrid']//thead//tr//th");
	
	private By tablecolumn;
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
	public void clickSummaryTab()
	{
		objWrapperFunctions.scrollTab(customerProfile_SummaryTab);	
	}

	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
		
	public void viewReords()
	{
		System.out.println("************ Customer Details **************");
		objWrapperFunctions.displayAllElement(customerProfile_Summary_customerDeatils);
		System.out.println("************Customer Summary Details **************");
		int tablesize=objWrapperFunctions.getElementSize(table);
		//System.out.println(tablesize);
		int columnSize=objWrapperFunctions.getElementSize(tableHeader);
		//System.out.println(columnSize);
		for(int i=1;i<tablesize;i++)
		{
			for(int j=1;j<=11;j++)
			{
				tableHeader=By.xpath("//div[@class='ng-scope']//table[@class='grid datagrid']//thead//tr[@class='grid-header']//th["+j+"]");			
				tablecolumn=By.xpath("//div[@class='ng-scope']//table[@class='grid datagrid']//tbody//tr["+i+"]//td["+j+"]");			
				System.out.println(objWrapperFunctions.getText(tableHeader)+ "= " +objWrapperFunctions.getText(tablecolumn) );
			}
			
		}
	}
}
