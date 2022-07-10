package automationfc.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Handle_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		//Explicit wait luon khoi tao sau driver => Vi no can gia tri cua driver de khoi tao explicitWait len;
		//Wait cho cac element theo dk co san: visible/invisible/ presence/ clickable/...
		explicitWait =new WebDriverWait(driver, 15);
		
		//Ep kieu tuong minh trong java
		jsExecutor= (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		// Find Element Action
		//"ul#number-menu>li>div"
		//"ul#number-menu>li>div"
	}

	@Test
	public void selectItemCustomDropdown(String parentLocator,String childLocator, String expectedTextItem) {
		driver.findElement(By.cssSelector(parentLocator)).click();
		//Sleep
		//sleepInSecond(1);
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		List<WebElement> allDropdownItems=driver.findElements(By.cssSelector(childLocator));
		for(WebElement item: allDropdownItems) {
			String actualTextItem=item.getText();
			if(actualTextItem.equals(expectedTextItem)) {
				// Scroll to element
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", item);
				//Sleep
				//sleepInSecond(1);
				item.click();
				//Sleep
				//sleepInSecond(1);
				break;
			}
		}

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
