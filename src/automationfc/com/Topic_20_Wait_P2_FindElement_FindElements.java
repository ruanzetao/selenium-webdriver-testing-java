package automationfc.com;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Wait_P2_FindElement_FindElements {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Find_Element() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Visible: Co tren UI va co trong DOM
		System.out.println("Start date:"+getCurrentTime());
		driver.findElement(By.xpath("//input[@id='email']"));
		System.out.println("End date:"+getCurrentTime());

	}

	@Test
	public void TC_02_Find_Elements() {
		//driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//div[@id='pageFooterChildren']/a[text()]")).click();
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
		Date date= new Date();
		return date.toString();
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}