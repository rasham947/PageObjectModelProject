package com.myformations.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myformations.Base.Page;
import com.relevantcodes.extentreports.LogStatus;



public class FilingHomePage extends Page {
	
	

	public String clientSearch(String cardcode) throws InterruptedException {
    super.type("ClientSearchbox", cardcode);
		Thread.sleep(2000);
		return getElementText("ClientName");

	}

	public boolean clientSelection() throws InterruptedException {
		
		

		click("ClientName");
		elementInvisibility("ClientName");
		
		elementInvisibility("PleaseWaitLoader");
		Thread.sleep(1000);
		// return ElementDisplayed("EditElement");
		return isElementPresent(By.xpath(OR.getProperty("EditElement")));
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty("EditElement")))));

	}

	public static String getElementText(String locator) {

		return driver.findElement(By.xpath(OR.getProperty(locator))).getText();
	}

	public boolean filingYearSelection() throws InterruptedException {
		boolean b = false;

		int number = 0;
		int count = 0;

		click1("FilingYeardropdownbutton");
		for (int i = 0; i < 2; i++) {
			action.sendKeys(Keys.UP).build().perform();
		}
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
		click("Searchbutton");
		wait.until(ExpectedConditions
				.textToBePresentInElement(driver.findElement(By.xpath(OR.getProperty("InitialFilingYear"))), "2020"));
		// click("InitialFilingYear");
		String s = driver.findElement(By.xpath(OR.getProperty("No.ofRecordsfound"))).getText();
		String sty[] = s.split(" ");
		try {
			number = Integer.parseInt(sty[2]);
			System.out.println(number);
		} catch (Exception e) {

		}
		if (number > 10) {

			int x = number % 10;
			int y = number / 10;
			if (x == 0) {

				for (int i = 0; i < y; i++) {
					if (i > 0) {
						click("Paginationforwardbutton");
						Thread.sleep(10000);

					}

					List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("RowsCount")));
					System.out.println(rows.size());
					// int j= rows.size();
					for (int j = 1; j <= rows.size(); j++) {

						System.out.println(driver
								.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[7]")).getText());
						if (driver.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[7]")).getText()
								.equalsIgnoreCase("2020")) {

							count = count + 1;
							System.out.println(count);
						}
					}
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					if(count==number) {
						
						Thread.sleep(1000);
						dragandDropElement("HorizontalSlider", "test6");
						
					}

				}

				if (count != 0) {

					System.out.println("Test case passed");
					b = true;
				}

				else {

					System.out.println("Test case failed");
					b = false;
				}

			} else if (x != 0) {

				for (int i = 0; i <= y; i++) {
					if (i > 0) {
						click("Paginationforwardbutton");
						Thread.sleep(5000);

					}

					List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("RowsCount")));
					System.out.println(rows.size());
					// int j= rows.size();
					for (int j = 1; j <= rows.size(); j++) {

						System.out.println(driver
								.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[7]")).getText());
						if (driver.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[7]")).getText()
								.equalsIgnoreCase("2020")) {

							count = count + 1;
							System.out.println(count);
						}
					}
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					if(count==number) {
						Thread.sleep(1000);
						
						 //test3= driver.findElement(By.xpath("//*[@id=\"v-MyCompanyFilings_LAYOUT_536924\"]/div/div[2]/div/div/div/div/div[9]/div/div[3]/table/tbody/tr[i]/td[12]"));
						dragandDropElement("HorizontalSlider", "test6");
						
					}

				}

				if (count != 0) {

					System.out.println("Test case passed");
					b = true;
				}

				else {

					System.out.println("Test case failed");
					b = false;
				}

			}

		}
		return b;

	}

	public boolean filingdataStausSelection() throws InterruptedException {
		//boolean b;

		int number = 0;
		int count = 0;

		//Thread.sleep(5000);
		// action.dragAndDropBy(driver.findElement(By.xpath(OR.getProperty("HorizontalSlider"))),
		// 600, 0).build().perform();;
		//dragandDropElement("HorizontalSlider", "test");
		Thread.sleep(500);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		click1("Filingstatusdropdownbutton");
		for (int i = 0; i < 1; i++) {
			action.sendKeys(Keys.DOWN).build().perform();
		}
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
		click("Searchbutton");
		wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElement(By.xpath(OR.getProperty("InitialFilingStatus"))), "Not Started"));
		//click("InitialFilingStatus");
		Thread.sleep(2000);
		// click("InitialFilingYear");
		String s = driver.findElement(By.xpath(OR.getProperty("No.ofRecordsfound"))).getText();
		String sty[] = s.split(" ");
		try {
			number = Integer.parseInt(sty[2]);
			System.out.println(number);
		} catch (Exception e) {

		}
		if (number > 10) {

			int x = number % 10;
			int y = number / 10;
			if (x == 0) {

				for (int i = 0; i < y; i++) {
					if (i > 0) {
						click("Paginationforwardbutton");
						Thread.sleep(1000);

					}

					List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("RowsCount")));
					System.out.println(rows.size());
					// int j= rows.size();
					for (int j = 1; j <= rows.size(); j++) {

						System.out.println(driver
								.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[12]")).getText());
						if (driver.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[12]")).getText()
								.equalsIgnoreCase("Not Started")) {

							count = count + 1;
							System.out.println(count);
							
						}
					}
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					if(count==number) {
						
						dragandDropElement("HorizontalSlider", "test6");
					}

				}

//						if (count> 0) {
//
//							System.out.println("Test case passed");
//							b = true;
//						}
//
//						else {
//
//							System.out.println("Test case failed");
//							b = false;
//						}

			} else if (x != 0) {

				for (int i = 0; i <= y; i++) {
					if (i > 0) {
						click("Paginationforwardbutton");
						Thread.sleep(1000);

					}

					List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("RowsCount")));
					System.out.println(rows.size());
					// int j= rows.size();
					for (int j = 1; j <= rows.size(); j++) {

						System.out.println(driver
								.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[12]")).getText());
						if (driver.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[12]")).getText()
								.equalsIgnoreCase("Not Started")) {

							count = count + 1;
							System.out.println(count);
						}
					}
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					if(count==number) {
						dragandDropElement("HorizontalSlider", "test6");
						
					}

				}

