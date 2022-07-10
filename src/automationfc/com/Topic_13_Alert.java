package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Alert {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Alert alert;

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/");
		//Find Element
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		
		//Accept
		alert.accept();
		
		Assert.assertEquals(driver.findElements(By.cssSelector("p#result")), "You click an alert successfully");
	}

	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/");
		//Find Element
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		
		//Accept
		alert.dismiss();
		
		Assert.assertEquals(driver.findElements(By.cssSelector("p#result")), "You click: Cancel");

	}

	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/");
		//Find Element
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Prompt");
		
		//Accept
		alert.sendKeys("Alert");
		alert.accept();
		
		Assert.assertEquals(driver.findElements(By.cssSelector("p#result")), "You enter: "+"Alert");

	}

	@Test
	public void TC_04_Authentication_Alert() {
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		

	}
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
