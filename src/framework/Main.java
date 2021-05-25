package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main extends Setup {

	FileInputStream fileInput = null;
	String email = "admin";
	String password = "password";
	String fromData;
	

	@BeforeClass(enabled = true)
	public void setUp() {
		try {
			Properties properties= new Properties();
			File file = new File("D:\\Development\\Java\\java-selenium\\src\\sources\\data.properties");
			fileInput = new FileInputStream(file);
			properties.load(fileInput);
			System.out.println(properties.get("emailData"));
			System.out.println(properties.getProperty("emailData"));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		// Setup already extended.
		initializeExplorer("chrome");
	}

	@Test(priority = 1, enabled = true)
	public void loginTestPage() {
		try {
			SignInPage sigin = new SignInPage(driver);
			Assert.assertTrue(sigin.setKeys(email, password), "Failed to set keys");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, enabled = false)
	public void dashboardPageTest() {
		try {
			DashboardPage dsb = new DashboardPage(driver);
			Assert.assertTrue(dsb.personDetails(), "Failed to set keys");
			Assert.assertTrue(dsb.sendPromoAndRedem("promo"), "Validation failed");
			Assert.assertTrue(dsb.promoValidationExplicit(), "Validation failed");
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
