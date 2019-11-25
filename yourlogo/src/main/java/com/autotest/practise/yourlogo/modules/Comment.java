package com.autotest.practise.yourlogo.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Comment {

	@FindBy (xpath="//*[@id=\"sendOrderMessage\"]/p[3]/textarea")
	private WebElement addcomment;
	
	@FindBy (xpath="//*[@id=\"sendOrderMessage\"]/div/button")
	private WebElement sendcomment;
	
	@FindBy (xpath="//*[@id=\"block-order-detail\"]/div[5]/table/tbody/tr/td[2]")
	private WebElement commentadded;
	
	public void commentbox() {
		
		addcomment.sendKeys("Vey happy with order");
		sendcomment.click();
	}
	
	public boolean comment() {
		
		return commentadded.getText().equals("Very happy with order");
	}
	
}
