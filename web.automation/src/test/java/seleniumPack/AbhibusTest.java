package seleniumPack;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.BusSearchPage;

public class AbhibusTest extends DriverUtil {

	BusSearchPage busSearchPage;

	// logs
	// excel
	// waits
	// mouse

	@DataProvider // Egar
	public String[][] getTravelDetails() {
		String[][] data = { { "Chennai", "Bangalore" }, { "Bangalore", "Chennai" }, { "Hyderabad", "Bangalore" } };
		return data;
	}

	@Test(enabled=false, dataProvider = "getTravelDetails")
	public void verifyBusSearchFunctionWorkingForValidInput(String fromCity, String toCity) {
		busSearchPage
			.setFromCity(fromCity)
			.setToCity(toCity)
			.setTravalDate()
			.clickSearchButton();

		assertThat(getTitle()).as("Title is not matching with some conditions").startsWith(fromCity).contains(toCity)
				.endsWith("Bus Tickets at Abhibus.com");
	}
	
	@Test
	public void verifyBusSearchFunctionWorkingForPastDate() {
		String fromCity = "Chennai"; 
		String toCity = "Bangalore";
		busSearchPage
			.setFromCity(fromCity)
			.setToCity(toCity)
			.setTravalDate("20-04-2022")
			.clickSearchButton();

		assertThat(getTitle()).as("Title is not matching with some conditions").startsWith(fromCity).contains(toCity)
				.endsWith("Bus Tickets at Abhibus.com");
	}

	@BeforeMethod
	public void beforeMethod() {
		getDriver("https://www.abhibus.com/");
		busSearchPage = new BusSearchPage(driver);
	}

	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}

}
