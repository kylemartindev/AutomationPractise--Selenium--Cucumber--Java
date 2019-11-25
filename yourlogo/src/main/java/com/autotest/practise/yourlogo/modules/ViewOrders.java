package com.autotest.practise.yourlogo.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewOrders {
	
	@FindBy (xpath="//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
	private WebElement orderhistory;

	
	@FindBy (xpath="//*[@id=\"order-list\"]/tbody/tr/td[1]/a")
	private WebElement clickorder;


public void checkorder () {
	
	orderhistory.click();
	clickorder.click();
}

public boolean confirmorder() {
	
	return clickorder.getText().contains("CBRBSEPPM");
}
}