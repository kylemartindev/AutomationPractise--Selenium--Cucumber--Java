package com.autotest.practise.yourlogo.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;


import com.autotest.practise.yourlogo.Constants;
import com.autotest.practise.yourlogo.modules.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RunTest {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	
	 @Before
		public void before() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Max\\Downloads\\Software\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();



			driver.manage().window().maximize();
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\Max\\eclipse-workspace\\yourlogo\\Reports"+ File.separator + " " + " " + timeStamp +".html");
	       
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	      
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report for Regression Testing");
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			
			
		}
		
	

@Given("I goto website")
public void i_goto_website() {
	driver.get(Constants.webpage);
	
}


@When("I Log in")
public void i_Log_in()  {
	
	Login page = PageFactory.initElements(driver, Login.class); 
	page.loginpage();
	page.loglogin(driver, extent, test);
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	
   
}

@Then("I make some purchases")
public void i_make_some_purchases() {
	
	driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a")).click();
	
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	Purchase products = PageFactory.initElements(driver, Purchase.class); 
	products.chooseproduct1(driver);
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	products.addtobasket(driver);
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	products.purchaseproduct2(driver);
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 products.proceedtocart(driver);
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	products.logpurchases(driver, extent, test);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}

@Then("Check purchases")
public void check_purchases() {
	test = extent.createTest("Checkout Products");
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	CheckPurchases basket = PageFactory.initElements(driver, CheckPurchases.class); 
	
	assertTrue(basket.checksize1());
	assertTrue(basket.checksize2());
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	test.log(Status.PASS, "Sizes are correct");
	assertTrue(basket.checkingprice1());
	assertTrue(basket.checkingprice2());
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	test.log(Status.PASS, "Product prices are correct");
	assertEquals(55,basket.totalplushipping());
	assertEquals(53,basket.totalproducts());
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	test.log(Status.PASS, "Total prices are correct");
}
	



@Then("Checkout products")
public void checkout_products() {
	test = extent.createTest("Checkout Products");
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Checkout checkingout = PageFactory.initElements(driver, Checkout.class); 
	checkingout.processAdd(driver);
	checkingout.agreeterms(driver);
	checkingout.finishorder(driver);
	assertTrue(checkingout.confirmation());
	test.log(Status.PASS, "Order is complete");
}

@Then("I logout")
public void i_logout() {
	
    LogOut signout = PageFactory.initElements(driver, LogOut.class);
    signout.logout();
    signout.loglogout(driver, extent, test);
    
   
}

@Given("I log in")
public void i_log_in()  {
	test = extent.createTest("Log In");
	driver.get(Constants.webpage);
	Login page = PageFactory.initElements(driver, Login.class); 
	page.loginpage();
	page.loglogin(driver, extent, test);
	
}

@When("I look at my orders")
public void i_look_at_my_orders() {
	test = extent.createTest("Order History");
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	ViewOrders orderhistory = PageFactory.initElements(driver, ViewOrders.class); 
	orderhistory.checkorder();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	orderhistory.confirmorder();
	assertTrue(orderhistory.confirmorder());
	
}

@Then("I add a comment to an order")
public void i_add_a_comment_to_an_order() {
	test = extent.createTest("Comment");
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Comment com = PageFactory.initElements(driver, Comment.class); 
	com.commentbox();
	com.comment();
   assertTrue(com.comment());
   test.log(Status.PASS, "Comment is added");
}

@Then("I Logout")
public void i_Logout() {
	
	LogOut signout = PageFactory.initElements(driver, LogOut.class);
	signout.logout();
	signout.loglogout(driver, extent, test);
}

@After
public void after() {
	extent.flush();
	driver.close();
	
}

}
