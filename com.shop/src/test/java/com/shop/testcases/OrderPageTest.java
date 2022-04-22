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
public class OrderPageTest extends BaseClass{
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
	@Test(dataProvider = "getProduct",dataProviderClass = DataProviders.class,groups = "Regression")
	public void verifyTotalPrice(String pName,String qty,String size) throws Throwable {
		indexpage =new IndexPage();
		searchresultpage =indexpage.searchProduct(pName);
		addToCartPage=searchresultpage.clickOnProduct();
		//String quantity = "2";
		//addToCartPage.clickOnAddtoCart();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddtoCart();
		orderpage=addToCartPage.clickonProceedtoCheckoutBtn();
		//driver.navigate().refresh();
		Double unitprice=orderpage.getUnitPrice();
		Double totalprice=orderpage.getTotalPrice();
		Double totalExpectedPrice=(unitprice*Double.parseDouble(qty))+2;
		Assert.assertEquals(totalExpectedPrice, totalprice);


		//		String unitprice2 = new DecimalFormat("0.00").format(Integer.parseInt(quantity)*unitprice);
		//		Assert.assertEquals(Double.parseDouble(unitprice2), totalprice-2);



	}

}
