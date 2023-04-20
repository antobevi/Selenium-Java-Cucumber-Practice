package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PageFactoryPage extends BasePage {
    @CacheLookup // SOLO PARA USAR CON ELEMENTOS ESTATICOS que no cambian al recargar la pagina.
                // Guarda en cache el elemento para que en usos posteriores no tenga que hacerse la llamada a la API de Selenium para buscarlo.
    @FindBy(id="button") // Esta anotacion nos ahorra la creacion de WebElements de la manera tradicional. Se usa para localizar WebElements.
    private WebElement button; // Por defecto, busca id o name iguales a los que le indicamos, pero podemos especificar XPaths, CSS, etc.

    public PageFactoryPage() {
        super(driver);
    }

}
