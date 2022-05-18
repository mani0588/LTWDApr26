package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumPack.DriverUtil;

public class BusSearchPage extends DriverUtil {

	@FindBy(xpath = "//input[@id='source']")
	private WebElement txtFromCity;
	@FindBy(xpath = "//input[@id='destination']")
	private WebElement txtToCity;
	@FindBy(xpath = "//input[@id='datepicker1']")
	private WebElement txtCalander;
	@FindBy(xpath = "//td[contains(@class,'ui-datepicker-today')]/a")
	private WebElement celTravalDateToday;
	@FindBy(xpath = "//a[text()='Search']")
	private WebElement btnSearch;

	private WebDriver driver;

	public BusSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BusSearchPage setFromCity(String fromCity) {
		setText(txtFromCity, fromCity);
		driver.findElement(By.xpath("//li[text()='" + fromCity + "']")).click();
		return this;
	}

	public BusSearchPage setToCity(String toCity) {
		setText(txtToCity, toCity);
		driver.findElement(By.xpath("//li[text()='" + toCity + "']")).click();
		return this;
	}

	public BusSearchPage setTravalDate() {
		txtCalander.click();
		celTravalDateToday.click();
		return this;
	}

	public BusSearchPage setTravalDate(String date) {
		executeJS(txtCalander, "arguments[0].removeAttribute('readonly');");
		setText(txtCalander, date);
		return this;
	}

	public BusSearchResultPage clickSearchButton() {
		btnSearch.click();
		return new BusSearchResultPage(driver);
	}
}
