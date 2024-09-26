package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("user is on login page")
	public void user_is_on_login_page() {
         System.out.println("user_is_on_login_page");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
       System.out.println("user_enters_username_and_password");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
       System.out.println("clicks_on_login_button");
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
    System.out.println("user_is_navigated_to_home_page");
	}


}
