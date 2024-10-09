package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.AddProductToCartPage;

public class AddProductToCartTest extends TestBase{

	AddProductToCartPage addProduct = new AddProductToCartPage(driver);



	@Test()
	public void AddToCartProduct() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.counter-number"), "2"));
		addProduct.AddToCart();
		
	}
}
