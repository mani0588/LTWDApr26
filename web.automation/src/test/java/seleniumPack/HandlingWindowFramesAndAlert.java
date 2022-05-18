package seleniumPack;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandlingWindowFramesAndAlert extends DriverUtil {

	public static void main(String[] args) throws IOException {
		HandlingWindowFramesAndAlert obj = new HandlingWindowFramesAndAlert();
		WebDriver driver = obj.getDriver("https://www.w3schools.com/js/js_popup.asp");

		driver.findElement(By.linkText("Try it Yourself »")).click();

		obj.takeScreenshot("HomePage");

		Set<String> allWindIDs = driver.getWindowHandles();
		driver.switchTo().window(allWindIDs.toArray()[1].toString());

		obj.takeScreenshot("AlertPage");

		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept(); // ok or yes
//		alert.dismiss(); //Cancel or no or close

	}

}
