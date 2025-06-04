package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerHistoricalAndEstimatedVisitEntry_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	//WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",user="",message="",temp="";
	String NeonUser,NeonPass;
	static String refId_FE="";
	
	public customerHistoricalAndEstimatedVisitEntry_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();
		
	}
	
	private By customerTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By historicalVisitEntryTab=By.xpath("//a[@id='CustomerManagement_HistoricalVisitEntry_Menu']");
	private By estimatedVisitEntryTab=By.xpath("//a[@id='CustomerManagement_EstimatedVisits_Menu']");
	private By historicalVisitEntry_customerNumber=By.xpath("//input[@id='textBoxCustomerNumber']");
	
	private By historicalVisitEntry_surNameTxt=By.xpath("//fieldset//div//span[@id='labelCustomerSurname'][@class='readonlytext']");
	private By historicalVisitEntry_foreNameTxt=By.xpath("//div//fieldset//div//span[@id='labelCustomerForename']");
	private By historicalVisitEntry_dobTxt=By.xpath("//div//fieldset//div//span[@id='labelCustomerDateOfBirth']");
	private By historicalVisitEntry_DateTime_inputBox=By.xpath("//div[@class='input-group']//input[@name='ActualDateTime']");
	private By historicalVisitEntry_gamingDateTxt=By.xpath("//div//fieldset//div//span[@id='labelGamingDate']");
	private By historicalVisitEntry_saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	

	private By estimatedVisitEntry_GamingDate_inputBox=By.xpath("//div[@class='input-group']//input[@id='dateTimeGamingDate']");
	private By okButton=By.xpath("//footer//button[contains(.,'OK')]");
	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll']");
	private By okBtn=By.xpath("//button[contains(.,'OK')]");	
	private By yesBtn=By.xpath("//button[contains(.,'Yes')]");
	private By noBtn=By.xpath("//button[contains(.,'No')]");
	private By estimatedVisitEntry_tableRow=By.xpath("//table[@class='grid datagrid']//tbody//tr");
	
	private By estimatedVisitEntry_tableColumn=By.xpath("//table[@class='grid datagrid']//tbody//tr//td");
	private By rowValue;
	
	public void navigateTohistoricalVisitEntryTab()
	{		
		objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerTab), false);
		objUtilities.logReporter("Click on Historical Visit Entry tab", objWrapperFunctions.click(historicalVisitEntryTab), false);
	}	
	
	public void addCustomerVisitEntryDetails()
	{
		objUtilities.logReporter("Enter CustomerNumber", objWrapperFunctions.setText(historicalVisitEntry_customerNumber,custNumber), false);
		objWrapperFunctions.pressTabBtn(historicalVisitEntry_customerNumber);
		System.out.println("****************Customer Details**********************");
		message=objWrapperFunctions.getText(historicalVisitEntry_surNameTxt);
		System.out.println("Customer SurName :" +message);
		message=objWrapperFunctions.getText(historicalVisitEntry_foreNameTxt);
		System.out.println("Customer ForeName :" +message);
		message=objWrapperFunctions.getText(historicalVisitEntry_dobTxt);
		System.out.println("Date of Birth :" +message);
		//String date=objUtilities.getCurrentDate();
		//System.out.println(date);
		//objWrapperFunctions.clear(historicalVisitEntry_DateTime_inputBox);
		//objUtilities.logReporter("Enter Date time", objWrapperFunctions.setText(historicalVisitEntry_DateTime_inputBox,date), false);
		String date=objWrapperFunctions.getAttributeValue(historicalVisitEntry_DateTime_inputBox, "value");
		System.out.println(date);
		String gamingDate=objWrapperFunctions.getText(historicalVisitEntry_gamingDateTxt);
		//System.out.println("Gaming Date :" +gamingDate);
		String convertedDate=objUtilities.modifyDaysFromDate(date,-1,"dd/MM/yyyy");
		//System.out.println(convertedDate);
		if(convertedDate.equals(gamingDate)==true)
		{
			System.out.println("Gaming Date :" +gamingDate);
		}
		objUtilities.logReporter("Click on Save button", objWrapperFunctions.click(historicalVisitEntry_saveButton), false);
		objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(yesBtn), false);
		message=objWrapperFunctions.getText(text);
		System.out.println("Confirmation Message :" +message);
		objUtilities.logReporter("Click on Ok button", objWrapperFunctions.click(okButton), false);			
	}
	
	
	
	public void navigateToestimatedVisitEntryTab()
	{		
		objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerTab), false);
		objUtilities.logReporter("Click on Estimated Visit Entry tab", objWrapperFunctions.click(estimatedVisitEntryTab), false);
	}	
	
	public void details()
	{
		String date=objUtilities.getCurrentDate("dd/MM/yyyy");
		System.out.println(date);
		String convertedDate=objUtilities.modifyDaysFromDate(date,-1,"dd/MM/yyyy");
		System.out.println(convertedDate);
		
	//	objUtilities.logReporter("Enter Gaming Date", objWrapperFunctions.setText(estimatedVisitEntry_GamingDate_inputBox,convertedDate), false);
		

		
		
		int rowCount=objWrapperFunctions.getElementSize(estimatedVisitEntry_tableRow);
		
		
		
		
		for(int i=1;i<=rowCount;i++)
			{
			
			for(int j=1;j<=3;j++)
			{
				rowValue=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td["+j+"]");
			    
			 temp=objWrapperFunctions.getText(rowValue);
			System.out.println(temp);
		//	matchBtn=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9]//button[@class='btn-primary btn-secured'][contains(.,'Match')]");
			}
			} 	
		
	}
}
