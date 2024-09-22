package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.ProductOrderPage;

public class ProductOrderTest extends TestBase{

	ProductOrderPage po ;


	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		po= new  ProductOrderPage(driver);
		po.Login("test.myppaz998125@gmail.com", "123456aB.");
		Thread.sleep(10000);
	}


	@Test(priority=2)
	public void EditShipping() throws InterruptedException
	{
		po = new ProductOrderPage(driver);
		po.CheckCart("coding","Republic","21","Street","Texas","Paris");
		po.Zip("43567");
		po.CountrySelect();
		po.ContinueShipping("12345678");
	}

	@Test(priority=3)
	public void FinishShipping() throws InterruptedException
	{
		po= new ProductOrderPage(driver);
		po.placeOlderShipping();
		po.showReceipt();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='base']")).getText(), "Thank you for your purchase!");
	}
}
