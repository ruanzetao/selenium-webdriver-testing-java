package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Fixed_Popup {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_() {
		driver.get("https://ngoaingu24h.com/");
		//Find element
		WebElement loginPopup=driver.findElement(By.id("modal-login-v1"));
		
		//Verify
		Assert.assertFalse(loginPopup.isDisplayed());
		driver.findElement(By.cssSelector("button.login_")).click();
		Assert.assertFalse(loginPopup.isDisplayed());
		
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][class*='fade in']input#account-input")).sendKeys("automationfc");
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][class*='fade in']input#password-input")).sendKeys("automationfc");
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][class*='fade in']button#btn-login-v1")).click();
		//sleepInSecond(3);
		Assert.assertFalse(loginPopup.isDisplayed());
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
	@Test
	public void TC_04_Random_In_DOM_KMPlayer() {
		driver.get("https://www.kmplayer.com/home");
		
		WebElement popupPlayer=driver.findElement(By.cssSelector("div.pop-player"));
		if(popupPlayer.isDisplayed()) {
			//driver.findElement(By.cssSelector("area#btn-r")).click();
			jsExecutor.executeScript("argument[0].click()", driver.findElement(By.cssSelector("area#btn-r")));
			sleepInSecond(3);
		}

	}

	@Test
	public void TC_05_() {
		driver.get("https://dehieu.vn/");

	}
//
//	@Test
//	public void TC_06_() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//	}
	
	public void sleepInSecond(long second) {
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
