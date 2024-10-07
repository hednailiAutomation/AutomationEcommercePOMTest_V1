package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginTest extends TestBase{
 
	LoginPage lp = new LoginPage(driver);
	
	String email = "test.myppBalk99879@gmail.com";
	String validpwd = "123456aB-";
	String invalidEmail1 = "123abc@";
	String invalidEmail2 = "123abc.com";
	String invalidEmail3 = "123abc";
	String invalidPwd1 = "abcdefgh";
	String invalidPwd2 = "123456789";
	String invalidPwd3 = "123Ab.";



	@Test(priority=2)
	@Description("Verify login fonctionality with invalid email / valid password")
	@Severity(SeverityLevel.CRITICAL)
	void  InvalidEmailLogin() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login(invalidEmail1,validpwd);
		lp.signin();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
		lp.login(invalidEmail2,validpwd);
		lp.signin();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
		lp.login(invalidEmail3,validpwd);
		lp.signin();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());

	}

	@Test(priority=1)
	@Description("Verify login fonctionality with valid email / invalid password")
	void  InvalidPasswordLogin() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login(email,invalidPwd1);
		lp.signin();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")).isDisplayed());
		lp.login(email,invalidPwd2);
		lp.signin();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")).isDisplayed());
		lp.login(email,invalidPwd3);
		lp.signin();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")).isDisplayed());
	}

	@Test(priority=3)
	@Description("Verify login fontionnality with empty input credentials")
	void EmptyCredentialsLogin() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login("","");
		lp.signin();
		Thread.sleep(4);
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
	}

	@Test(priority=4)
	@Description("Verify login fonctionality with valid email / valid password")
	@Severity(SeverityLevel.BLOCKER)
	void ValidCredentialsLogin() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login(email,validpwd);
		lp.signin();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.className("logged-in")).isDisplayed());
	}

	@Test(priority=5)
	void SignOut() throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(1000);
		lp.Signout();
		
	}

}

