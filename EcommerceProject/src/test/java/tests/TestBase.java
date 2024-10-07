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
		driver= new FirefoxDriver(options);
		options.addArguments("--disable-search-engine-choice-screen");
		options.addPreference("dom.webnotifications.enabled", false);
		options.addPreference("media.autoplay.default", 0);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().window().maximize();
	}


	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
