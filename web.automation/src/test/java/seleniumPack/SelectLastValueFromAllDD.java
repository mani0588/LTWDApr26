package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectLastValueFromAllDD extends DriverUtil {

	public static void main(String[] args) {
		SelectLastValueFromAllDD obj = new SelectLastValueFromAllDD();
		WebDriver driver = obj.getDriver();

		List<WebElement> allDropDown = driver.findElements(By.tagName("select"));
		int totalDDs = allDropDown.size();
		System.out.println(totalDDs);

		for (int i = 0; i < totalDDs; i++) {
			Select dd = new Select(allDropDown.get(i));
			List<WebElement> dropDownValues = dd.getOptions();
			System.out.println(dropDownValues.size() + "  " + dropDownValues.get(dropDownValues.size() - 1).getText());
			
			dd.selectByIndex(dropDownValues.size() - 1);
		}
		
		Select dd = new Select(driver.findElement(By.tagName("select")));
		System.out.println(dd.getFirstSelectedOption().getText());
		
//		driver.findElement(By.xpath("//table"))
//			.findElement(By.xpath("//tr[@class='abc']"))
//			.findElement(By.xpath("//td[tect()='Chennai']"))
//			.click();
		
//		click();

	}

}
