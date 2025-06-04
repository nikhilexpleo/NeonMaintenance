package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.ExcelIterator;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class login_PF
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;

	WebDriver webdriver;
	Properties objConfig=new Properties();
	String user="",message="";
	String NeonUser,NeonPass;
	static String refId_FE="";
	private Pojo objPojo;
	
	public login_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		this.objPojo = pojo ;
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
		System.out.println(NeonPass);	
	}
	
	private By userName=By.name("Username");
	private By password=By.name("Password");
	private By signBtn=By.xpath("//button[@class='btn btn-lg btn-primary btn-block ig-signin-button']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	//private By usernmLink=By.xpath("//span[@class='readonlytext ig-header-text'][contains(.,'rankqa')]");
	
	private By usernmLink=By.xpath("//span[@class='readonlytext ig-header-text']");
	
	private By logout=By.xpath("//a[@id='linkUserLogOut' and contains(.,'Log Out')]");
	
	public void login()
	{
		try 
		{
		objUtilities.logReporter("Enter username", objWrapperFunctions.setText(userName, NeonUser), false);
		objUtilities.logReporter("Enter password", objWrapperFunctions.setText(password,NeonPass), false);
		objUtilities.logReporter("Click on signBtn", objWrapperFunctions.click(signBtn), false);
		Thread.sleep(15000);
		objWrapperFunctions.acceptMultipleAlert(okBtn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void logout()
	{
		objWrapperFunctions.waitForElementPresence(usernmLink);
		objWrapperFunctions.waitForElementToBeClickable(usernmLink);
		objUtilities.logReporter("Click on username link", objWrapperFunctions.click(usernmLink), false);
		objWrapperFunctions.verifyIsElementPresent(logout);
		objWrapperFunctions.waitForElementToBeClickable(logout);
		objUtilities.logReporter("Click on logout", objWrapperFunctions.click(logout), false);
	
	}
	
	public void setNeonUserName(String userNM)
	{
		objUtilities.logReporter("Enter username", objWrapperFunctions.setText(userName,userNM), false);
	}
	public void setNeonPassword(String Password)
	{
		objUtilities.logReporter("Enter password", objWrapperFunctions.setText(password,Password), false);
	}
	public void clickSignInButton()
	{
		objUtilities.logReporter("Click on signBtn", objWrapperFunctions.click(signBtn), false);
	}
	
	public void clickOnOkButton()
	{
		objPojo.getWaitMethods().sleep(15);
		objWrapperFunctions.acceptMultipleAlert(okBtn);
		objPojo.getWaitMethods().sleep(5);
	}
}
