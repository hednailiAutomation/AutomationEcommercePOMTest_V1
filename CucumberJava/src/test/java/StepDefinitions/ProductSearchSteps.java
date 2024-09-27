package StepDefinitions;

import io.cucumber.java.en.*;

public class ProductSearchSteps {

	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("inside step - browser is open");
	}

	@And("user is on search page")
	public void user_is_on_search_page() {

		System.out.println("inside step -user is on search page");

	}

	@When("user enters product name in search box")
	public void user_enters_product_name_in_search_box() {

		System.out.println("inside step - user enters product namein search box");
	}

	@And("hits enter")
	public void hits_enter() {

		System.out.println("inside step- hits enter");

	}

	@Then("user is navigated to search result")
	public void user_is_navigated_to_search_result() {

		System.out.println("inside step-user is navigated to search result");

	}
}
