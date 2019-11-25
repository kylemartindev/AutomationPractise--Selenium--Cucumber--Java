package com.autotest.practise.yourlogo.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {

	@FindBy (name="processAddress")
	private WebElement processaddress;
	
	@FindBy (xpath="//*[@id=\"form\"]/div/div[2]/p")
	private WebElement shippingtitle;
	
	@FindBy (id="cvg")
	private WebElement termsofservice;
	
	@FindBy (name="processCarrier")
	private WebElement delivery;
	
	@FindBy (linkText="Pay by bank wire")
	private WebElement payment;
	
	@FindBy (linkText="I can confirm my order")
	private WebElement confirmation;
	
	@FindBy (xpath="//*[@id=\"center_column\"]/h1")
	private WebElement confirmationtitle;
	

public void processAdd(WebDriver driver) {
	processaddress.click();
	
}

public void agreeterms(WebDriver driver) {
	termsofservice.click();
	delivery.click();
}

public void finishorder(WebDriver driver) {
	payment.click();
	confirmation.click();
	
}

public boolean confirmation () {
	
	return confirmation.getText().equals(confirmationtitle);
}
}