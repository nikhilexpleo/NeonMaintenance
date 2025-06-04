package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class winnersBankTransferReversal_Transcation_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",machineName="",message="";
	static String referenceNum="";
	
	public winnersBankTransferReversal_Transcation_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();	
		custNumber=pojo.getUser();
		machineName=pojo.getMachine();		
	}
	
	private By transactionTab=By.xpath("//li//a//span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	private By headingText=By.xpath("//div[@class='buttonbar']//div//h2");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");	
	private By winnersBankTransferTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Winners Bank Transfer')]");	
	private By winnersBankTransferReversalTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Winners Bank Transfer Reversal')]");	
	
	private By numberInput=By.xpath("//input[@id='textBoxCustomerNumber']");
	
	private By 	referenceNumberInput=By.xpath("//input[@id='textBoxReferenceNumber']");
	
	//private By custNumberTxt=By.xpath("//fieldset//div//span[@id='labelCustomerNumber'][@class='readonlytext']");
	private By custNumberTxt=By.xpath("//fieldset//div//span[@id='customerNumberSpan']");
	private By surNameTxt=By.xpath("//fieldset//div//span[@id='customerName'][@class='text text-customer-name']");
	private By foreNameTxt=By.xpath("//div//fieldset//div//span[@id='labelCustomerForename']");
	private By dobTxt=By.xpath("//div//fieldset//div//span[@id='customerDOBSpan']");			
	private By amountTextbox=By.xpath("//div//input[@id='Amount']");
	private By commentTextBox=By.xpath("//textarea[@id='Comment']");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By referenceText=By.xpath("//label[contains(.,'Reference Number')]//following-sibling::span");
	private By inputBankName=By.xpath("//input[@name='BankName' and @id='textBoxBankName']");
	private By inputSwiftCode=By.xpath("//input[@name='SwiftCode' and @id='textBoxSwiftCode']");
	private By okButton=By.xpath("//button[@data-ig-type='OK']");	

	private By amtText=By.xpath("//div//span[@id='labelAmount']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By newBtn=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'New')]");
	private By messageTxt=By.xpath("//div[@class='modal-body ig-modal-scroll']");	
	
	public void winnersBankTransferReversalTranscation()
	{
		try {
			objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objWrapperFunctions.scrollTab(winnersBankTransferReversalTab);
			String text=objWrapperFunctions.getText(headingText);
			System.out.println(text);				
			objUtilities.logReporter("Enter Reference Number", objWrapperFunctions.setText(referenceNumberInput,referenceNum), false);
			objWrapperFunctions.pressTabBtn(referenceNumberInput);
			Thread.sleep(500);	
			
			
			System.out.println("******Customer Deatils*******");
			String amtText1=objWrapperFunctions.getText(amtText);
			System.out.println("Customer Number "+amtText1);
			String custNumber1=objWrapperFunctions.getText(custNumberTxt);
			System.out.println("Customer Number "+custNumber1);
			String name=objWrapperFunctions.getText(surNameTxt);
			System.out.println("SurName "+name);
//			String foreName=objWrapperFunctions.getText(foreNameTxt);
//			System.out.println("foreName "+foreName);
			String dob=objWrapperFunctions.getText(dobTxt);
			System.out.println("Date of Birth "+dob);
			
			/*objUtilities.logReporter("Enter Comment Number", objWrapperFunctions.setText(commentTextBox,"test"), false);
			objUtilities.logReporter("Click on Save", objWrapperFunctions.click(saveButton), false);	
			message=objWrapperFunctions.getText(messageTxt);
			System.out.println("Confirmation Message :"+message +" displayed");
			objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(yesBtn), false);
			message=objWrapperFunctions.getText(messageTxt);
			System.out.println(message);
			objUtilities.logReporter("Click on Ok", objWrapperFunctions.click(okBtn), false);
			objUtilities.logReporter("Verify New button present", objWrapperFunctions.verifyIsElementPresent(newBtn),false);
			objUtilities.logReporter("Click on New", objWrapperFunctions.click(newBtn), false);
			objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);	*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void navigateTowinnersBankTransferTab()
	{
		try {
			objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objWrapperFunctions.scrollTab(winnersBankTransferTab);
			//objUtilities.logReporter("Click on Direct Credit To Account Tab", objWrapperFunctions.click(directCreditToAccountTab), false);
			String text=objWrapperFunctions.getText(headingText);
			System.out.println(text);				
			objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(numberInput,custNumber), false);
			objWrapperFunctions.pressTabBtn(numberInput);
			
			Thread.sleep(1000);		
		
			
//			if(objWrapperFunctions.checkElementDisplyed(okButton))
//			{
//				objUtilities.logReporter("Click on ok btn", objWrapperFunctions.click(okButton), false);	
//			}
			System.out.println("******Customer Deatils*******");
			System.out.println("Customer Number "+custNumber);
			String name=objWrapperFunctions.getText(surNameTxt);
			System.out.println("Full name"+name);
//			String foreName=objWrapperFunctions.getText(foreNameTxt);
//			System.out.println("foreName "+foreName);
			String dob=objWrapperFunctions.getText(dobTxt);
			System.out.println("Date of Birth "+dob);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setBankNameAndsetSwiftCode()
	{
		
		objUtilities.logReporter("Enter Bank Name", objWrapperFunctions.setText(inputBankName,"sdjhjshfjksd"), false);
		objUtilities.logReporter("Enter Swift Code", objWrapperFunctions.setText(inputSwiftCode,"sdnscdnew"), false);
	}
	public void addAmountDetailsAndSave()
	{
	
		objWrapperFunctions.clear(amountTextbox);
		objUtilities.logReporter("Enter Amount Number", objWrapperFunctions.setText(amountTextbox,"10"), false);		
		objUtilities.logReporter("Enter Comment Number", objWrapperFunctions.setText(commentTextBox,"test"), false);
		objUtilities.logReporter("Click on Save", objWrapperFunctions.click(saveButton), false);	
		message=objWrapperFunctions.getText(messageTxt);
		System.out.println("Confirmation Message :"+message +" displayed");
		objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(yesBtn), false);
		message=objWrapperFunctions.getText(messageTxt);
		System.out.println(message);
		objUtilities.logReporter("Click on Ok", objWrapperFunctions.click(okBtn), false);
		
		
	
		objUtilities.logReporter("Verify New button present", objWrapperFunctions.verifyIsElementPresent(newBtn),false);
		objUtilities.logReporter("Click on New", objWrapperFunctions.click(newBtn), false);
		objWrapperFunctions.waitForElementPresence(closeIconTab);
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);		
	}
	
	public void setAmount(String amt) throws InterruptedException
	{ 
		Thread.sleep(500);
		objUtilities.logReporter("Enter Amount Number", 
				objWrapperFunctions.setText(amountTextbox,amt), false);
	}
	
	public void getReferenceNumber()
	{
		objWrapperFunctions.waitForElementPresence(referenceText);
		referenceNum=objWrapperFunctions.getText(referenceText);
		System.out.println("Reference Number : " +referenceNum);
	}
	
}
