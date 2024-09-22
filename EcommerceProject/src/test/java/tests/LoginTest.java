package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.LoginPage;

public class LoginTest extends TestBase{

	LoginPage lp ;
	String invalidEmail = "123@";
	String invalidPwd = "1234";
	String email = "test.myppaz998435@gmail.com";
	String pwd = "123456Ab.";
	String newpwd  ="123456aB.";


	@Test(priority=1)
	void  InvalidEmailLogin() throws InterruptedException
	{
		lp=new LoginPage(driver);
		lp.login(invalidEmail,pwd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send2")));
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
	}

	@Test(priority=2)
	void  InvalidPasswordLogin() throws InterruptedException
	{
		lp=new LoginPage(driver);
		lp.login(email,invalidPwd);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")).isDisplayed());
	}

	@Test(priority=3)
	void EmptyCredentialsLogin()
	{
		lp= new LoginPage(driver);
		lp.login("","");
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
	}

	@Test(priority=4)
	void ValidCredentialsLogin() throws InterruptedException
	{
		lp = new LoginPage(driver);
		lp.login(email,newpwd);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.className("logged-in")).isDisplayed());
	}
	
	@Test(priority=5)
	void SignOut() throws InterruptedException 
	{
		lp = new LoginPage(driver);
		Thread.sleep(5000);
		lp.Signout();
	}
	
}

