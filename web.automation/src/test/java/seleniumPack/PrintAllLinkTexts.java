package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintAllLinkTexts extends DriverUtil {

	public static void main(String[] args) {
		PrintAllLinkTexts obj = new PrintAllLinkTexts();
		WebDriver driver = obj.getDriver();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println("Count is = " + allLinks.size());
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println(i + 1 + " " + allLinks.get(i).getText());
		}

	}

}
