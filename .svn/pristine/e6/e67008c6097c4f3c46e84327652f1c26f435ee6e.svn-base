package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class tableProgressiveJackpotPayout_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",machineName="",message="";
	static String refId_FE="";
	
	public tableProgressiveJackpotPayout_PF(Pojo pojo)
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
	private By tableProgressiveJackpotPayoutTab=By.xpath("//li//a[contains(.,'Table Progressive Jackpot Payout')]");	
	
	private By numberInput=By.xpath("//input[@id='textBoxCustomerNumber']");
	private By surNameTxt=By.xpath("//fieldset//div//span[@id='labelCustomerSurname'][@class='readonlytext']");
	private By foreNameTxt=By.xpath("//div//fieldset//div//span[@id='labelCustomerForename']");
	private By dobTxt=By.xpath("//div//fieldset//div//span[@id='labelDateOfBirth']");
	
	private By tableDropdown=By.xpath("//div//select[@id='dropDownGamingTable']");
	private By progressiveTxt=By.xpath("//div//fieldset//div//span[@id='labelProgressiveName']");
	
	private By amountTextbox=By.xpath("//div//input[@id='textBoxAmount']");
	private By commentTextBox=By.xpath("//textarea[@id='Comment']");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By okButton = By.xpath("//button[@data-ig-type='OK']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By newBtn=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'New')]");
		
	public void navigateToTableProgressiveJackpotPayoutTab()
	{
		try {
			objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
			objWrapperFunctions.scrollTab(tableProgressiveJackpotPayoutTab);
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
		objUtilities.logReporter("select table", objWrapperFunctions.selectDropDownByIndex(tableDropdown,1), false);
		String subAccount=objWrapperFunctions.getSelectedValueFromDropDown(tableDropdown);
		System.out.println("Table : "+subAccount);
		
		objWrapperFunctions.waitForElementPresence(progressiveTxt);
		String accounttxt=objWrapperFunctions.getText(progressiveTxt);
		System.out.println("Progressive : " +accounttxt);
		objWrapperFunctions.clear(amountTextbox);
		objUtilities.logReporter("Enter Amount Number", objWrapperFunctions.setText(amountTextbox,"5"), false);		
		objUtilities.logReporter("Enter Comment Number", objWrapperFunctions.setText(commentTextBox,"test"), false);
		objUtilities.logReporter("Click on Save", objWrapperFunctions.click(saveButton), false);	
		
		objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(yesBtn), false);
		objUtilities.logReporter("Click on Ok", objWrapperFunctions.click(okBtn), false);
		objUtilities.logReporter("Verify New button present", objWrapperFunctions.verifyIsElementPresent(newBtn),false);
		objUtilities.logReporter("Click on New", objWrapperFunctions.click(newBtn), false);
		/*objWrapperFunctions.waitForElementPresence(closeIconTab);
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);		*/
	}
}

