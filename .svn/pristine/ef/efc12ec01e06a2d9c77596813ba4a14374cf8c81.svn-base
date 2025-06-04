package com.pageFactory.LEOTables;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.generic.ExcelIterator;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class TopNavigation_Credit
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="";
	String NeonUser,NeonPass;
	static int reqIndex=0;
	static int tempRandom,cardLastFourDigits,expiry_month,expiry_year ;
	static String name,lastname,nameArray[];
	static char firstChar;
	static char secondChar;
	static int creditAccNum;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="";
	//static int cardnum;
	
	public TopNavigation_Credit(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
	}
	
	private By userName=By.id("Username");
	private By password=By.id("Password");
	private By signBtn=By.xpath("//button[@class='btn btn-lg btn-primary btn-block ig-signin-button']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']"); 
	
	
	
	
	
	
	public void clickOkOrYes(){
		while(objWrapperFunctions.checkElementDisplyed(voidYesButton)||objWrapperFunctions.checkElementDisplyed(okBtn)){
			//System.out.println("Closing Pop-up :"+count);
		//	objWrapperFunctions.waitForElementPresence(voidYesButton);
			if(objWrapperFunctions.checkElementDisplyed(voidYesButton)){
				objWrapperFunctions.pressEnterBtn(voidYesButton);
			}else if(objWrapperFunctions.checkElementDisplyed(okBtn)){
				objWrapperFunctions.pressEnterBtn(okBtn);
			}
			objWrapperFunctions.waitForElementPresence(okBtn);
		}
			
	}
	
	

	public void login()
	{
		try
		{	
		objUtilities.logReporter("Enter username", objWrapperFunctions.setText(userName, NeonUser), false);
		objUtilities.logReporter("Enter password", objWrapperFunctions.setText(password,NeonPass), false);
		objUtilities.logReporter("Click on signBtn", objWrapperFunctions.click(signBtn), false);
		System.out.println("Logged In Successfully");
		Thread.sleep(20000);
		objWrapperFunctions.waitForElementPresence(okBtn);
		objWrapperFunctions.acceptMultipleAlert(okBtn);
		
		//objWrapperFunctions.pressEnterBtn(okBtn);
		//objWrapperFunctions.pressEnterBtn(okBtn);
		Thread.sleep(2000);
		
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//objExcel.createCustomerExcel(refId_FE, cardnum, date);
	}
	
	
	
	void checkPresenceOfText(By locator){
		List<WebElement> list= objWrapperFunctions.getElements(locator);
		Iterator<WebElement> iterator = list.iterator();
		String arrTemp[]=new String[list.size()];
		int i=0;
		while(iterator.hasNext()){
			arrTemp[i]=objWrapperFunctions.getTextOfElement(list.get(i));
					i++;
					System.out.println(arrTemp[i]);
		}
	
	}
	

	
	
	
}
