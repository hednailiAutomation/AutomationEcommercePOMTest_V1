package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductorderPage;

public class ProductOrderStep extends BasePage {

	WebDriver driver = Hooks.driver;
	ProductorderPage addtocart = new ProductorderPage(driver);

	@When("user hits on cart link")
	public void user_hits_on_cart_link() {
		addtocart.addToCart();
	}

	@And("hits the checkout button")
	public void hits_the_checkout_button() {
		addtocart.checkout();
	}

	@And("enters the email {string}")
	public void enters_email(String email) {
		addtocart.enterEmail(email);
	}

	@And("enters the password {string}")
	public void enters_password(String password) {
		addtocart.enterPassword(password);
	}

	@And("hits the login button")
	public void hits_the_login_button() {
		addtocart.submit();
	}
	

	@And("enters company {string} street {string} and city {string}")
	public void addShippingAdress(String company,String street,String city) throws InterruptedException {
		addtocart.shippingAdress(company,street,city);
	}


	@And("selects country")
	public void selects_country() throws InterruptedException {
		addtocart.selectCountry();
	}
	
	@And("enters zip {string}")
	public void zip(String zip) {
		addtocart.zipCode(zip);
	}

	@And("add phone {string}")
	public void add_phone(String phone) throws InterruptedException {
		addtocart.ContinueShipping(phone);
	}
	
	@And("check the checkbox billing adress")
	public void check_the_checkbox_billing_adress() 
	{
		addtocart.checkboxBilling();
	}
	
	@And("hits the placeholder button")
	public void hits_the_placeholder_button() 
	{
		addtocart.placeholder();
	}

	@Then("purshase validation message is displayed")
	public void purshase_validation_message() throws InterruptedException {

		addtocart.purchaseValidation();
	}
}
