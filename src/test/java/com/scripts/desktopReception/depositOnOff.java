package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.DepositOnOff_PF;
import com.pageFactory.desktopReception.login_PF;

import ru.yandex.qatools.allure.annotations.Description;


public class depositOnOff extends BaseTest
{
	private login_PF objlogin_PF;
	private DepositOnOff_PF objDepositOff_PF;

	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objDepositOff_PF=new DepositOnOff_PF(this);
		objlogin_PF = new login_PF(this);
	}
	@Description("Deposit01+Deposit02 ")
	@Test(priority = 0)
	public void verifyDepositOn()
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		objDepositOff_PF.depositOn();
		//objDepositOff_PF.depositOff();
		//objlogin_PF.logout();	
	}

	@Test(priority = 1)
	public void verifyDepositOff()
	{
		objDepositOff_PF.depositOff();

	}
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
		objlogin_PF = null;
		objDepositOff_PF = null;
	}
}
