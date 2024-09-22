package tests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.RegistrationPage;

public class RegistrationTest extends TestBase{

	RegistrationPage rp ;
	String firstname = "Tom";
	String lastname = "Swear";
	String email = "test.myppaz998435@gmail.com";
	String pwd = "123456Ab.";
	String newpwd = "123456aB.";



	@Test(priority=1)
	void Registration() throws InterruptedException
	{
		rp = new RegistrationPage(driver);
		rp.createAccount(firstname,lastname,email,pwd);
		AssertJUnit.assertEquals("My Account", driver.findElement(By.className("base")).getText());
	}

	@Test(priority=2)
	void ChangePassword () 
	{
		rp = new RegistrationPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='customer-name']/descendant::button[@class='action switch']")));
		rp.changePassword(pwd,newpwd);
	}
}
