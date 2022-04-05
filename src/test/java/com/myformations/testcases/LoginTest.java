package com.myformations.testcases;

import java.util.Hashtable;

//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//import org.testng.asserts.SoftAssert;

//import com.myformations.Pages.FilingHomePage;
import com.myformations.Pages.LoginPage;
import com.myformations.utilities.Utilities;
//import com.myformations.utilities;

public class LoginTest extends BaseTest{
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data) {

		LoginPage lp = new LoginPage();
		 lp.doLogin(data.get("Email"), data.get("password"));
		Assert.assertTrue(BaseTest.ElementVerification(), "login not successful");

	}
	
	
}


