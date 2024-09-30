package Hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	public static WebDriver driver;
	
	
	@Before()
	public void setUp(Scenario scenario) 
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		System.out.println("I'm in  Before scenario");
	}
	
	
	@After()
	public void tearDown(Scenario scenario) {

		System.out.println("I'm in After scenario");
		driver.quit();

	}
		
	
	

	@BeforeStep()
	public void actionBeforeEachStep() 
	{
		System.out.println("I'm in before step");
	}
	
	
	@AfterStep()
	public void actionAfterEachStep() 
	{
		System.out.println("I'm in after step");
	}
}
