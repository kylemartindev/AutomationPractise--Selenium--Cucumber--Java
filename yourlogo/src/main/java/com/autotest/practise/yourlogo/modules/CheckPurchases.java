package com.autotest.practise.yourlogo.modules;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckPurchases {
	
	@FindBy(xpath="//*[@id=\"product_2_9_0_240381\"]/td[2]/small[2]/a")
	WebElement size1;
	
	@FindBy(xpath="//*[@id=\"product_3_13_0_240381\"]/td[2]/small[2]/a")
	WebElement size2;
	
	@FindBy(xpath="//*[@id=\"product_price_2_9_240381\"]/span")
	WebElement productprice1;
	
	@FindBy(xpath="//*[@id=\"product_price_3_13_240381\"]/span")
	WebElement productprice2;
	
	@FindBy(xpath="//*[@id=\"total_shipping\"]")
	WebElement shipping;
	
	@FindBy(xpath="//*[@id=\"total_price_without_tax\"]")
	WebElement totalprice;
	
	public boolean checksize1() {
		return size1.getText().contains("Size M");
	}
	
	public boolean checksize2() {
		
		return size2.getText().contains("Size S");
	}
	public boolean checkingprice1() {
		
		return productprice1.getText().contains("27.00");
		
	}
	public boolean checkingprice2() {
		return productprice2.getText().contains("29.00");
	
	}
	
	public int totalproducts() {
		String blouse = productprice1.getText();
		String dress = productprice2.getText();
		int dress1 = Integer.parseInt(dress);
		int blouse1 = Integer.parseInt(blouse);
		
		int totalproducts = dress1 + blouse1;
		
		return totalproducts;
	}
	
	public int totalplushipping() {
		String blouse = productprice1.getText();
		String dress = productprice2.getText();
		String shippingfee = shipping.getText();
		String totalint = totalprice.getText();
		
		int dress1 = Integer.parseInt(dress);
		int blouse1 = Integer.parseInt(blouse);
		int ship = Integer.parseInt(shippingfee);
		int total1 = Integer.parseInt(totalint);
		
		int total = dress1 + blouse1 + ship;
		Integer.toString(total);
		
		
		return total;
		
	}
	
	
}
