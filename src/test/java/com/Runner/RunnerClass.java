
package com.Runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\com\\feature\\amazon.feature",
					glue="com.stepdefination",
			 monochrome = true,
			   snippets = SnippetType.CAMELCASE, 
			 	 dryRun = !true,
			 	 strict = true,
			 	 
			 	 plugin  = { "pretty",
			 			 "html:Report/htmlReport.html",
			 			 "json:Report/JsonReport.json",
			 			 "junit:Report/junit.xml",
			 			 "com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"}  	
		)
public class RunnerClass {
	public static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\k\\eclipse-workspace\\Mini_Project\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterClass
	public static void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
 