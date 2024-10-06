package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

	public static  WebDriver driver ;

	@BeforeSuite
	public void StartDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--disable-search-engine-choice-screen");
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://magento.softwaretestingboard.com");
	}


	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
