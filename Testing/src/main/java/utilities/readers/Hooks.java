package utilities.readers;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;
import utilities.*;

import static utilities.TestBase.driver;

public class Hooks extends TestBase {
    //===========================To attach screenshots in the extent report======================
    @After(order = 10, value = "@FERegression")
    public void takeScreenshot(Scenario scenario) {
        byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.embed(src,"image/png");
        scenario.attach(src,"image/png", scenario.getName()+ ".png" );
    }
}
