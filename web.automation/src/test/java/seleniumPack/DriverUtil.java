package seleniumPack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtil {

	public WebDriver driver;
	public JavascriptExecutor js;
	public static String homePath = System.getProperty("user.dir");

	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = ((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.mycontactform.com/samples.php");
		return driver;
	}

	public WebDriver getDriver(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = ((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);
		return driver;
	}

	// takeScreenshot with specific name
	public void takeScreenshot(String fileName) throws IOException {
		File screens = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screens, new File(homePath + fileName + ".png"));
	}

	public void selectCheckbox(WebElement element) {
		if (!element.isSelected())
			element.click();
	}

	public void deselectCheckbox(WebElement element) {
		if (element.isSelected())
			element.click();
	}

	public void setText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void selectFromDropDown(WebElement element, int index) {
		Select dd = new Select(element);
		dd.selectByIndex(index);
	}

	public void selectFromDropDown(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByValue(value);
	}

	public void selectFromDropDownVisibleText(WebElement element, String visibletext) {
		Select dd = new Select(element);
		dd.selectByVisibleText(visibletext);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}
	
	public void executeJS(WebElement target, String jsScript) {
		js.executeScript(jsScript, target);
	}
	

}