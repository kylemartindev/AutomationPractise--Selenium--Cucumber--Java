package com.autotest.practise.yourlogo.modules;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Purchase {
	
	
	
	@FindBy (xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[2]/div/div[1]/div/div[1]/a/i")
	private WebElement product1;
	
	@FindBy (xpath="//iframe[contains(@id,'fancybox-frame')]")
	private WebElement iframe;
	
	@FindBy (xpath="/html/body/div/div/div[3]/form/div/div[2]/div/fieldset[1]/div/div/select")
	private WebElement size;
	
	@FindBy (xpath="//*[@id=\"add_to_cart\"]/button")
	private WebElement addtobasket;
	
	@FindBy (xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	private WebElement ContinueShopping;
	
	@FindBy (xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[1]/div/div[1]/a/i")
	private WebElement product2;
	
	@FindBy (xpath="//*[@id=\"add_to_cart\"]/button/span")
	private WebElement addtobasket2;
	
	@FindBy (xpath="//*[@id=\"button_order_cart\"]")
	private WebElement checkbasket;
	
	

	public void chooseproduct1(WebDriver driver)  {
		
		product1.click();
		driver.switchTo().frame(iframe);

		
	}
	public void addtobasket (WebDriver driver)  {
		size.click();
		Select dropdown = new Select(size);  
		dropdown.selectByVisibleText("M");
		addtobasket.click();
		WebDriverWait wait = new WebDriverWait (driver, 40);
		 wait.until(ExpectedConditions.visibilityOf(ContinueShopping));
		 ContinueShopping.click();
		 driver.switchTo().defaultContent();
	}
		 
	public void purchaseproduct2(WebDriver driver)  { 
		
		 product2.click();
		 driver.switchTo().frame(iframe);
		 addtobasket2.click();
		 WebDriverWait wait = new WebDriverWait (driver, 60);
		 wait.until(ExpectedConditions.visibilityOf(ContinueShopping));
//		 ContinueShopping.click();
//		 driver.switchTo().defaultContent();
	}	 
	public void proceedtocart(WebDriver driver) {
		 ContinueShopping.click();
		 driver.switchTo().defaultContent();
	
		 checkbasket.click();
		 
	}
	
	public void logpurchases(WebDriver driver, ExtentReports extent, ExtentTest test) {
		test = extent.createTest("Log In");
		String cart = driver.findElement(By.xpath("")).getText();
		if(cart.equals("2 Products")) {
			test.log(Status.PASS, "Purchases have been added successfully");
			
		}
		else {
			test.log(Status.FAIL, "Purchases have not been successful");
		}
	
	}
}
