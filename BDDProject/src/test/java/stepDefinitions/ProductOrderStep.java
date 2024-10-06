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
	
	@And("hits the sign in button")
	public void hits_the_signin_button() 
	{
		addtocart.signin();
	}
	
	@And("enters the email {string}")
	public void enters_email(String useremail) {
		addtocart.enterEmail(useremail);
	}

	@And("enters the password {string}")
	public void enters_password(String userpassword) {
		addtocart.enterPassword(userpassword);
	}

	@And("hits the login button")
	public void hits_the_login_button() {
		addtocart.submitLogin();
	}
	

	@And("enters company {string}")
	public void enterCompany(String company) throws InterruptedException  {
		Thread.sleep(10000);
		addtocart.company(company);
	}
	
	@And("enters street {string}")
	public void enters_street(String street ) 
	{
		addtocart.street(street);
	}
	
	@And("enters city {string}")
	public void enters_city(String city) throws InterruptedException 
	{
		addtocart.enterCity(city);
	}
	
	@And("selects state province")
	public void selects_state_province() 
	{
		addtocart.province();
	}
	
	@And("enters zip code {string}")
	public void zip(String zip)
	{
		addtocart.zipCode(zip);
	}
	
	@And("selects country")
	public void selects_country() throws InterruptedException
	{
		addtocart.selectCountry();
	}

	@And("add enters phone {string}")
	public void add_phone(String phone) throws InterruptedException 
	{
		addtocart.phone(phone);
	}
	
	@And("choose shipping method")
	public void choose_shipping_method() throws InterruptedException 
	{
		Thread.sleep(5000);
		addtocart.shipingMethod();
	}
	
	@And("hits next button")
	public void hits_next_button() 
	{
		addtocart.next();
	}
	
	@And("hits the placeholder button")
	public void hits_the_placeholder_button() throws InterruptedException 
	{
		addtocart.placeholder();
	}

	@Then("purshase validation message is displayed")
	public void purshase_validation_message() throws InterruptedException 
	{

		addtocart.purchaseValidation();
	}
}