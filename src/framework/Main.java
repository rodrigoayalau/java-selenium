package framework;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main extends Setup {

	String email = "ids.ayala@gmail.com";
	String password = "password";

	@BeforeClass(enabled = true)
	public void setUp() {
		initializeExplorer("chrome");
	}

	@Test(enabled = true)
	public void firstTest() {
		try {
			SignInPage sigin = new SignInPage(driver);
			Assert.assertTrue(sigin.setKeys(email, password), "Failed to set keys");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@AfterClass(enabled = false)
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
