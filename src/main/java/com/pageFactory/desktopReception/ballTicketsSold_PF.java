package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class ballTicketsSold_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",machineName="",message="";
	static String refId_FE="";
	
	public ballTicketsSold_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();	
		custNumber=pojo.getUser();
		machineName=pojo.getMachine();		
	}
	
	//private By transactionTab=By.xpath("//li//a//span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	
	private By transactionTab=By.xpath("//a[@href='#Sidebar_PassTransactions_Sidebar']//span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	
	
	private By headingText=By.xpath("//div[@class='buttonbar']//div//h2");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");	
	private By ballyTicketsSoldTab=By.xpath("//li//a[contains(.,'Bally Tickets Sold')]");	
	private By ballyTicketsSoldReversalTab=By.xpath("//li//a[contains(.,'Bally Tickets Sold Reversal')]");		
	private By numberInput=By.xpath("//input[@id='textBoxCustomerNumber']");
	private By surNameTxt=By.xpath("//fieldset//div//span[@id='labelCustomerSurname'][@class='readonlytext']");
	private By foreNameTxt=By.xpath("//div//fieldset//div//span[@id='labelCustomerForename']");
	private By dobTxt=By.xpath("//div//fieldset//div//span[@id='labelDateOfBirth']");			
	private By amountTextbox=By.xpath("//div//input[@id='textBoxAmount']");
	private By commentTextBox=By.xpath("//textarea[@id='Comment']");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By accountText=By.xpath("//div//fieldset[2]//div//span[@class='readonlytext']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By newBtn=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'New')]");
	private By okButton = By.xpath("//button[@data-ig-type='OK']");
	
	
	public void clickOnTransaction()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
	}
	public void navigateToBallyTicketsSoldTab()
	{
		try {
		//	objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objUtilities.logReporter("Click on Bally Tickets Sold Tab", objWrapperFunctions.click(ballyTicketsSoldTab), false);
			String text=objWrapperFunctions.getText(headingText);
			System.out.println(text);				
			objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(numberInput,custNumber), false);
			objWrapperFunctions.pressTabBtn(numberInput);
			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{
				objUtilities.logReporter("Click on Ok", objWrapperFunctions.click(okButton), false);
			}		
			Thread.sleep(5000);			
			System.out.println("******Customer Deatils*******");
			System.out.println("Customer Number "+custNumber);
			String name=objWrapperFunctions.getText(surNameTxt);
			System.out.println("SurName "+name);
			String foreName=objWrapperFunctions.getText(foreNameTxt);
			System.out.println("foreName "+foreName);
			String dob=objWrapperFunctions.getText(dobTxt);
			System.out.println("Date of Birth "+dob);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addAmountDetailsAndSave()
	{
		objWrapperFunctions.waitForElementPresence(accountText);
		String accounttxt=objWrapperFunctions.getText(accountText);
		System.out.println("Account : " +accounttxt);
		objWrapperFunctions.clear(amountTextbox);
		objUtilities.logReporter("Enter Amount Number", objWrapperFunctions.setText(amountTextbox,"10"), false);		
		objUtilities.logReporter("Enter Comment Number", objWrapperFunctions.setText(commentTextBox,"test"), false);
		objUtilities.logReporter("Click on Save", objWrapperFunctions.click(saveButton), false);	
		objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(yesBtn), false);
		objUtilities.logReporter("Click on Ok", objWrapperFunctions.click(okBtn), false);
		objUtilities.logReporter("Verify New button present", objWrapperFunctions.verifyIsElementPresent(newBtn),false);
		objUtilities.logReporter("Click on New", objWrapperFunctions.click(newBtn), false);
		objWrapperFunctions.waitForElementPresence(closeIconTab);
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);		
	}
	
	
	public void navigateToBallyTicketsSoldReversalTab()
	{
		try {	
			objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objUtilities.logReporter("Click on Bally Tickets Sold Tab", objWrapperFunctions.click(ballyTicketsSoldReversalTab), false);
			String text=objWrapperFunctions.getText(headingText);
			System.out.println(text);				
			objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(numberInput,custNumber), false);
			objWrapperFunctions.pressTabBtn(numberInput);
			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{
				objUtilities.logReporter("Click on Ok", objWrapperFunctions.click(okButton), false);
			}	
			Thread.sleep(5000);			
			System.out.println("******Customer Deatils*******");
			System.out.println("Customer Number "+custNumber);
			String name=objWrapperFunctions.getText(surNameTxt);
			System.out.println("SurName "+name);
			String foreName=objWrapperFunctions.getText(foreNameTxt);
			System.out.println("foreName "+foreName);
			String dob=objWrapperFunctions.getText(dobTxt);
			System.out.println("Date of Birth "+dob);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
