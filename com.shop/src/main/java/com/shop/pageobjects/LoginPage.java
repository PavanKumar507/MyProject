package com.shop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.actiondriver.Action;
import com.shop.base.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(xpath = "//input[@id='email']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement passWord;
	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	WebElement signInbtn;
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailforNewAcnt;
	@FindBy(xpath = "//span[normalize-space()='Create an account']")
	WebElement createAnAcntBtn;
	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	public HomePage login(String uName, String pWord) {
		Action.type(userName, uName);
		Action.type(passWord, pWord);
		Action.click(getDriver(), signInbtn);
		return new HomePage();
	}
	public AddressPage login1(String uName, String pWord) {
		Action.type(userName, uName);
		Action.type(passWord, pWord);
		Action.click(getDriver(), signInbtn);
		return new AddressPage();
	}
	public AccountCreationPage createNewAccount(String newEmail) throws Exception {
		Action.type(emailforNewAcnt, newEmail);
		Action.implicitWait(getDriver(), 10);
		Action.JSClick(getDriver(), createAnAcntBtn);
		return new AccountCreationPage();
	}
}
