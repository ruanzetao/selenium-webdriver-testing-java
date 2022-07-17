package automationfc.com;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Window_Tab {
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
	public void TC_01_Basic_Form() {
		driver.get("https://automationfc.github.io/basic-form");

//		String formTabID = driver.getWindowHandle();
//		System.out.println(formTabID);

		// Find element
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		System.out.println(driver.getCurrentUrl());
		sleepInSecond(3);

		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		System.out.println(driver.getCurrentUrl());
		sleepInSecond(3);

		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		System.out.println(driver.getCurrentUrl());
		sleepInSecond(3);

		// switchToWindowByID(formTabID);
		switchToWindowByTitle("Google");
		// Driver at page B
		driver.findElement(By.name("q")).sendKeys("Selenium");
		String googleTabID = driver.getCurrentUrl();
		System.out.println(googleTabID);
	}

	public void switchToWindowByID(String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				sleepInSecond(3);
			}
		}
	}

	public void switchToWindowByTitle(String expectedPageTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			sleepInSecond(3);
			String currentPageTitle = driver.getTitle();
			if (currentPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				sleepInSecond(3);
				driver.close();

			}
		}
	}
//	@Test
//	public void TC_02_() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
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

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
}
