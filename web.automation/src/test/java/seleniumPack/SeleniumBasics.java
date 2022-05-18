package seleniumPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasics {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yasothai\\Downloads\\chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		
		// System.out.println(System.getProperty("webdriver.chrome.driver"));
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.mycontactform.com/samples.php");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());

		// Navigation methods
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		driver.close();
	}

}
