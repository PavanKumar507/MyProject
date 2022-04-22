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
public class HomePage extends BaseClass{
@FindBy(xpath = "//span[normalize-space()='My wishlists']")
WebElement myWishLIst;
@FindBy(xpath = "//span[normalize-space()='Order history and details']")
WebElement orderHistoryAndDetails;
public HomePage() {
	PageFactory.initElements(getDriver(), this);
}
public boolean validateMyWishList() {
	return Action.isDisplayed(getDriver(), myWishLIst);
}
public boolean validateOrderHistoryAndDetails() {
	return Action.isDisplayed(getDriver(), orderHistoryAndDetails);
}
public String getCurrentUrl() {
	return getDriver().getCurrentUrl();
}
}
