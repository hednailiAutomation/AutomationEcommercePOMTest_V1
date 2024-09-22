package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.AddProductToCartPage;

public class AddProductToCartTest extends TestBase{

	AddProductToCartPage addProduct;



	@Test(priority=1)
	public void AddToCartProduct() throws InterruptedException
	{
		addProduct = new AddProductToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.counter-number"), "2"));
		addProduct.AddToCart();
		
	}

	/*@Test(priority=2)
	public void ContinueShip()
	{
		addProduct  = new AddProductToCartPage(driver);
		addProduct.Continue();
	}*/

}
