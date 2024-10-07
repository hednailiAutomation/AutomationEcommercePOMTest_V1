package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

	public static  WebDriver driver ;

	@BeforeSuite
	public void StartDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-search-engine-choice-screen");
		driver= new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://magento.softwaretestingboard.com");
	}


	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
