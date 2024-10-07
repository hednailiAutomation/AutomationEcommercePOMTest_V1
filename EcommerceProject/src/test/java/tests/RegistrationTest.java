package tests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase{

	RegistrationPage rp = new RegistrationPage(driver);
	String firstname = "Jean";
	String lastname = "Brown";
	String email = "test.myppBalk99879@gmail.com";
	String password = "223456zE-";
	String newpassword = "123456aB-";



	@Test(priority=1)
	@Description("Verify user can register")
	@Severity(SeverityLevel.BLOCKER)

	void Registration() throws InterruptedException
	{
		RegistrationPage rp = new RegistrationPage(driver);
		rp.createAccount(firstname,lastname,email,password);
		Thread.sleep(3000);
		Assert.assertEquals("My Account", driver.findElement(By.className("base")).getText());
		Thread.sleep(4000);
	}

	@Test(priority=2)
	@Severity(SeverityLevel.CRITICAL)
	void ChangePassword () throws InterruptedException 
	{
		RegistrationPage rp = new RegistrationPage(driver);
		rp.changePasswordBtn();
	}
	
	@Test(priority=3)
	void changePasswordFields() throws InterruptedException 
	{
		RegistrationPage rp = new RegistrationPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-password")));
		rp.changePasswordFields(password,newpassword );
		Thread.sleep(3000);
	}
	
}