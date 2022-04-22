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
public class PaymentPage extends BaseClass {
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankWireBtn;
	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheckBtn;
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public OrderSummary clickOnPaymentmethod() {
		Action.click(getDriver(), payByBankWireBtn);
		return new OrderSummary();
	}
}
