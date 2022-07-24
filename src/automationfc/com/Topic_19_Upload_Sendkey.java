package automationfc.com;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Upload_Sendkey {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	String vietnam = "Vietnam.jpg";
	String thailand = "Thailand.jpg";
	String indonesia = "Indonesia.jpg";

//	//List String
//		List<String> fileNames;	
//	String uploadFileFolderPath=projectPath + File.separator + "uploadFiles" + File.separator;
	// Image path
	String vietnamFilePath = projectPath + File.separator + "uploadFiles" + File.separator + vietnam;
	String thailandFilePath = projectPath + File.separator + "uploadFiles" + File.separator + thailand;
	String indonesiaFilePath = projectPath + File.separator + "uploadFiles" + File.separator + indonesia;

	// Format code: Ctrl Sh F
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

//	@Test
//	public void TC_01_UploadOneFilePerTime() {
//		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
//		// Find element
//
//		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(vietnamFilePath);
//		sleepInSecond(5);
//
//		// Assert something
//
//		// Start upload
//		List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));
//		for (WebElement startButton : startButtons) {
//			startButton.click();
//			sleepInSecond(3);
//		}
//
//		// Assert something
//
//	}

	@Test
	public void TC_02_UploadMultipleFilesPerTime() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.cssSelector("input[type='file']"))
				.sendKeys(vietnamFilePath + "\n" + thailandFilePath + "\n" + indonesiaFilePath);
		sleepInSecond(5);
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

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public List<String> getFileNameInFolder() {'
//		File directoryPath=new File(uploadFileFolderPath);
//		String contents[]=directoryPath.list();
//		
//		List<String> fileNames=new ArrayList<>();
//		for (int i=0;i<contents.length;i++) {
//			System.out.println(contents[i]);
//			fileNames.add(contents[i]);
//		}
//		
//		return fileNames;
//	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
