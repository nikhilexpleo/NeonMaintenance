package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class accountTransactions_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",user="",message="";
	String NeonUser,NeonPass;
	static String refId_FE="";

	public accountTransactions_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();

	}

	private By transactionTab=By.xpath("//li//a//span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	private By badBeatJackpotATab=By.xpath("//li//a[contains(.,'Bad Beat Jackpot B')]");
	private By badBeatJackpotARevTab=By.xpath("//li//a[contains(.,'Bad Beat Jackpot B Reversal')]");

	private By badBeatJackpotBTab=By.xpath("//li//a[contains(.,'Bad Beat Jackpot B')]");
	private By badBeatJackpotBRevTab=By.xpath("//li//a[contains(.,'Bad Beat Jackpot B Reversal')]");

	private By badBeatJackpotCTab=By.xpath("//li//a[contains(.,'Bad Beat Jackpot C')]");
	private By badBeatJackpotCRevTab=By.xpath("//li//a[contains(.,'Bad Beat Jackpot C Reversal')]");

	private By amountTextbox=By.xpath("//div//input[@id='textBoxAmount']");
	private By commentTextBox=By.xpath("//textarea[@id='Comment']");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By accountText=By.xpath("//div//span[@class='readonlytext']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By newBtn=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'New')]");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");

	public void  navigateToTranscationATab()
	{
		try {
			Thread.sleep(5000);
			objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objUtilities.logReporter("Click on bad Beat Jackpot A tab", objWrapperFunctions.click(badBeatJackpotATab), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void  navigateTransationAReversalTab()
	{
		try {
			Thread.sleep(5000);
			//objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objUtilities.logReporter("Click on bad Beat Jackpot A Reversal tab", objWrapperFunctions.click(badBeatJackpotARevTab), false);	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void  navigateToTranscationBTab()
	{
		try {
			Thread.sleep(5000);
			objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objUtilities.logReporter("Click on bad Beat Jackpot B tab", objWrapperFunctions.click(badBeatJackpotBTab), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void  navigateTransationBReversalTab()
	{
		try {
			Thread.sleep(5000);
			//objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objUtilities.logReporter("Click on bad Beat Jackpot B Reversal tab", objWrapperFunctions.click(badBeatJackpotBRevTab), false);	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void  navigateToTranscationCTab()
	{
		try {
			Thread.sleep(5000);
			//objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objUtilities.logReporter("Click on bad Beat Jackpot C tab", objWrapperFunctions.click(badBeatJackpotCTab), false);	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void  navigateTransationCReversalTab()
	{
		try {
			Thread.sleep(5000);	
			//objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objUtilities.logReporter("Click on bad Beat Jackpot C Reversal tab", objWrapperFunctions.click(badBeatJackpotCRevTab), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void verifyAccountType(String actType)
	{
		objWrapperFunctions.waitForElementPresence(accountText);
		String accounttxt=objWrapperFunctions.getText(accountText);
		System.out.println("Account : " +accounttxt);		
		if(accounttxt.contentEquals(actType))
		{
			objUtilities.logReporter("Verify Account type dispalyed as " +actType, 
					true, false);
		}
	}

	public void clickOnYes()
	{
		try {
			Thread.sleep(500);
			objUtilities.logReporter("Click on Yes", 
					objWrapperFunctions.click(yesBtn), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickOnOk()
	{
		try 
		{
			Thread.sleep(500);
			objUtilities.logReporter("Click on Ok",
					objWrapperFunctions.clickByScript(okBtn), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickcloseButton()
	{
		try {
			Thread.sleep(8000);
			objUtilities.logReporter("Click on 'x' ",
					objWrapperFunctions.click(closeIconTab), false);		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setAmount(String amt)
	{
		objUtilities.logReporter("Enter Amount Number", 
				objWrapperFunctions.setText(amountTextbox,amt), false);
	}
	public void setComment(String comment)
	{
		objUtilities.logReporter("Enter Comment Number", 
				objWrapperFunctions.setText(commentTextBox,comment), false);
	}

	public void clickOnSave()
	{
		try 
		{
			objUtilities.logReporter("Click on Save", 
					objWrapperFunctions.click(saveButton), false);	
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean getConfirmationMessage(String msg) 
	{
		
		By confirmMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(text(),'"+msg+"')]");
		/*objUtilities.logReporter("verify New Button ", 
				objWrapperFunctions.verifyIsElementPresent(confirmMessage),false);*/
		return objWrapperFunctions.verifyIsElementPresent(confirmMessage);
		
	}

	public void verifyNewButtonDisplayed()
	{
		try {
			Thread.sleep(1000);
			objUtilities.logReporter("verify New Button ", 
					objWrapperFunctions.verifyIsElementPresent(newBtn),false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnNewButton()
	{
		objUtilities.logReporter("Click on New ", 
				objWrapperFunctions.click(newBtn), false);
	}
}
