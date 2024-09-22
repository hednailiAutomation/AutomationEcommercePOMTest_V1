package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductSearchPage {

	
	WebDriver driver ;
	
	public ProductSearchPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	By txt_searchbox = By.xpath("//form[@id='search_mini_form']/descendant::input[@class='input-text']");
	By option_select = By.id("qs-option-2");
	By select_product = By.id("sorter");
	By btn_product = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a");
	By btn_size  = By.id("option-label-size-143-item-169");
	By btn_color = By.id("option-label-color-93-item-50");
	By txt_quantity = By.xpath("//*[@id=\"qty\"]");
	By btn_addtocart = By.id("product-addtocart-button");
	
	
	public void SearchForProduct(String product) 
	{
		driver.findElement(txt_searchbox).sendKeys(product);
		driver.findElement(option_select).click();
	}
	
	public void SortProduct() 
	{
		driver.findElement(select_product).click();
		Select select = new Select(driver.findElement(select_product));
		select.selectByValue("price");
	}
	
	public void ChooseProduct(String qty) 
	{
		driver.findElement(btn_product).click();
		driver.findElement(btn_color).click();
		driver.findElement(btn_size).click();
		driver.findElement(txt_quantity).clear();
		driver.findElement(txt_quantity).sendKeys(qty);
		driver.findElement(btn_addtocart).click();
		
	}
}
