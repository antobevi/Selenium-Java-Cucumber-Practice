package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Indicamos donde estan los features definidos
    glue = "steps", // Indicamos donde estan los steps definidos
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"}, // Para que los reportes se vean mejor
    monochrome = true, // En la terminal los resultados se ven mas claron, en bloques
    tags = "@Test" // Asi solo corre los tests que tienen esta etiqueta
)

public class Runner {

    @AfterClass // Despues de cada ejecución, cierra el browser
    public static void cleanDriver() {
        BasePage.closeBrowser();
    }

}