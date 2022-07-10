package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Button_Radio_Checkbox {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		// Find elements
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

		By loginButtonBy = By.cssSelector("button.fhs-btn-login");

		// Verify
		Assert.assertFalse(driver.findElement(loginButtonBy).isEnabled());
		driver.findElement(By.id("login_username")).sendKeys("ruanzetao@mailinator.com");
		driver.findElement(By.id("login_password")).sendKeys("123456");

		// Verify
		Assert.assertFalse(driver.findElement(loginButtonBy).isEnabled());

		// Verify background is red
		String loginButtonBackgroundColor = driver.findElement(loginButtonBy).getCssValue("background-color");
		System.out.println(loginButtonBackgroundColor);

	}

	@Test
	public void TC_02_Default_Radio_Checkbox() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		//Tim element
		//Assert checked/unchekced
		//Assert selected/deselected
		

	}
//
//	@Test
//	public void TC_03_() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
//
//	@Test
//	public void TC_04_() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
//
//	@Test
//	public void TC_05_() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
//
//	@Test
//	public void TC_06_() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
