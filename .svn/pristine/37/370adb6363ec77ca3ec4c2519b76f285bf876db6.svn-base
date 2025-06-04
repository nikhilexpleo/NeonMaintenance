package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.chipsAddRemove_PF;
import com.pageFactory.desktopReception.login_PF;

public class chipsAddRemove extends BaseTest {
	
	private chipsAddRemove_PF objchipsAddRemove_PF;
	private login_PF objlogin_PF;
	
	
	@Test(priority = 0)
	public void AddRemovechips()
	{
		initializeWebEnvironment("Neon");
		objchipsAddRemove_PF= new chipsAddRemove_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		
		objchipsAddRemove_PF.navigateToChipAddedTab();
		objchipsAddRemove_PF.addChipsQty();
		objchipsAddRemove_PF.addCommentAndSave();
		
		
		objchipsAddRemove_PF.navigateToChipsRemovedTab();
		objchipsAddRemove_PF.addChipsQty();
		objchipsAddRemove_PF.addCommentAndSave();
		objlogin_PF.logout();	
		tearDown();
		
	}
	
	
	// Closing the browser
		@AfterClass
		private void tearDown() 
		{
			tearDownWebEnvironment();
		
		}
}
