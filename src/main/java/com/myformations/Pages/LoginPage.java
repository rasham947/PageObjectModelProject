package com.myformations.Pages;

import org.openqa.selenium.By;

import com.myformations.Base.Page;

public class LoginPage extends Page{
	
	public FilingHomePage doLogin(String Email, String password) {
		
		type("Email",Email);
		type("Password",password);
		click("Signin_button");
		return new FilingHomePage();
		
		//driver.findElement(By.xpath("")).sendKeys(username);
		//driver.findElement(By.xpath("")).sendKeys(password);
	}
	


}
