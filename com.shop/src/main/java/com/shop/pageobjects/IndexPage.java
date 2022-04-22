package com.shop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.actiondriver.Action;
import com.shop.base.BaseClass;

public class IndexPage extends BaseClass{
	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signInbtn;
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchProductBox;
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchButton;
	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement myStoreLogo;
	
public IndexPage() {
	PageFactory.initElements(getDriver(), this);
}
public LoginPage clickOnSignIn() {
	Action.click(getDriver(), signInbtn);
	return new LoginPage();
}
public boolean validateLogo() {
	return Action.isDisplayed(getDriver(), myStoreLogo);
}
public String getTitle() {
	return Action.getTitle(getDriver());
}
public SearchResultPage searchProduct(String productName) {
	Action.type(searchProductBox, productName);
	Action.click(getDriver(), searchButton);
	return new SearchResultPage();
}
}
