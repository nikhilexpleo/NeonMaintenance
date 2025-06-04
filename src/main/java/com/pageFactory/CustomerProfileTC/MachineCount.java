package com.pageFactory.CustomerProfileTC;

import org.openqa.selenium.By;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class MachineCount {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;

	public MachineCount(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
	}

	private By machineCountMenu = By.xpath("//li[@id='Machines_MachineCount_Menu']//a[contains(.,'Machine Count')]");
	private By machineCount_newCount = By.xpath("//a[@id='MachineCount_NewMachineCount_Menu']");
	private By machineCount_lastCount = By.xpath("//a[@id='MachineCount_LastMachineCount_Menu']");

	private By previousMahineCountMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Previous machine counts have not been completed.')]");
	private By machineNumber = By.xpath("//input[@id='textBoxMachineCountMachineNumber']");
	private By machineNotFoundMsg = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Machine not found')]");

	private By pollmeterMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'The end of day meters have not been polled, and must be polled before the machine count can be started.')]");
	private By pollMetersTab = By.xpath("//li[@id='Machines_PollMeters_Menu']//a");

	private By EndOfDayPollMeters = By.xpath("//a[@data-ig-key='PollMeters_EndOfDayPollMeters_Menu']");
	private By PollMetersButton = By.xpath("//button[@id='buttonPollMeters']");
	//private By machineNumber = By.xpath("//*[@id='lst-ib']");

	private By commitBtn = By.xpath("//button[@data-ig-type='Commit']");

	private By updateReading = By.xpath("//ul[@class='dropdown-menu pull-right']//li[2]//a[contains(.,'Update Readings')]");
	private By actionBtn = By.xpath("//div[@class='dropdown']//button[@data-toggle='dropdown']");
	private By okBtn = By.cssSelector("button[data-ig-type='OK']");
	private By table = By.xpath("//table[@class='grid datagrid dataentry table ig-table']//tbody//tr");
	private By reading;
	private By topNavigation_Machines = By.xpath("//li[@id='Machines_Menu']//a");
	private By addMachineBtn = By.xpath("//button[@id='buttonAddMachine']") ;
	private By totalCount = By.xpath("//tfoot//tr//td[3]//column-conditional-summary//span");

	private By quantity = By.xpath("//table//tbody//tr[1]//td[2]//column-input//input[@name='item[0].Quantity']");
	
	public void getCount()
	{
		String cntDetails = objWrapperFunctions.getText(totalCount);
		System.out.println(" Totla count :  " +cntDetails);
	} 
	public void verifyNClickaddMachineBtn()
	{

		objWrapperFunctions.waitForElementPresence(addMachineBtn);
		objWrapperFunctions.waitForElementToBeClickable(addMachineBtn);
		objUtilities.logReporter("Click on addMachineBtn", objWrapperFunctions.clickByScript(addMachineBtn), false);
	}

	public void navigateToPollMetersMenu()
	{
		objWrapperFunctions.waitForElementPresence(pollMetersTab);
		objWrapperFunctions.waitForElementToBeClickable(pollMetersTab);
		objUtilities.logReporter("Click on poll MetersTab ", objWrapperFunctions.clickByScript(pollMetersTab), false);
	}
	public void clickOnEndOfDayPollMeters()
	{
		objWrapperFunctions.waitForElementPresence(EndOfDayPollMeters);
		objWrapperFunctions.waitForElementToBeClickable(EndOfDayPollMeters);
		objUtilities.logReporter("Click on EndOfDayPollMeters ", objWrapperFunctions.clickByScript(EndOfDayPollMeters), false);
	}


	public void clickOnPollMetersButton()
	{
		objWrapperFunctions.waitForElementPresence(PollMetersButton);
		objWrapperFunctions.waitForElementToBeClickable(PollMetersButton);
		objUtilities.logReporter("Click on PollMetersButton ", objWrapperFunctions.clickByScript(PollMetersButton), false);
	}

	public void navigateToMachineCountMenu()
	{
		objWrapperFunctions.waitForElementPresence(machineCountMenu);
		objWrapperFunctions.waitForElementToBeClickable(machineCountMenu);
		objUtilities.logReporter("Click on Machines count ", objWrapperFunctions.clickByScript(machineCountMenu), false);
	}

	public void clickOnMachineNewCountMenu()
	{
		objWrapperFunctions.waitForElementPresence(machineCount_newCount);
		objWrapperFunctions.waitForElementToBeClickable(machineCount_newCount);
		objUtilities.logReporter("Click on Machines new count ", objWrapperFunctions.clickByScript(machineCount_newCount), false);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyPollMeterMessageDisplay();
		verifyPerviousMachineCountMessageDisplay();
	}

	public void clickOnMachineLastCountMenu()
	{
		objWrapperFunctions.waitForElementPresence(machineCount_lastCount);
		objWrapperFunctions.waitForElementToBeClickable(machineCount_lastCount);
		objUtilities.logReporter("Click on Machines Last count ", objWrapperFunctions.clickByScript(machineCount_lastCount), false);
	}

	public void setMachineNumber(String machineNum)
	{
		objWrapperFunctions.waitForElementPresence(machineNumber);
		objUtilities.logReporter(" Enter Machine Number ", objWrapperFunctions.setText(machineNumber, machineNum), false);
		objWrapperFunctions.pressTabBtn(machineNumber);
	}

	public void clickOnCommit()
	{
		objWrapperFunctions.waitForElementPresence(commitBtn);
		objWrapperFunctions.waitForElementToBeClickable(commitBtn);
		objUtilities.logReporter("Click on commit ", objWrapperFunctions.clickByScript(commitBtn), false);
	}

	public void clickOnAction()
	{
		objWrapperFunctions.waitForElementPresence(actionBtn);
		objWrapperFunctions.waitForElementToBeClickable(actionBtn);
		objUtilities.logReporter("Click on Action Btn ", objWrapperFunctions.clickByScript(actionBtn), false);
	}

	public void verifyAndClickUpdateReading()
	{
		objWrapperFunctions.waitForElementPresence(updateReading);
		objWrapperFunctions.waitForElementToBeClickable(updateReading);
		objUtilities.logReporter("Click on update Reading ", objWrapperFunctions.clickByScript(updateReading), false);
	}

	public void verifyPerviousMachineCountMessageDisplay()
	{
		if(objWrapperFunctions.checkElementDisplyed(previousMahineCountMessage))
		{
			objUtilities.logReporter("Click on Ok ", objWrapperFunctions.clickByScript(okBtn), false);
			navigateToMachines();
			//navigateToMachineCountMenu();
			clickOnMachineLastCountMenu();
		}
	}

	public void navigateToMachines()
	{
		objUtilities.logReporter("Click on top nav Machines", objWrapperFunctions.clickByScript(topNavigation_Machines), false);	
	}
	public void verifyPollMeterMessageDisplay()
	{
		if(objWrapperFunctions.checkElementDisplyed(pollmeterMessage))
		{
			clickONOkBtn();
			navigateToMachines();
			navigateToPollMetersMenu();
			clickOnEndOfDayPollMeters();
			clickOnPollMetersButton();
			navigateToMachines();
			navigateToMachineCountMenu();
			clickOnMachineNewCountMenu();
		}
	}


	public void verifymachineNotFoundMsg()
	{
		if(objWrapperFunctions.checkElementDisplyed(machineNotFoundMsg))
		{
			clickONOkBtn();
		}
	}


	public void updateReadingToZero()
	{

		int size1=objWrapperFunctions.getElementSize(table);			
		for(int i=0;i<size1;i++)
		{
			reading=By.xpath("//table[@class='grid datagrid dataentry table ig-table']//tbody//tr["+i+"]//td[3]//input[@name='item["+i+"].Reading']");
			objUtilities.logReporter("set reading as  0 ", objWrapperFunctions.setText(reading,"0"), false);
			break;

		}
	}	

	public void clickONOkBtn()
	{
		objUtilities.logReporter("Click on Ok ", objWrapperFunctions.clickByScript(okBtn), false);
	}
	public void setQuantity()
	{
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objWrapperFunctions.click(quantity);
		objUtilities.logReporter("set quantity ", objWrapperFunctions.setText(quantity,"1"), false);
	}
}
