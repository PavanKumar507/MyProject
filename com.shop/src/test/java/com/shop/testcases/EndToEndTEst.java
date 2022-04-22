/**
 * 
 */
package com.shop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.shop.base.BaseClass;
import com.shop.pageobjects.AddToCartPage;
import com.shop.pageobjects.AddressPage;
import com.shop.pageobjects.IndexPage;
import com.shop.pageobjects.LoginPage;
import com.shop.pageobjects.OrderConfirmationPage;
import com.shop.pageobjects.OrderPage;
import com.shop.pageobjects.OrderSummary;
import com.shop.pageobjects.PaymentPage;
import com.shop.pageobjects.SearchResultPage;
import com.shop.pageobjects.ShippingPage;
import com.shop.utility.Log;

/**
 * @author 91778
 *
 */
public class EndToEndTEst extends BaseClass{
	IndexPage indexpage;
	LoginPage loginpage;
	SearchResultPage searchresultpage;
	AddToCartPage addToCartPage;
	OrderPage orderpage;
	OrderSummary ordersummary;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		System.out.println("browser not launched");
		launchApp(browser);
		System.out.println(getDriver());
		System.out.println("browser not launched");
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable {
		Log.startTestCase("endToEndTest");
		indexpage =new IndexPage();
		Log.info("Searching the product");
		searchresultpage =indexpage.searchProduct("t shirt");
		Log.info("Selecting the product");
		addToCartPage=searchresultpage.clickOnProduct();
		//addToCartPage.clickOnAddtoCart();
		Log.info("Entering the quantity");
		addToCartPage.enterQuantity("2");
		Log.info("Entering the Size");
		addToCartPage.selectSize("S");
		Log.info("adding the product to cart");
		addToCartPage.clickOnAddtoCart();
		
		orderpage=addToCartPage.clickonProceedtoCheckoutBtn();
		Log.info("checking out");
		loginpage=orderpage.clickonCheckout();
		Log.info("Entering username and password");
		addresspage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage=addresspage.clickonCheckout();
		Log.info("checking the terms");
		shippingpage.checkTheterms();
		paymentpage=shippingpage.clickonCheckout();
		Log.info("Clicking the payment method");
		ordersummary=paymentpage.clickOnPaymentmethod();
		Log.info("Confirming the order");
		orderconfirmationpage=ordersummary.clickOniConfirmMyOrderBtn();
		
		String expResult=orderconfirmationpage.validateConfirmMessage();
		String actResult="Your order on My Store is complete.";
		Log.info("Validating the order");
		Assert.assertEquals(expResult, actResult);
		Log.endTestCase("test is successful");
		
	
	}
}
