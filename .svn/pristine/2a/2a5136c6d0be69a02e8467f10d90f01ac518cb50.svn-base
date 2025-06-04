package com.scripts.noen.LEO_Tables;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.LEOTables.TableDevice_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6629_TableDevices extends BaseTest
{
	private TableDevice_PF objTableDevice_PF;
	private login_PF objlogin_PF;
		
	public void setEnviorment()
	{
		objTableDevice_PF = new TableDevice_PF(this);
		objlogin_PF = new login_PF(this);
	}
	
	
	@Test
	public void addRemovePermittedTablestopads()
	{
		initializeWebEnvironment("Neon");	
		setEnviorment();
		objlogin_PF.login();
		objTableDevice_PF.NavigateToTableAccountingTab();
		objTableDevice_PF.navigateToTableDevice();
		objTableDevice_PF.clickOnFind();
		objTableDevice_PF.selectDevice();
		objTableDevice_PF.addTable();
		objTableDevice_PF.removeTable();
		objTableDevice_PF.clickOnSaveBtn();
		objTableDevice_PF.verifyConfirmMessage();
		objTableDevice_PF.clickONOkButton();
		objlogin_PF.logout();	
		//tearDown();
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
		objTableDevice_PF = null;
		objlogin_PF = null;
	}
}
