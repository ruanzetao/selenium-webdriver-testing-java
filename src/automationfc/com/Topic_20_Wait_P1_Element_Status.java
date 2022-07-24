package automationfc.com;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Wait_P1_Element_Status {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Visible() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Visible: Co tren UI va co trong DOM
		System.out.println("Start date:"+getCurrentTime());
		driver.findElement(By.xpath("//input[@id='email']"));
		System.out.println("End date:"+getCurrentTime());

	}

	@Test
	public void TC_02_Invisible_In_DOM() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");

	}
//
//	@Test
//	public void TC_03_Presence() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
//
//	@Test
//	public void TC_04_Staleness() {
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

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getCurrentTime() {
		Date date= new Date(0);
		return date.toString();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
