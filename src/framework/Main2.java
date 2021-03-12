package framework;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main2 extends Setup {

	String email = "admin";
	String password = "password";

	@BeforeClass(enabled = true)
	public void setUp() {
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

	@Test(priority = 2, enabled = true)
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

	@AfterClass(enabled = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
