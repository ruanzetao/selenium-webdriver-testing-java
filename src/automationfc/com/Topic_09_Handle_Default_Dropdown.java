package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Handle_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_NopCommerce() {
		driver.get("https://demo.nopcommerce.com/register");
		// Action
		driver.findElement(By.id("FirstName")).sendKeys("Nguyen");
		driver.findElement(By.id("LastName")).sendKeys("Xuan Sang");

		// Dropdown
		//Khi nao dung thao tac voi element thi moi khoi tao
		select=new Select(driver.findElement(By.name("DateOfBirthDay")));
		
		//Thao tac voi Dropdown
		select.selectByVisibleText("20");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "20");
		select.isMultiple();
		
		select=new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText("May");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "May");

		select=new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText("1992");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "1992");
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
