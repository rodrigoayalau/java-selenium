package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver = null;
	//WebDriverWait wait = new WebDriverWait(driver, 5);
	
	private By BUTTON_REDEEM = By.xpath("//*[@id='redeem-the-code']");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean personDetails() {
		boolean success;
		try {
			WebElement firstNameInput = driver.findElement(By.xpath("//*[@id='firstName']"));
			firstNameInput.sendKeys("Rodrigo");
			WebElement lastNameInput = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[1]/div[2]/input"));
			lastNameInput.sendKeys("Ayala");
			WebElement userNameInput = driver.findElement(By.id("username"));
			userNameInput.sendKeys("rodrigoayalau");
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		return success;
	}

	public boolean sendPromoAndRedem(String promo) {
		boolean success;
		try {
			WebElement inputCode = driver.findElement(By.id("the-text-for-promo"));
			inputCode.sendKeys(promo);
			WebElement button = driver.findElement(BUTTON_REDEEM);
			button.click();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		return success;
	}
	
	// Explicit await waits for a certain condition in the DOM.
	public boolean promoValidationExplicit() {
		boolean success;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			WebElement promoCodeBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-success']")));
			if(promoCodeBox.isDisplayed())
				System.out.print("Visible");
			else
				System.out.print("!Visible");
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		return success;
	}
	
	// Implicit await  waits for an element that is not available in the moment.
	public boolean promoValidationImplicit() {
		boolean success;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			WebElement promoCodeBox = driver.findElement(By.xpath("//span[@class='text-success']"));
			if(promoCodeBox.isDisplayed())
				System.out.print("Visible");
			else
				System.out.print("!Visible");
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		return success;
	}
	
}
