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
import com.shop.utility.Log;

/**
 * @author 91778
 *
 */
public class LoginPageTest extends BaseClass{
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@Test(dataProvider = "credentials",dataProviderClass = DataProviders.class,groups = {"Sanity","Smoke"})
	public void loginTest(String username,String password, String validity) {
		Log.startTestCase("loginTest");
		indexpage=new IndexPage();
		Log.info("user is going to click on signin");
		loginpage=indexpage.clickOnSignIn();
		Log.info("Enter username & Password");
		homepage=loginpage.login(username, password);
		String actUrl=homepage.getCurrentUrl();
		String expUrl="http://automationpractice.com/index.php?controller=my-account" ;
		Log.info("verifying if user is able to login");
		Assert.assertEquals(actUrl, expUrl);
		Log.info("login is successful");
		Log.endTestCase("login test");
		
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
