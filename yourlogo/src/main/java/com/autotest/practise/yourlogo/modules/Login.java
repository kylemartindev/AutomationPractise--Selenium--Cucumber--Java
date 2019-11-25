package com.autotest.practise.yourlogo.modules;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Login 
{
	

	
    @FindBy (xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signin;
	
	@FindBy (id="email")
	private WebElement username;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement login;

	public void loginpage()  {
		
		
	
		signin.click();
		username.sendKeys("kyle.martin@gmail.com");
		
		password.sendKeys("password86!!");

		login.click();
		
		
		
	}
	public void loglogin(WebDriver driver, ExtentReports extent, ExtentTest test) {
		test = extent.createTest("Log In");
		String user = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
		if(user.equals("Kyle Martin")) {
			test.log(Status.PASS, "Login has been made successfully");
			
		}
		else {
			test.log(Status.FAIL, "Login has not been sucessful");
		}
		
	}
	
	
	
	
	
	
	
}
