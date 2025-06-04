package com.pageFactory.CustomerProfileTC;

import java.util.Properties;

import org.openqa.selenium.By;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class CustProfile_EditSuspensionAnotherCasino_PF 
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	static String message="",gamingClubNm,groupwidebarredCust;
	static int reqIndex=0;


	public CustProfile_EditSuspensionAnotherCasino_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		groupwidebarredCust = pojo.getObjConfig().getProperty("web.GroupwideBarredCust");
	}

	private By gamingClub = By.xpath("//ul[@class='list-inline']//script//following-sibling::li");
	private By customer_finder_casinoDropdown = By.xpath("//select[@name='RegisteredAtCasino.Id']");
	private By customer_finder_suspendedCheckbox = By.xpath("//input[@id='Suspended']");
	private By customer_Result_suspended =By.cssSelector("td[data-grid-column-key='StatusShortDescription']");
	private By customer_Find_clickDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By customerProfile_Suspensions_edit_message=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Suspensions at another casino cannot be edited.')]");
	private By customerProfile_Suspensions_Lift_message=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Suspensions at another casino cannot be lifted.')]");
	//private By customerProfile_GlobalSuspensions_edit_message=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Global suspensions cannot be edited from a casino.')]");
	
	private By customerProfile_GlobalSuspensions_edit_message=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'No permission to manage global suspensions from a casino.')]");
	
	private By customerProfile_GLobalSuspensions_Lift_message=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'No permission to manage global suspensions from a casino.')]");
	private By okButton=By.xpath("//button[@data-ig-type='OK']");
	private By findInputBox=By.xpath("//input[@id='Number']");


	public void getGamingClub()
	{
		objUtilities.logReporter("verify EstimatedVisitEntry_gamingDate label", objWrapperFunctions.verifyIsElementPresent(gamingClub), false);
		gamingClubNm = objWrapperFunctions.getText(gamingClub);
		System.out.println("date : = " +gamingClubNm);
	}

	public void selectCasino()
	{
		if(gamingClubNm.equals("_SAW 1"))
		{
			objUtilities.logReporter("select casino", objWrapperFunctions.selectDropDownOption(customer_finder_casinoDropdown, "_BALLY"), false);
		}
		else if(gamingClubNm.equals("_BALLY"))
		{
			objUtilities.logReporter("select casino", objWrapperFunctions.selectDropDownOption(customer_finder_casinoDropdown, "_SAW 1"), false);
		}
		else
		{
			objUtilities.logReporter("select casino", objWrapperFunctions.selectDropDownOption(customer_finder_casinoDropdown, "_SAW 1"), false);
		}
	}

	public void selectSuspendedCheckBox()
	{
		objWrapperFunctions.verifyIsElementPresent(customer_finder_suspendedCheckbox);
		objUtilities.logReporter("check suspended Checkbox ", objWrapperFunctions.click(customer_finder_suspendedCheckbox), false);
	}

	public void clickOnDetails()
	{

		selectCustProfile(customer_Result_suspended,customer_Find_clickDetails,"Suspended");
		/*objWrapperFunctions.verifyIsElementPresent(customer_Find_clickDetails);
		objUtilities.logReporter("click on details button ", objWrapperFunctions.click(customer_Find_clickDetails), false);*/
	}
	public void findCustomer()
	{
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);		
	}	

	
	public void enterCustomerDetails()
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findInputBox,groupwidebarredCust), false);
	}	
	public void selectCustProfile(By locator,By locator1,String statusType)
	{
		objWrapperFunctions.waitForElementPresence(locator);
		String arrDevices[]=objWrapperFunctions.getElementTextArray(locator);
		int index=0;
		for (String temp : arrDevices) 
		{
			System.out.println("Status : " +temp);

			if(temp.equalsIgnoreCase(statusType))
			{
				reqIndex=index;
				objUtilities.logReporter("verify details ",objWrapperFunctions.checkElementDisplyed(locator1), false);		
				objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(locator1,reqIndex)), false);
				break;
			}
			index++;
		}
	}

	public void groupwide()
	{
		System.out.println("xcv cg = " +groupwidebarredCust);
	}
	public void verifyMessage()
	{
		objUtilities.logReporter("verify message display ",objWrapperFunctions.verifyIsElementPresent(customerProfile_Suspensions_edit_message), false);
	}

	public void verifyLiftMessage()
	{
		objUtilities.logReporter("verify message display ",objWrapperFunctions.verifyIsElementPresent(customerProfile_Suspensions_Lift_message), false);
	}

	public void verifyEditGlobalSuspensionMessage()
	{
		objUtilities.logReporter("verify Global Suspension message display ",objWrapperFunctions.verifyIsElementPresent(customerProfile_GlobalSuspensions_edit_message), false);
	}

	public void verifyLiftGlobalSuspensionMessage()
	{
		objUtilities.logReporter("verify  Global Suspension message display ",objWrapperFunctions.verifyIsElementPresent(customerProfile_GLobalSuspensions_Lift_message), false);
	}

	public void clickONOkButton()
	{
		objWrapperFunctions.waitForElementToBeClickable(okButton);
		objUtilities.logReporter("Click on Ok button", objWrapperFunctions.click(okButton), false);
	}
}
