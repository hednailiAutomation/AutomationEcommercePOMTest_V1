package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {

	WebDriver driver;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	By btn_myAccount = By.xpath("//div[@class='panel header']//button[@type='button']");
	By option_myAccount = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a");
	//By btn_myAccount = By.xpath("//span[@class='customer-name']/descendant::button[@class='action switch']");
	By btn_changePassword = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[2]/a[2]");
	By txt_currentPassword = By.id("current-password");
	By txt_newPassword = By.id("password");
	By txt_passwordConfirmation = By.id("password-confirmation");
	By btn_save = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
	

	public void myAccountSelect() throws InterruptedException 
	{
		driver.findElement(btn_myAccount).click();
		Thread.sleep(2000);
		driver.findElement(option_myAccount).click();
		
	}
	
	public void changePasswordLink() {
		driver.findElement(btn_changePassword).click();
	}

	public void enterCurrentPassword(String password) {
		driver.findElement(txt_currentPassword).sendKeys(password);
	}

	public void enterNewPassword(String newpassword) {
		driver.findElement(txt_newPassword).sendKeys(newpassword);
	}

	public void confirmNewPassword(String newpassword) {
		driver.findElement(txt_passwordConfirmation).sendKeys(newpassword);
	}

	public void saveNewPassword() throws InterruptedException {
		driver.findElement(btn_save).click();
		Thread.sleep(3000);
	}
}
