package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
	WebDriver driver = null;
	private static final By EMAIL_INPUT = By.id("inputEmail");
	
	@FindBy(id="inputEmail")
	WebElement inputEmail;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean setKeys(String email, String password) {
		boolean success;
		try {
			WebElement emailInput = driver.findElement(By.id("inputEmail"));
			emailInput.sendKeys(email);
			WebElement passwordInput = driver.findElement(By.id("inputPassword"));
			passwordInput.sendKeys(password);
			WebElement submit = driver.findElement(By.xpath("/html/body/form/button"));
			submit.click();
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

}
