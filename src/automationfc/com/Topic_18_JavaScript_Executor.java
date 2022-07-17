package automationfc.com;

import java.util.Random;
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

public class Topic_18_JavaScript_Executor {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_TechPanda() {
		// driver.get("http://live.techpanda.org/");
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(10);

		String techPandaDomain = (String) executeForBrowser("return document.domain");
		sleepInSecond(3);
		System.out.println(techPandaDomain);

		Assert.assertEquals(techPandaDomain, "live.techpanda.org");
		System.out.println("One");

		String techPandaUrl = (String) executeForBrowser("return document.URL");
		sleepInSecond(5);
		Assert.assertEquals(techPandaUrl, "http://live.techpanda.org/");
		System.out.println("Two");

		hightlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");
		sleepInSecond(3);
		System.out.println("3");

		hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		sleepInSecond(3);
		//Assert.assertTrue(areExpectedTextInInnerText("Samsung Galaxy was added to your shopping cart"));
		System.out.println("4");

		hightlightElement("//a[text()='Customer Service']");
		clickToElementByJS("//a[text()='Customer Service']");
		sleepInSecond(3);
		System.out.println("5");

		hightlightElement("//input[@id='newsletter']");
		scrollToElementOnTop("//input[@id='newsletter']");
		sleepInSecond(3);
		System.out.println("6");

		String emailAddress = "afc" + generateRandomNumber() + "@mailinator.com";
		sendkeyToElementByJS("//input[@id='newsletter']", emailAddress);
		hightlightElement("//button[@title='Subscribe']");
		clickToElementByJS("//button[@title='Subscribe']");
		sleepInSecond(3);
		System.out.println("7");

		//Assert.assertTrue(areExpectedTextInInnerText("Thank you for your subscription."));
		navigateToUrlByJS("https://demo.guru99.com/v4/");
		sleepInSecond(3);
		System.out.println("8");

		String techGuruDomain = (String) executeForBrowser("return document.domain");
		Assert.assertEquals(techGuruDomain, "live.techpanda.org");
		System.out.println("9");
	}

	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}

//	@Test
//	public void TC_02_Rode() {
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
	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
