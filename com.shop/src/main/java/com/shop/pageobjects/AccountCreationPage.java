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
public class AccountCreationPage extends BaseClass{
@FindBy(xpath = "//h1[normalize-space()='Create an account']")
WebElement formTitle;
public AccountCreationPage() {
	PageFactory.initElements(getDriver(), this);
}
public boolean validateAccountCreatePage() {
	return Action.isDisplayed(getDriver(), formTitle);
}
}
