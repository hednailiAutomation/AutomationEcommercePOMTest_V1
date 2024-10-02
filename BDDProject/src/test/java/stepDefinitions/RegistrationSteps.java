package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;

public class RegistrationSteps extends BasePage {

	WebDriver driver = Hooks.driver;
	RegistrationPage rp = new RegistrationPage(driver);

	@Given("user is on register page")
	public void user_is_on_register_page() {
		rp.createAccount();
	}

	@When("enters firstname {string}")
	public void enters_firstname(String firstname) {
		rp.enterFirstname(firstname);
	}

	@And("enters lastname {string}")
	public void enters_lastname(String lastname) {
		rp.enterLastname(lastname);
	}

	@And("enters email {string}")
	public void enters_email(String email) {
		rp.enterEmail(email);
	}

	@And("enters password {string}")
	public void enters_password(String password) {
		rp.enterpassword(password);
	}

	@And("enters a confirm password {string}")
	public void enters_confirm_password(String password) {
		rp.enterConfirmPassword(password);
	}

	@And("hits create account")
	public void submitRegistration() throws InterruptedException {
		rp.submit();
		Thread.sleep(3000);
	}

	@Then("registration confirm message is displayed")
	public void registration_confirm_message_is_displayed() {
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//main[@id='maincontent']/descendant::div[@class='message-success success message']"))
				.isDisplayed());
	}

}