//						if (count != 0) {
//
//							System.out.println("Test case passed");
//							b = true;
//						}
//
//						else {
//
//							System.out.println("Test case failed");
//							b = false;
//						}

			}

		}
		String message = (count > 0) ? "Test case passed" : "Test case falied";
		System.out.println(message);

		return (count > 0);

	}

	public boolean paymentStatusSelection() throws InterruptedException {
		
		
		//Thread.sleep(500);
		//js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		//dragandDropElement("HorizontalSlider", "test5");
		int number = 0;
		int count = 0;

		//Thread.sleep(5000);
		// action.dragAndDropBy(driver.findElement(By.xpath(OR.getProperty("HorizontalSlider"))),
		// 600, 0).build().perform();;
		//dragandDropElement("HorizontalSlider", "test");
		Thread.sleep(500);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		click1("Filingstatusdropdownbutton");
		for (int i = 0; i < 1; i++) {
			action.sendKeys(Keys.DOWN).build().perform();
		}
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
		click("Searchbutton");
		wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElement(By.xpath(OR.getProperty("InitialFilingStatus"))), "Not Started"));
		//click("InitialFilingStatus");
		Thread.sleep(2000);
		// click("InitialFilingYear");
		String s = driver.findElement(By.xpath(OR.getProperty("No.ofRecordsfound"))).getText();
		String sty[] = s.split(" ");
		try {
			number = Integer.parseInt(sty[0]);
			System.out.println(number);
		} catch (Exception e) {

		}
		if (number > 10) {

			int x = number % 10;
			int y = number / 10;
			if (x == 0) {

				for (int i = 0; i < y; i++) {
					if (i > 0) {
						click("Paginationforwardbutton");
						Thread.sleep(1000);

					}

					List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("RowsCount")));
					System.out.println(rows.size());
					// int j= rows.size();
					for (int j = 1; j <= rows.size(); j++) {

						System.out.println(driver
								.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[12]")).getText());
						if (driver.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[12]")).getText()
								.equalsIgnoreCase("Not Started")) {

							count = count + 1;
							System.out.println(count);
							
						}
					}
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					if(count==number) {
						
						dragandDropElement("HorizontalSlider", "test6");
					}

				}

//						if (count> 0) {
//
//							System.out.println("Test case passed");
//							b = true;
//						}
//
//						else {
//
//							System.out.println("Test case failed");
//							b = false;
//						}

			} else if (x != 0) {

				for (int i = 0; i <= y; i++) {
					if (i > 0) {
						click("Paginationforwardbutton");
						Thread.sleep(1000);

					}

					List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("RowsCount")));
					System.out.println(rows.size());
					// int j= rows.size();
					for (int j = 1; j <= rows.size(); j++) {

						System.out.println(driver
								.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[12]")).getText());
						if (driver.findElement(By.xpath("//table[@role = 'grid']/tbody/tr[" + j + "]/td[12]")).getText()
								.equalsIgnoreCase("Not Started")) {

							count = count + 1;
							System.out.println(count);
						}
					}
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					if(count==number) {
						dragandDropElement("HorizontalSlider", "test6");
						
					}

				}

//						if (count != 0) {
//
//							System.out.println("Test case passed");
//							b = true;
//						}
//
//						else {
//
//							System.out.println("Test case failed");
//							b = false;
//						}

			}

		}
		String message = (count > 0) ? "Test case passed" : "Test case falied";
		System.out.println(message);

		return (count > 0);


	}

}
