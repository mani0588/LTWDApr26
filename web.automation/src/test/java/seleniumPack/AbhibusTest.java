package seleniumPack;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import objectRepository.BusSearchPage;

public class AbhibusTest extends DriverUtil {

	BusSearchPage busSearchPage;

	@DataProvider // Egar
	public String[][] getTravelDetails() {
		String[][] data = { { "Chennai", "Bangalore" }, { "Bangalore", "Chennai" }, { "Hyderabad", "Bangalore" } };
		return data;
	}

	@DataProvider
	public String[][] getTravelDetailsExcel() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./src/test/resources/TravalDetails.xlsx");
		XSSFSheet sh1 = wb.getSheet("Sheet1");

		int rowsCount = sh1.getLastRowNum() + 1;
		String[][] data = new String[rowsCount][2];
		for (int i = 0; i < rowsCount; i++) {
			data[i][0] = sh1.getRow(i).getCell(0).getStringCellValue();
			data[i][1] = sh1.getRow(i).getCell(1).getStringCellValue();
		}
		return data;
	}

	@Test(enabled = false, dataProvider = "getTravelDetailsExcel")
	public void verifyBusSearchFunctionWorkingForValidInput(String fromCity, String toCity) {
		busSearchPage.setFromCity(fromCity).setToCity(toCity).setTravalDate().clickSearchButton();

		assertThat(getTitle()).as("Title is not matching with some conditions").startsWith(fromCity).contains(toCity)
				.endsWith("Bus Tickets at Abhibus.com");
	}

	@Test(enabled = true)
	public void verifyBusSearchFunctionWorkingForPastDate() {
		String fromCity = "Chennai";
		String toCity = "Bangalore";
		busSearchPage.setFromCity(fromCity).setToCity(toCity).setTravalDate("20-04-2022").clickSearchButton();

		assertThat(getTitle()).as("Title is not matching with some conditions").startsWith(fromCity).contains(toCity)
				.endsWith("Bus Tickets at Abhibus.com");
	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {

		PropertyConfigurator.configure("./log4j.properties");

		getDriverWithName(browser);
		busSearchPage = new BusSearchPage(driver);
	}

	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}

}
