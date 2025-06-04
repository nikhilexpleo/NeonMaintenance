package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.interimTableCount_PF;
import com.pageFactory.desktopReception.login_PF;

public class interimTableCount extends BaseTest {
	private interimTableCount_PF objinterimTableCount_PF;
	private login_PF objlogin_PF;
	
	
	@Test(priority = 0)
	public void addinterimTableCount()
	{
		initializeWebEnvironment("Neon");
		objinterimTableCount_PF= new interimTableCount_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objinterimTableCount_PF.navigateTointerimTableCountTab();
		objinterimTableCount_PF.addChipsQty();
		objinterimTableCount_PF.addCommentAndSave();	
		objlogin_PF.logout();	
	}
	
	
	// Closing the browser
		@AfterClass
		private void tearDown() 
		{
			tearDownWebEnvironment();
			objinterimTableCount_PF = null;
			objlogin_PF =null;
		}
}
