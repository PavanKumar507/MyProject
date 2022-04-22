package com.shop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.actiondriver.Action;
import com.shop.base.BaseClass;

public class AddToCartPage extends BaseClass{
@FindBy(xpath = "//input[@id='quantity_wanted']")
WebElement quantity;
@FindBy(xpath = "//select[@id='group_1']")
WebElement size;
@FindBy(xpath = "//span[normalize-space()='Add to cart']")
WebElement addToCartBtn;
@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
WebElement addtoCartMsg;
@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
WebElement proceedtoCheckOutBtn;
public AddToCartPage() {
	PageFactory.initElements(getDriver(), this);
}
public void enterQuantity(String size) {
	Action.type(quantity, size);
}
public void selectSize(String size) {
Action.selectByVisibleText(size, this.size);
}
public void clickOnAddtoCart() {
	
	Action.click(getDriver(), addToCartBtn);
}
public boolean validateAddtoCart() throws InterruptedException {
	Action.explicitWait(getDriver(), addtoCartMsg, 20);
	return Action.isDisplayed(getDriver(), addtoCartMsg);
}
public OrderPage clickonProceedtoCheckoutBtn() throws Throwable {
	Action.fluentWait(getDriver(), proceedtoCheckOutBtn, 20);
	Action.JSClick(getDriver(), proceedtoCheckOutBtn);
	return new OrderPage();
}
}