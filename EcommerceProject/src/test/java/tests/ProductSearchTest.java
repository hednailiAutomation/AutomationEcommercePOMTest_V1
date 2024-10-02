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

	ProductSearchPage ps;
	LoginPage lp;
	String productName = "Jacket";
	String nbr= "2";
	String email = "test.myppBalk16@gmail.com";
	String newpwd = "123456aB-";
	String qty = "2";




	@Test(priority=1)
	@Severity(SeverityLevel.MINOR)
	void SearchProduct()
	{
		ps = new ProductSearchPage(driver);
		ps.SearchForProduct(productName);
	}

	@Test(priority=2)
	@Severity(SeverityLevel.MINOR)
	void SortProduct()
	{
		ps=new ProductSearchPage(driver);
		ps.SortProduct();
	}

	@Test(priority = 3)
	@Severity(SeverityLevel.MINOR)
	void ChooseProduct() {
		ps = new ProductSearchPage(driver);
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a"))).perform();
		ps.ChooseProduct(qty);
		Assert.assertTrue(driver.findElement(By.className("swatch-attribute-selected-option")).isDisplayed());
	}
}
