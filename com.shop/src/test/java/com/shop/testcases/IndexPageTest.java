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
import com.shop.pageobjects.IndexPage;

/**
 * @author 91778
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexpage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@Test(groups = "Smoke")
	public void verifyLogo() {
		indexpage =new IndexPage();
		boolean result=indexpage.validateLogo();
		System.out.println(getDriver());
		Assert.assertTrue(result);
	
	}
	@Test(groups = "Smoke")
	public void verifyTitle() {
		String title=indexpage.getTitle();
		Assert.assertEquals(title, "My Store");
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
}
