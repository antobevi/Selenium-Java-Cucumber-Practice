package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks  extends BasePage {
    
    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
 
        if(scenario.isFailed()) {
            scenario.log("Scenario failed, see the attached image.");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "scenario-failed");
        }

    }

}
