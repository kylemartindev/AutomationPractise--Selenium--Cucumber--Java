package com.autotest.practise.yourlogo.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LogOut {
	
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a") 
	private WebElement signout;
	
	public void logout() {
		signout.click();
		
	}
	
	public void loglogout(WebDriver driver, ExtentReports extent, ExtentTest test) {
		test = extent.createTest("Log Out");
		 String user = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
			if(user.isEmpty()) {
				test.log(Status.PASS, "Logout has been made successfully");
				
			}
			else {
				test.log(Status.FAIL, "Logout has not been sucessful");
			}
		
	}

}
