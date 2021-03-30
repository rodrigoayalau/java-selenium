package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EntryPoint {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/drivers_explorers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("D:/Development/html/bootstrap/checkout/index.html");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		TimeUnit.SECONDS.sleep(3);
		WebElement firstNameInput = driver.findElement(By.xpath("//*[@id='firstName']"));
		firstNameInput.sendKeys("Rodrigo");
		WebElement lastNameInput = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[1]/div[2]/input"));
		lastNameInput.sendKeys("Ayala");
		WebElement userNameInput = driver.findElement(By.id("username"));
		userNameInput.sendKeys("rodrigoayalau");
		
		TimeUnit.SECONDS.sleep(3);
		WebElement privacyLink = driver.findElement(By.linkText("Privacy"));
		privacyLink.click();
		TimeUnit.SECONDS.sleep(3);
		driver.switchTo().alert().accept();
		
		TimeUnit.SECONDS.sleep(3);
		WebElement dropDownMenuElement = driver.findElement(By.xpath("//*[@id='country']"));
		Select select = new Select(dropDownMenuElement);
		select.selectByIndex(1);
		
		TimeUnit.SECONDS.sleep(3);
		WebElement visaOption = driver.findElement(By.id("visa"));
		WebElement masterCardOption = driver.findElement(By.id("mc"));
		WebElement amexOption = driver.findElement(By.id("amex"));
		
		TimeUnit.SECONDS.sleep(3);
		if(visaOption.isSelected()) {
			System.out.println("Visa is checked");
		}
		
		if(!masterCardOption.isDisplayed()) {
			System.out.println("MC is hidden");
		}
		
		if(amexOption.isEnabled()) {
			System.out.println("AMEX is enabled");
		} else {
			System.out.println("AMEX is disabled");
		}
		
		driver.close();
		driver.quit();
		
	}

}
