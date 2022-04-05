package com.myformations.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.myformations.Pages.FilingHomePage;

public class FilingHomePageTest extends BaseTest {
	FilingHomePage hp = new FilingHomePage();
	
	@Test(priority=1)
	public void clientSearchTest() throws InterruptedException {
		
		
		
		
		
		String actualname = hp.clientSearch("X001136");
		
		String expectedname ="X001136_GENPRO CONSULTING, INC.";
		
		Assert.assertEquals(actualname, expectedname, "ClientName not found");
		
		
		
		
		
	}

	@Test(priority=2)
	public void  ClientSelectionTest() throws InterruptedException {
		
		
		Assert.assertTrue(hp.clientSelection(), "Cient not selected successfully");
		
	}
	@Test(priority=3)
	public void filingyearFilterSelectionTest() throws InterruptedException {
		//hp.filingYearSelection();
		Assert.assertTrue(hp.filingYearSelection(), "FilterdnotWorking");
		
		
		
	}
	@Test(priority=4)
	public void filingdataStatusSelectionTest() throws InterruptedException {
		
		//hp.filingdataStausSelection();
		Assert.assertTrue(hp.filingdataStausSelection(), "FilterdnotWorking");
	
		
		
	}
	@Test(priority=5)
	public void paymentStatusSelectionTest() throws InterruptedException {
		
		hp.paymentStatusSelection();
	}
	
	
	
}
