package automationfc.com;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Action_PI {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Hover() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		//Find element
		
		WebElement ageTextbox=driver.findElement(By.xpath("input#age"));
		action.moveToElement(ageTextbox).perform();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask...");
		
	}

	@Test
	public void TC_02_() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");

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
