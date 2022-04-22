package com.shop.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.shop.actiondriver.Action;
import com.shop.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver;
	//Declare thread local driver
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop=new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip=new FileInputStream(".//configuration//config.properties//");
			prop.load(ip);
			System.out.println("driver: "+driver);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	public static WebDriver getDriver() {
		//Get driver from thread local map
		return driver.get();

	}


	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
		//String browserName=prop.getProperty("browser");

		if(browserName.contains("chrome")) {
			//ChromeOptions options=new ChromeOptions();
			//options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		else if (browserName.contains("ie")) {
			WebDriverManager.edgedriver().setup();
			//driver =new EdgeDriver();
			driver.set(new EdgeDriver());
		}

		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
	}


}
