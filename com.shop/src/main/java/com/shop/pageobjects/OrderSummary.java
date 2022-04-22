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
public class OrderSummary extends BaseClass {
@FindBy(xpath = "//span[contains(.,'I confirm my order')]")
WebElement iConfirmMyOrderBtn;
public OrderSummary() {
	PageFactory.initElements(getDriver(), this);
}
public OrderConfirmationPage clickOniConfirmMyOrderBtn() {
	Action.click(getDriver(), iConfirmMyOrderBtn);
	return new OrderConfirmationPage();
}
}
