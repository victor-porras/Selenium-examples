package intermedium;

import org.testng.annotations.DataProvider;

public class dataProviderClass {
    @DataProvider(name = "SearchProvider")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"Fernando", "Google"},
                {"Luis", "Yahoo"},
                {"Sara", "Gmail"},
                {"Lorena", "Amazon"}
        };
    }
}
