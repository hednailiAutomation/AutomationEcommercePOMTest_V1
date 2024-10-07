package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductToCartPage {

	WebDriver driver ;

	public AddProductToCartPage (WebDriver driver)
	{
		this.driver =driver;
	}


	By cart_link = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
	By checkout_btn = By.id("top-cart-btn-checkout");


	public void AddToCart ()
	{
		
		driver.findElement(cart_link).click();
		driver.findElement(checkout_btn).click();
	}

}
