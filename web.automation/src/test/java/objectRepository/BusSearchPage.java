package objectRepository;

import org.apache.log4j.Logger;
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
	static Logger log = Logger.getLogger(BusSearchPage.class);
	
	public BusSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BusSearchPage setFromCity(String fromCity) {
		log.info("Enter FROM city as " + fromCity);
		setText(txtFromCity, fromCity);
		driver.findElement(By.xpath("//li[text()='" + fromCity + "']")).click();
		return this;
	}

	public BusSearchPage setToCity(String toCity) {
		log.info("Enter TO city as " + toCity);
		setText(txtToCity, toCity);
		driver.findElement(By.xpath("//li[text()='" + toCity + "']")).click();
		return this;
	}

	public BusSearchPage setTravalDate() {
		log.info("Set traval date as today");
		txtCalander.click();
		celTravalDateToday.click();
		return this;
	}

	public BusSearchPage setTravalDate(String date) {
		log.debug("Set traval date as " + date);
		executeJS(txtCalander, "arguments[0].removeAttribute('readonly');");
		setText(txtCalander, date);
		return this;
	}

	public BusSearchResultPage clickSearchButton() {
		log.info("Search for the bus for the given input");
		btnSearch.click();
		return new BusSearchResultPage(driver);
	}
}
