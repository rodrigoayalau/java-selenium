package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
	
	WebDriver driver = null;
	
	public WebDriver initializeExplorer(String theDriver) {
		switch(theDriver) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:/drivers_explorers/chromedriver/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "ie":
				System.out.println("Ejecutando IE");
				break;
		}
		//driver.get("http://127.0.0.1:5500/Html/bootstrap/checkout/");
		driver.get("D:\\Development/Html/bootstrap/sign-in/index.html");
		driver.manage().window().maximize();
		return driver;
	}

}