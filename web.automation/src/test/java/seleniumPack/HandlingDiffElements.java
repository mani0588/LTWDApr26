package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDiffElements extends DriverUtil {

	public static void main(String[] args) throws InterruptedException {
		HandlingDiffElements obj = new HandlingDiffElements();
		WebDriver driver = obj.getDriver();

		// checkbox
		driver.findElement(By.name("email_to[]")).click();

		// textbox
		driver.findElement(By.name("subject")).sendKeys("Selenium webdriver");
		driver.findElement(By.name("email")).sendKeys("Selenium@webdriver.com");

		// Drop-down
		Select dd = new Select(driver.findElement(By.name("q3")));
		dd.selectByIndex(2);
		Thread.sleep(2000);
		dd.selectByValue("Fourth Option");
		Thread.sleep(2000);
		dd.selectByVisibleText("Second Option");
		Thread.sleep(2000);

		// Radio
		driver.findElement(By.name("q4")).click();
		// xpath -> //tagname[@attName='attValue']
		driver.findElement(By.xpath("//input[@value='Second Option']")).click();
		Thread.sleep(2000);

		// File upload
		driver.findElement(By.name("attach4589")).sendKeys("E:\\Java Selenium\\LTWDApr26\\web.automation\\pom.xml");

		// Button
		driver.findElement(By.name("submit")).click();

		// Text / para / lbl / err msg / success msg
		// String err = driver.findElement(By.xpath("//li")).getText();
		String err = driver.findElement(By.tagName("li")).getText();
		System.out.println(err);

		driver.navigate().back();

		// links
		// driver.findElement(By.linkText("Course Evaluation")).click();
		driver.findElement(By.partialLinkText("Course Eval")).click();

		// Locators - 8
		// id, name, linktext, partialLinkText
		// tagName, className, xpath, cssSelector
	}

}
