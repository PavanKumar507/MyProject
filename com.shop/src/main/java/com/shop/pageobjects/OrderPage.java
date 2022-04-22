/**
 * 
 */
package com.shop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.actiondriver.Action;
import com.shop.base.BaseClass;

/**
 * @author 91778
 *
 */
public class OrderPage extends BaseClass{
	@FindBy(xpath = "(//span[@class='price'])[2]")
	WebElement unitPrice;
	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalPrice;
	@FindBy(xpath = "//span[starts-with(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckoutBtn;
	public OrderPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	public double getUnitPrice() {
		String unitPrice=this.unitPrice.getText();
		System.out.println(unitPrice);
		String unit=unitPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice=Double.parseDouble(unit);
		System.out.println(finalUnitPrice);
		return finalUnitPrice/100;
	}
	public double getTotalPrice() {
		String totPrice=this.totalPrice.getText();
		System.out.println(totPrice);
		String tot=totPrice.replaceAll("[^a-zA-Z0-9]", "");
		double totalPrice=Double.parseDouble(tot);
		System.out.println(totalPrice);
		return totalPrice/100;
		
	}
	public LoginPage clickonCheckout() {
		Action.click(getDriver(), proceedtoCheckoutBtn);
		return new LoginPage();
	}
}
