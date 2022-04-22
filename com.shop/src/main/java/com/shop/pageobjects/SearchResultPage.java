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
public class SearchResultPage extends BaseClass{
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public boolean isProductAvailable() {
		return Action.isDisplayed(getDriver(), productResult);
	}
	public AddToCartPage clickOnProduct() {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}

}
