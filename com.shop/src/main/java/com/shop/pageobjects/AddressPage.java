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
public class AddressPage extends BaseClass {
	@FindBy(xpath = "//span[starts-with(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckoutBtn;
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public ShippingPage clickonCheckout() {
		Action.click(getDriver(), proceedtoCheckoutBtn);
		return new ShippingPage();
	}
}
