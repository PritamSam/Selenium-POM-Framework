package dataProvider;

import org.testng.annotations.DataProvider;

import utils.CSVUtils;

public class TestDataProvider {
	@DataProvider(name = "searchData")
    public static Object[][] searchData() {

        return CSVUtils.getCsvData(
                "testData/testData.csv"
        );
    }
}
