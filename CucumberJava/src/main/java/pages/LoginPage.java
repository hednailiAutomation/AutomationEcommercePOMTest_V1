package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver ;

	public LoginPage(WebDriver driver) 
	{ 
		this.driver = driver ;
	}
	

	By btn_login = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
	By txt_email = By.xpath("//form[@class='form form-login']/descendant::input[@id='email']");
	By txt_password = By.xpath("//form[@class='form form-login']/descendant::input[@id='pass']");
	By btn_signin = By.xpath("//form[@id='login-form']/descendant::button[@class='action login primary']");
	By btn_myAccount = By.xpath("//div[@class='panel header']//button[@type='button']");
	By option_myAccount = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a");
	By btn_signout = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");

	public void validUserCredentials(String username , String password) 
	{
		driver.findElement(btn_login).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(txt_email)).sendKeys(username);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(txt_password)).sendKeys(password);
	}
	
	public void login () 
	{
		driver.findElement(btn_signin).click();
	}
	
	public void Signout() 
	{
		driver.findElement(btn_myAccount).click();
		driver.findElement(btn_signout).click();
	}
}
