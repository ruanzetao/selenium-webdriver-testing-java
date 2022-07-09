package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Textbox_TextArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	String loginUrl;
	String userID;
	String password;
	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/");
		loginUrl=driver.getCurrentUrl();
		//Define variables
		emailAddress="checkinbysang"+"@mailinator.com";
		
		
	}

	@Test
	public void TC_01_Register() {
		
		//Find element
		//Ctrl + Space => Suggest code
		// Home
		// End
		
//		driver.findElement(By.xpath("//a[text()='here']"));
		driver.findElement(By.name("emailid")).sendKeys(emailAddress);;
		driver.findElement(By.name("btnLogin")).click();
		
		userID=driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password=driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		
		
	}

	@Test
	public void TC_02_Login() {
		driver.get(loginUrl);
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		//Verify home page is displayed
		driver.findElement(By.cssSelector("tr.heading3>td"));
		Assert.assertEquals(driver.findElement(By.cssSelector("tr.heading3>td")).getText(), "Manger Id: "+userID);
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
