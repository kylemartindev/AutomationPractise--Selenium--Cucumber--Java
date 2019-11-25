package com.autotest.practise.yourlogo.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewOrders {
	
	@FindBy (xpath="//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
	private WebElement orderhistory;

	
	@FindBy (xpath="//*[@id=\"order-list\"]/tbody/tr/td[1]/a")
	private WebElement clickorders;


public void checkorder () {
	
	orderhistory.click();
	clickorders.click();
}

public boolean confirmorder() {
	
	return clickorders.getText().contains("DQHGZAHYJ");
}
}