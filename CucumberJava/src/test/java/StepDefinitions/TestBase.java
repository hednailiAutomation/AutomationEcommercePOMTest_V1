package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public  WebDriver driver ;

	
	public void initializeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}

	
	public void tearDown() 
	{
		if (driver!=null) {
		//driver.quit();
		}
	}

	
}
