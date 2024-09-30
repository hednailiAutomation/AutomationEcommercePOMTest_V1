package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

	

	private WebDriver driver;
	LoginPage login;
	
	

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {

		login.loginLink();
		Thread.sleep(2000);
	}

	@When("user enters valid username and invalid password")
	
	public void user_enters_valid_username_and_invalid_password(DataTable dataTable) {
		
		List<Map<String, String>> userdata = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> mapdata : userdata) {

			login.enterUsername(mapdata.get("username"));
			login.enterPassword(mapdata.get("password"));
		}
	}

	@When("user enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password(DataTable dataTable) {

		List<Map<String, String>> userdata = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> mapdata : userdata) {
			login.enterUsername(mapdata.get("username"));
			login.enterPassword(mapdata.get("password"));
		}
	}

	@And("hits on login button")
	public void hits_on_login_button() {

		login.login();
	}

	@Then("an error message should be displayed")
	public void an_error_message_should_be_displayed() {
		System.out.println(
				driver.findElement(By.xpath("//*[@id=\\\"maincontent\\\"]/div[2]/div[2]/div/div")).getText());
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {

		System.out.println(driver.getTitle());
	}
}
