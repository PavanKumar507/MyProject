/**
 * 
 */
package com.shop.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author 91778
 *
 */
public class ExtentManager {
	
		
		public static ExtentSparkReporter sparkReporter;
		public static ExtentReports extent;
		public static ExtentTest test;
		
		public static void setExtent() {
			//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
			sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport/"+"MyReport.html");
			try {
				sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//htmlReporter.config().setDocumentTitle("Automation Test Report");
			//htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
			//htmlReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("HostName", "MyHost");
			extent.setSystemInfo("ProjectName", "MyStoreProject");
			extent.setSystemInfo("Tester", "Pavan");
			extent.setSystemInfo("OS", "Win10");
			extent.setSystemInfo("Browser", "Chrome");
		}
		public static void endReport() {
			extent.flush();
		}
}
