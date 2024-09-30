package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps extends BasePage {

	
	WebDriver driver = Hooks.driver;
	LoginPage lp = new LoginPage(driver);
	
	@Given("user is on login page")
	public void user_login() {
		LoginPage lp = new LoginPage(driver);
		lp.loginLink();
	}

	@When("^user enters username and password$")
	public void enterCredentials(DataTable dataTable) throws InterruptedException {
		
		List<Map<String, String>> userdata = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> mapdata : userdata) {
			lp.enterUsername(mapdata.get("username"));
			lp.enterPassword(mapdata.get("password"));
			lp.login();
			Thread.sleep(4000);
		}

	}

	@When("user enters {string} and {string} for credentials")
	public void user_enters_empty_credentials(String username, String password) throws InterruptedException {

		
		lp.submitEmptyUsername(username);
		lp.submitEmptyPassword(password);
		lp.login();
		Thread.sleep(4000);
	}


	@Then("user is navigated to home page")
	public void succesLogin() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.className("logged-in")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.className("logged-in")).getText().contains("Welcome"));
	}

	@Then("an email error message should be displayed")
	public void an_email_error_message_should_be_displayed() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//form[@class='form form-login']/descendant::div[@id='email-error']")).getText().contains("Please enter a valid email address"));
	}

	@Then("a password error message should be displayed")
	public void a_password__error_message_should_be_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message-error error message']")).getText()
				.contains("The account sign-in was incorrect"));
	}

	@Then("required fields error message should be displayed")
	public void required_fields_error_message_should_be_displayed() {
		Assert.assertTrue(driver.findElement(By.id("pass-error")).getText().contains("This is a required field"));

	}
}
