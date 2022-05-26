package seleniumPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits extends DriverUtil {

	public static void main(String[] args) {
		Waits obj = new Waits();
		WebDriver driver = obj.getDriver();

		//Implicit wait -> global, visiblity, 0 to 10, 500ms
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//chk")).click();
		
		
		// Explicit wait -> specific to element with specific condition, 0 to 10, 500ms
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//input[@type='checkbox']"), 9));
		
	}

}
