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
public class ShippingPage extends BaseClass{
@FindBy(xpath = "//input[@id='cgv']")
WebElement checkBoxterms;
@FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[2]")
WebElement proceedtoCheckoutBtn;
public ShippingPage() {
	PageFactory.initElements(getDriver(), this);
}
public void checkTheterms() {
	Action.click(getDriver(), checkBoxterms);
}
public PaymentPage clickonCheckout() {
	Action.click(getDriver(), proceedtoCheckoutBtn);
	return new PaymentPage();
}
}
