package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChangePasswordPage;
import pages.LoginPage;

public class ChangePasswordSteps extends BasePage {

	WebDriver driver = Hooks.driver;
	LoginPage lp = new LoginPage(driver);
	ChangePasswordPage pwdchange = new ChangePasswordPage(driver);

	@When("user enters {string} and {string}")
	public void user_enters_email_and_password(String username, String password) throws InterruptedException {
		lp.submitEmptyUsername(username);
		lp.submitEmptyPassword(password);
	}

	@And("hits on login button")
	public void clickLogin() throws InterruptedException {
		lp.Login();
		Thread.sleep(4000);
	}

	@And("select my account")
	public void select_my_account() throws InterruptedException {
		Thread.sleep(3000);
		pwdchange.myAccountSelect();
	}

	@And("clicks on change password link")
	public void clicks_on_change_password_link() {
		pwdchange.changePasswordLink();
	}

	@And("enters current password {string}")
	public void enters_current_password(String password) 
	{
		pwdchange.enterCurrentPassword(password);
	}

	@And("enters new password {string}")
	public void enters_new_password(String newpassword) 
	{
		pwdchange.enterNewPassword(newpassword);
	}

	@And("enters new confirm password {string}")
	public void enters_new_confirm_password(String newpassword) 
	{
		pwdchange.confirmNewPassword(newpassword);
	}


	@And("clicks on save button")
	public void clicks_on_save_button() throws InterruptedException {
		pwdchange.saveNewPassword();
	}

	@Then("password is successfully changed")
	public void password_is_successfully_changed() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath(
				"//div[@class='message-success success message']/descendant::div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))
				.getText().contains("You saved the account information"));
	}

	@Then("an error message is displayed")
	public void an_error_message_is_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='password-confirmation-error']")).getText()
				.contains("Please enter the same value again"));
	}
}
