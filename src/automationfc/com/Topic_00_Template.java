package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.Name");

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.out.println("Please add geckodriver to Mac OS");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Page_Url() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Action
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		String loginPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, "http://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.cssSelector("a[title='Create an Account'")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
	}

	@Test
	public void Register_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");

	}
//
//	@Test
//	public void Register_03_Incorrect_Email() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
//
//	@Test
//	public void Register_04_Password_Less_Than_6() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
//
//	@Test
//	public void Register_05_Incorrect_Confirm_Password() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
//
//	@Test
//	public void Register_06_Invalid_Phone_Number() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
