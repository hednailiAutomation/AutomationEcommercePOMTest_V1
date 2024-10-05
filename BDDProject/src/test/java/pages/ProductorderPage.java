package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductorderPage {
	
	WebDriver driver ;
	public ProductorderPage(WebDriver driver)
	{
		this.driver = driver ;
	}
	
	By btn_product = By.xpath("//main[@id='maincontent']/descendant::img[@alt='Lando Gym Jacket']");
	By btn_size  = By.id("option-label-size-143-item-169");
	By btn_color = By.id("option-label-color-93-item-50");
	By txt_quantity = By.xpath("//*[@id=\"qty\"]");
	By btn_addtocart = By.xpath("//div[@class='product-info-main']/descendant::button[@id='product-addtocart-button']");
	By hover_main =  By.xpath("//div[@id='store.menu']/descendant::a[@id='ui-id-5']");
	By hover_sub_tops = By.id("ui-id-17");
	By hover_sub_jackets = By.id("ui-id-19");
	By cart_link = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
	By checkout_btn = By.id("top-cart-btn-checkout");
	By email_txt = By.xpath("//form[@class='form form-login']/descendant::input[1]");
	By password_txt = By.xpath("//form[@class='form form-login']/descendant::input[2]");
	By login_btn = By.xpath("//*[@id=\"customer-email-fieldset\"]/fieldset/div[2]/div[1]/button");
	By firstname_txt= By.xpath("//form[@id='co-shipping-form']/descendant::input[1]");
	By lastname_txt= By.xpath("//form[@id='co-shipping-form']/descendant::input[2]");
	By company_txt = By.xpath("//form[@id='co-shipping-form']/descendant::input[3]");
	By street_txt = By.xpath("//form[@id='co-shipping-form']/descendant::input[4]");
	By street2_txt = By.xpath("//form[@id='co-shipping-form']/descendant::input[5]");
	By street3_txt = By.xpath("//form[@id='co-shipping-form']/descendant::input[6]");
	By city_txt = By.xpath("//form[@id='co-shipping-form']/descendant::input[7]");
	By province_txt = By.xpath("//form[@id='co-shipping-form']/descendant::select[@name='region_id']");
	By zip_txt = By.xpath("//form[@id='co-shipping-form']/descendant::input[9]");
	By country_select = By.xpath("//form[@id='co-shipping-form']/descendant::select[@name='country_id']");
	By phone_txt = By.xpath("//form[@id='co-shipping-form']/descendant::input[10]");
	By shipMethod_btn = By.xpath("//form[@id='co-shipping-form']/descendant::input[11]");
	By next_btn = By.xpath("//form[@id='co-shipping-method-form']/descendant::button[@class='button action continue primary']");
	By btn_shiphere = By.xpath("//footer[@class='modal-footer']/descendant::button[@class='action primary action-save-address']");
	By btn_next = By.xpath("//div[@id='shipping-method-buttons-container']/descendant::button[@class='button action continue primary']");
	By placeolder_btn = By.xpath("//form[@id='co-payment-form']/descendant::button[@title='Place Order']");
	By checkbox_billing = By.xpath("//div[@class='payment-method-content']/descendant::input[@id='billing-address-same-as-shipping-checkmo']");
	
	public void addToCart ()
	{
		driver.findElement(cart_link).click();
		
	}
	
	public void checkout () 
	{
		driver.findElement(checkout_btn).click();
	}
	
	public void enterEmail (String email)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='form form-login']/descendant::input[1]")));
		driver.findElement(email_txt).sendKeys(email);
		

	}
	
	public void enterPassword(String password) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='form form-login']/descendant::input[2]")));
		driver.findElement(password_txt).sendKeys(password);
	}
	
	public void submit() 
	{
		driver.findElement(login_btn).click();

	}

	
	public void shippingAdress(String company,String street,String city) throws InterruptedException 
	{
		driver.findElement(company_txt).sendKeys(company);
		driver.findElement(street_txt).sendKeys(street);
		driver.findElement(city_txt).sendKeys(city);
		Thread.sleep(3000);	}
	
	public void selectCountry() throws InterruptedException 
	{
		Select select2 = new Select(driver.findElement(country_select));
		select2.selectByIndex(2);
		Thread.sleep(3000);
	}
	
	public void zipCode(String zip) 
	{
		driver.findElement(zip_txt).sendKeys(zip);

	}
	
	public void ContinueShipping (String phone ) throws InterruptedException
	{
		driver.findElement(phone_txt).sendKeys(phone);
		Thread.sleep(3000);
		driver.findElement(next_btn).click();
	}
	
	public void checkboxBilling() 
	{ 
		if(!driver.findElement(checkbox_billing).isSelected()) {
		driver.findElement(checkbox_billing).click();
	}
			
	}
	
	public void placeholder() 
	{
		driver.findElement(placeolder_btn).click();
	}
	
	public void purchaseValidation() throws InterruptedException 
	{
		Thread.sleep(4000);
		org.junit.Assert.assertEquals(driver.findElement(By.xpath("//span[@class='base']")).getText(), "Thank you for your purchase!");
	}
}
