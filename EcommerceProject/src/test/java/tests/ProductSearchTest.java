package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import junit.framework.Assert;
import pages.LoginPage;
import pages.ProductSearchPage;

public class ProductSearchTest extends TestBase {

	ProductSearchPage ps = new  ProductSearchPage(driver);
	LoginPage lp = new LoginPage(driver);
	String productName = "Jack";
	String nbr= "2";
	String email = "test.myppBalk16@gmail.com";
	String newpwd = "123456aB-";
	String qty = "2";




	@Test(priority=1)
	@Severity(SeverityLevel.MINOR)
	void SearchProduct()
	{
		ps.SearchForProduct(productName);
	}

	@Test(priority=2)
	@Severity(SeverityLevel.MINOR)
	void SortProduct()
	{
		ps.SortProduct();
	}

	@Test(priority = 3)
	@Severity(SeverityLevel.MINOR)
	void ChooseProduct() {
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(
				By.xpath("//main[@id='maincontent']/descendant::img[@alt='Lando Gym Jacket']"))).perform();
		ps.ChooseProduct(qty);
		Assert.assertTrue(driver.findElement(By.className("swatch-attribute-selected-option")).isDisplayed());
	}
}
