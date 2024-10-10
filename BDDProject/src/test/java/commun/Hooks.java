package commun;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BasePage{

	@Before
	public static void setUpDriver() 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-ads");
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
	}
	
	
	@After
	public static void quitDriver() 
	{
		driver.quit();
	}
}
