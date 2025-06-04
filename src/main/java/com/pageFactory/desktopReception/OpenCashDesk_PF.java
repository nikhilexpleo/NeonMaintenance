package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class OpenCashDesk_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	
	Properties objConfig=new Properties();
	
	public OpenCashDesk_PF (Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		/*NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	*/
	}
	
	private By viewTab=By.cssSelector("div.ig-navbar-menu li#View_Menu");
	private By balanceMenu=By.cssSelector("div.ig-navbar-menu li#View_Menu div.container-accordion-inner ul li a#View_Balance_Menu");
	private By viewBalanceText=By.cssSelector("div.buttonbar div h2");
	private By openDeskButton=By.xpath("//button[@id='buttonOpenDesk']");
	private By yesButton = By.cssSelector("button[data-ig-type='YES']");
	private By textmessage = By.xpath("//div[@class='modal-body ig-modal-scroll']");
	private By okButton = By.cssSelector("button[data-ig-type='OK']");
	
	public void openCashesk()
	{
		objUtilities.logReporter("Click on view tab", objWrapperFunctions.clickByScript(viewTab), false);
		objUtilities.logReporter("Click on Balance Menu", objWrapperFunctions.clickByScript(balanceMenu), false);
		
	//objWrapperFunctions.waitForElementPresence(openDeskButton);
	objWrapperFunctions.waitForElementToBeClickable(openDeskButton);
	objWrapperFunctions.click(openDeskButton);
	objWrapperFunctions.verifyIsElementPresent(yesButton);
	objWrapperFunctions.waitFormobileElementToBeClickable(yesButton);
	objWrapperFunctions.acceptMultipleAlert(yesButton);
	String txt=objWrapperFunctions.getText(textmessage);
	System.out.println("fgf f = " +txt);
	
	
	objWrapperFunctions.acceptMultipleAlert(yesButton);
	}
}
