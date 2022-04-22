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
import com.shop.pageobjects.HomePage;
import com.shop.pageobjects.IndexPage;
import com.shop.pageobjects.LoginPage;

/**
 * @author 91778
 *
 */
public class HomePageTest extends BaseClass{
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider = "credentials",dataProviderClass = DataProviders.class,groups = "Smoke")
	public void verifyWishList(String username,String password,String validity) {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage=loginpage.login(username,password);
		boolean result=homepage.validateMyWishList();
		if(validity=="valid")
			Assert.assertTrue(result);
		else if(validity=="invalid"){
			Assert.assertTrue(result);
		}
	}
	@Test(dataProvider = "credentials",dataProviderClass = DataProviders.class,groups = "Smoke")
	public void orderHistoryandDetailsTest(String username,String password,String validity) {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage=loginpage.login(username,password);
		boolean result=homepage.validateOrderHistoryAndDetails();
		if(validity=="valid")
			Assert.assertTrue(result);
		else if(validity=="invalid")
		{
			Assert.assertTrue(result);
		}
	}

}