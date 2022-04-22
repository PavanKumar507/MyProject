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
import com.shop.dataprovider.DataProviders;
import com.shop.pageobjects.AddToCartPage;
import com.shop.pageobjects.IndexPage;
import com.shop.pageobjects.OrderPage;
import com.shop.pageobjects.SearchResultPage;

/**
 * @author 91778
 *
 */
public class AddToCartPageTest extends BaseClass{
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addToCartPage;
	OrderPage orderpage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider = "getProduct",dataProviderClass = DataProviders.class,groups = {"Regression","Sanity"})
	public void addToCartTest(String productname,String quantity,String size) throws Throwable {
	
		indexpage =new IndexPage();
		searchresultpage =indexpage.searchProduct(productname);
		addToCartPage=searchresultpage.clickOnProduct();
		addToCartPage.enterQuantity(quantity);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddtoCart();
		
		boolean result=addToCartPage.validateAddtoCart();
		
		Assert.assertTrue(result);
		
		

	}
}
