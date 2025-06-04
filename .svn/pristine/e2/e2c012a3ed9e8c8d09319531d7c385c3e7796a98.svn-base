package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class gratuitiesIncomeAccountTranscation_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",machineName="",message="";
	static String refId_FE="";
	
	public gratuitiesIncomeAccountTranscation_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();	
		custNumber=pojo.getUser();
		machineName=pojo.getMachine();	
	}
	
	private By transactionTab=By.xpath("//li//a//span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	private By headingText=By.xpath("//div[@class='buttonbar']//div//h2");	
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	
	//private By gratuitiesNonTroncTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Gratuities - Non Tronc')]");	
	private By gratuitiesNonTroncTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[text()='Gratuities - Tronc']");
	private By gratuitiesTroncTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Gratuities - Tronc')]");	
	private By gratuitiesTroncReversalTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Gratuities - Tronc Reversal')]");
	
	private By amountTextbox=By.xpath("//div//input[@id='textBoxAmount']");
	private By commentTextBox=By.xpath("//textarea[@id='Comment']");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By accountText=By.xpath("//div//span[@class='readonlytext']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By newBtn=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'New')]");
	
	
	public void navigateTogratuitiesNonTroncTab()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
		objWrapperFunctions.scrollTab(gratuitiesNonTroncTab);
		String text=objWrapperFunctions.getText(headingText);
		System.out.println(text);	
	}
	
	public void navigateTogratuitiesTroncTab()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
		objWrapperFunctions.scrollTab(gratuitiesTroncTab);
		String text=objWrapperFunctions.getText(headingText);
		System.out.println(text);	
	}
	public void navigateTogratuitiesTroncReversalTab()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
		objWrapperFunctions.scrollTab(gratuitiesTroncReversalTab);
		String text=objWrapperFunctions.getText(headingText);
		System.out.println(text);	
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
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);		
	}
}
