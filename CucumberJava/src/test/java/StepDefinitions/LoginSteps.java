package StepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class LoginSteps  {

	WebDriver driver ;
 
	TestBase testBase = new TestBase();
	LoginPage login ;
	
	@Before
	public void setUp() 
	{
		testBase.initializeDriver();
		login =  new LoginPage(testBase.driver);
	}
	

	@Given("user is on login page")
	public void user_is_on_login_page() {
		testBase.driver.get("https://magento.softwaretestingboard.com/");
		testBase.driver.manage().window().maximize();
		
		System.out.println(testBase.driver.getTitle());
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username,String password) {

		login.validUserCredentials(username,password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {

		login.login();

	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {

		System.out.println("user is navigated to home page");
	}

	@After
	public void tearDown() 
	{
		//testBase.driver.quit();
	}
}


