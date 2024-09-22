package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.LoginPage;
import pages.ProductSearchPage;

public class ProductSearchTest extends TestBase {

	ProductSearchPage ps;
	LoginPage lp;
	String productName = "Jacket";
	String nbr= "2";
	String email = "test.myppaz998125@gmail.com";
	String newpwd = "123456aB.";




	@Test(priority=1)
	void SearchForProduct()
	{
			ps = new ProductSearchPage(driver);
			ps.SearchProduct(productName);
	}

	@Test(priority=2)
	void SortProduct()
	{
		ps=new ProductSearchPage(driver);
		ps.SortProduct();
	}

	@Test(priority=3)
	void ChooseProduct()
	{
		ps =new ProductSearchPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000);");
		ps.ChooseProduct(nbr);
		Assert.assertTrue(driver.findElement(By.className("swatch-attribute-selected-option")).isDisplayed());
	}
}
