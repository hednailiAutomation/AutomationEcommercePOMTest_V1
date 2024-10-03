package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.SearchWithHoverActionsPage;

public class SearchWithHoverActionsSteps extends BasePage {
	
	WebDriver driver = Hooks.driver;
	SearchWithHoverActionsPage searchhov = new SearchWithHoverActionsPage(driver);
	
	
	@When("user hovers on Men in store menu")
	public void user_hovers_on_Men_in_store_menu() 
	{
		searchhov.hoverMainMenu();
	}
	
	@And("navigates to Tops sub menu")
	public void navigates_to_Tops_sub_menu() 
	{
		searchhov.hoverSubTop();
	}
	
	@And("navigates to Jackets sub menu and clicks on it")
	public void navigates_to_Jackets_sub_menu_and_clicks_on_it() 
	{
		searchhov.hoverJackets();
	}	

}
