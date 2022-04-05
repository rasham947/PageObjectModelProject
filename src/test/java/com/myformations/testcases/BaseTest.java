package com.myformations.testcases;


import org.openqa.selenium.By;

import com.myformations.Base.Page;

public class BaseTest extends Page {
	
	
	public static boolean ElementVerification() {
		
		return BaseTest.isElementPresent(By.xpath(OR.getProperty("ClientSearchbox")));
	}
	
	
	

}
