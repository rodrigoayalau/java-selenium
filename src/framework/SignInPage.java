package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	// http://127.0.0.1:5500/Html/bootstrap/sign-in/
	WebDriver driver = null;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean setKeys(String email, String password) {
		try {
			WebElement emailInput = driver.findElement(By.id("inputEmail"));
			emailInput.sendKeys(email);
			WebElement passwordInput = driver.findElement(By.id("inputPassword"));
			passwordInput.sendKeys(password);
			WebElement submit = driver.findElement(By.xpath("/html/body/form/button"));
			submit.click();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
