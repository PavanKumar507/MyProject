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
import com.shop.pageobjects.AccountCreationPage;
import com.shop.pageobjects.IndexPage;
import com.shop.pageobjects.LoginPage;

/**
 * @author 91778
 *
 */
public class AccountCreationPageTest extends BaseClass{
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreationpage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider = "email",dataProviderClass = DataProviders.class,groups = "Sanity")
	public void verifycreateAccountPageTest(String email) throws Exception {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		accountcreationpage=loginpage.createNewAccount(email);
		boolean result=accountcreationpage.validateAccountCreatePage();
		Assert.assertTrue(result);
		
		
	}
}
