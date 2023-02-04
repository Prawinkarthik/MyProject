package com.BlingAutomation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotPasswordFunctionality {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://dash.bling-center.com/platform/signIn.html");

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebElement forgotPassword = driver.findElement(By.xpath("//div[@class='left-container']/div[5]/button/p"));
		forgotPassword.click();		

		WebElement emailReset = driver.findElement(By.id("email1"));
		emailReset.sendKeys("praveenrajrp28@gmail.com");

		WebElement resetBtn = driver.findElement(By.xpath("//button/p[text()='Reset Password']"));
		resetBtn.click();

		Thread.sleep(3000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\k\\eclipse-workspace\\Bling\\ScreenShot\\report.png");
		FileUtils.copyFile(src, dest);
	}
}
