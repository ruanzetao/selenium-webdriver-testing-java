package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
//	String osName = System.getProperty("os.Name");

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {
//		if (osName.contains("Mac")) {
//			System.out.println("Please add geckodriver to Mac OS");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		}

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Find Element
		WebElement emailTextbox = driver.findElement(By.id("mail"));
		if (emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys("Automation Testing");
			System.out.println("Email textbox is displayed");
		} else {
			System.out.println("Email textbox is not displayed");
		}

		WebElement ageUnder18Radio = driver.findElement(By.id("under_18"));
		if (ageUnder18Radio.isDisplayed()) {
			ageUnder18Radio.click();
			System.out.println("Age under 18 is displayed");
		} else {
			System.out.println("Age under 18 is not displayed");
		}

		WebElement educationTextArea = driver.findElement(By.id("edu"));
		if (educationTextArea.isDisplayed()) {
			educationTextArea.sendKeys("Automation Testing");
			System.out.println("Education Text Area is displayed");
		} else {
			System.out.println("Education Text Area is not displayed");
		}

		WebElement name5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		if (name5Text.isDisplayed()) {

			System.out.println("Name 5 is displayed");
		} else {
			System.out.println("Name 5 is not displayed");
		}
	}

	@Test
	public void TC_02_Enabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement emailTextbox = driver.findElement(By.id("mail"));
		if (emailTextbox.isEnabled()) {
			emailTextbox.sendKeys("Automation Testing");
			System.out.println("Email textbox is Enabled");
		} else {
			System.out.println("Email textbox is not Enabled");
		}

	}

	@Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement ageUnder18Radio = driver.findElement(By.id("under_18"));
		ageUnder18Radio.click();
		if (ageUnder18Radio.isSelected()) {
			System.out.println("Age under 18 is Selected");
		} else {
			System.out.println("Age under 18 is not Selected");
		}
	}

	@Test
	public void TC_04_Mailchimps() throws InterruptedException {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.id("email")).sendKeys("ruanzetao@mailinator.com");
		driver.findElement(By.id("new_username")).sendKeys("ruanzetao");

		WebElement passwordTextbox = driver.findElement(By.id("new_password"));
		// Lower case
		passwordTextbox.sendKeys("auto");
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());

		// Upper case
		passwordTextbox.clear();
		passwordTextbox.sendKeys("AUTO");
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
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
