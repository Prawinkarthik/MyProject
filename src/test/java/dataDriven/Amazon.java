package dataDriven;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\k\\eclipse-workspace\\Mini_Project\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
//		search.sendKeys("iphone 13");
//		Thread.sleep(2000);
//		List<WebElement> serchresult = driver.findElements(By.xpath("//div[@id='nav-flyout-iss-anchor']/div/div[2]"));
//
//		for (WebElement iphone : serchresult) {
//			System.out.println(iphone.getText());
//		}
//		
//		search.clear();
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		//String excepted = "Baby";
		String excepted = XSSF_File_Reader.fileReaderSingleData("Cars", 4, 0);
		
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

		//System.out.println("There is not option in dropdown : "+excepted);
		Thread.sleep(1000);
		WebElement search1= driver.findElement(By.id("twotabsearchtextbox"));
		//String searchValue="toy";
		String searchValue = XSSF_File_Reader.fileReaderSingleData("Cars", 4, 1);
		search1.sendKeys(searchValue);
		
		Thread.sleep(1000);
		List<WebElement> searchresult = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div/div"));
		
		Thread.sleep(1000);
		for (int i = 1; i <=searchresult.size(); i++) {
		
			WebElement webSearch = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div["+i+"]/div")); 
				String textweb = webSearch.getText();
				if (searchValue.equalsIgnoreCase(textweb)) {
					Thread.sleep(1000);
					webSearch.click();
				}
 			
		}

		
		Thread.sleep(1000);
		List<WebElement> result = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']"));
			
		for (int i = 0; i < result.size(); i++) {
			WebElement count = result.get(i);
			System.out.println(count.getText());
			
			
		}
	}
}
