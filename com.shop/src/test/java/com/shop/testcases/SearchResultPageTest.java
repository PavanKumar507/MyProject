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
import com.shop.pageobjects.IndexPage;
import com.shop.pageobjects.SearchResultPage;

/**
 * @author 91778
 *
 */
public class SearchResultPageTest extends BaseClass{
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider = "searchProduct",dataProviderClass = DataProviders.class,groups = "Smoke")
	public void productAvailabilityTest(String productname) {
		indexpage=new IndexPage();
		searchresultpage=indexpage.searchProduct(productname);
		boolean result=searchresultpage.isProductAvailable();

		Assert.assertTrue(result);
	}
}
