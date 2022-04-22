/**
 * 
 */
package com.shop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.BaseClass;

/**
 * @author 91778
 *
 */
public class OrderConfirmationPage extends BaseClass{
	@FindBy(xpath = "//strong[normalize-space()='Your order on My Store is complete.']")
	WebElement confirmMessage;
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public String validateConfirmMessage() {
		String confirmMessgae= confirmMessage.getText();
		return confirmMessgae;
	}

}
