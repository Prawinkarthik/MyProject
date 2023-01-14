package com.stepdefination;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Runner.RunnerClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination {
	public static WebDriver driver = RunnerClass.driver;
	String searchValue;

	@Given("^user Launch the Application Url$")
	public void user_Launch_the_Application_Url() {

		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^user Select The value from DropDown$")
	public void userSelectTheValueFromDropDown() throws IOException, InterruptedException {

	WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
	String excepted = "Baby";
	//String excepted =XSSF_File_Reader.fileReaderSingleData("amazon", 4, 0);
	
	Select s = new Select(dropDown);

	List<WebElement> options = s.getOptions();
	Thread.sleep(1000);
	for (int i = 0; i < options.size(); i++) {
		String actual = options.get(i).getText();

		if (excepted.equalsIgnoreCase(actual)) {
			s.selectByVisibleText(actual);
		} else {
			continue;
			
		}
	}
	
	}

	@When("^user Select The product In Search Field$")
	public void userSelectTheProductInSearchField() throws IOException, InterruptedException {

		WebElement search1= driver.findElement(By.id("twotabsearchtextbox"));
		searchValue="Soft toys";
		//searchValue= XSSF_File_Reader.fileReaderSingleData("amazon", 4, 1);
		search1.sendKeys(searchValue);
		
		Thread.sleep(1000);
	}

	
	@Then("^user Click The Search button$")
	public void user_Click_The_Search_button() throws InterruptedException {
		List<WebElement> searchresult = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div/div"));
		
		Thread.sleep(1000);
		for (int i = 1; i <=searchresult.size(); i++) {
		
			WebElement webSearch = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div["+i+"]/div")); 
				String textweb = webSearch.getText();
				if (searchValue.equalsIgnoreCase(textweb)) {
					
					webSearch.click();
					break;
				}	
		}
	}
}

