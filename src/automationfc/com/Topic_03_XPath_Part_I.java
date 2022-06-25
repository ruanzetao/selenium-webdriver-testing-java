package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	//Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void Register_01_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		//Hide pop-up Messenger
		System.out.println("Helllll!!!");
		// Action
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		// Verify something
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
	}
	
//	@Test
//	public void Register_02_Invalid_Email() {
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//		
//	}
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
