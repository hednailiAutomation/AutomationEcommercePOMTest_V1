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
	String email = "test.myppaz998125@gmail.com";
	String pwd = "123456Ab.";


	@Test(priority=1)
	void  InvalidEmailLogin() throws InterruptedException
	{
		lp=new LoginPage(driver);
		lp.login();
		lp.InvalidEmail(invalidEmail);
		lp.InvalidPassword(invalidPwd);
		lp.Login();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send2")));
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
	}

	@Test(priority=2)
	void  InvalidPasswordLogin() throws InterruptedException
	{
		lp=new LoginPage(driver);
		lp.login();
		lp.ValidEmail(email);
		lp.InvalidPassword(invalidPwd);
		lp.Login();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")).isDisplayed());
	}

	@Test(priority=3)
	void EmptyCredentialsLogin()
	{
		lp= new LoginPage(driver);
		lp.login();
		lp.InvalidEmail("");
		lp.InvalidPassword("");
		lp.Login();
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
	}

	@Test(priority=4)
	void ValidCredentialsLogin() throws InterruptedException
	{
		lp = new LoginPage(driver);
		lp.login();
		lp.ValidEmail(email);
		lp.ValidPassword(pwd);
		lp.Login();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.className("logged-in")).isDisplayed());
	}

}

