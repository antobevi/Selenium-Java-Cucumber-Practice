package pages;

import java.util.List;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage { // Selenium
    protected static WebDriver driver; // Primero que nada necesitamos abrir el navegador, por eso creamos una instancia del Web Driver
    private static WebDriverWait wait; // Static nos permite que solo haya un mismo valor para todas las instancias
    private static Actions action;
    
    // Bloque estatico que se ejecuta al comienzo
    static {
        System.setProperty("webdriver.chrome.driver", "Z:\\Estudios\\Java\\ChromeDriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions(); // Clase para manejar opciones del chrome driver, como extensiones, etc.
        driver = new ChromeDriver(chromeOptions); // Creamos el chrome driver usando las opciones de chrome
        wait = new WebDriverWait(driver, 10); // Espera maximo 10 segundos en caso de no encontrar algo

        driver.manage().window().maximize();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Espera 10 seg para hacer c/accion. No recomendable.
        //PageFactory.initElements(driver, this); Para la inicializacion de WebElements con el uso de PageFactory
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement findWebElement(String locator) { // Es privado ya que solo lo va a usar esta clase
        // Creamos un Web Element pero antes de obtenerlo esperamos max 10 seg a ver si esta
        // Si no esta, lanza una excepción. Si lo encuentra antes de los 10 seg sigue con la siguiente instruccion.
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        findWebElement(locator).click();
    }

    public void writeInSearchTextField(String locator, String textToWrite) {
        findWebElement(locator).clear(); // Limpiamos el campo de texto por las dudas
        findWebElement(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(findWebElement(locator)); // Obtenemos el dropdown
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(findWebElement(locator)); // Obtenemos el dropdown
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(findWebElement(locator)); // Obtenemos el dropdown
        dropdown.selectByVisibleText(valueToSelect);
    }

    // Accion hoverover (pasar el mouse por encima de un elemento)
    public void hoverOverElement(String locator) {
        action.moveToElement(findWebElement(locator));
    }

    public void doubleClick(String locator) {
        action.doubleClick(findWebElement(locator));
    }

    public void rightClick(String locator) {
        action.contextClick(findWebElement(locator));
    }

    public String getValueFromTable(String locator, int row, int column) {
        String cellINeedLocator = locator + "/table/tbody/tr/[" + row + "]/td[" + column + "]";

        return findWebElement(cellINeedLocator).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String valueToSend) {
        String cellToFill = locator + "/table/tbody//tr[" + row + "]/td[" + column + "]";
        findWebElement(cellToFill).sendKeys(valueToSend);
    }

    // iFrames (cuando se abre una tab nueva)
    public void switchToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex); // Switcheas al tab que esta en la posicion (index)
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame(); // Vuelve al tab en el que estaba
    }

    // Alertas o popups
    public void dismissAlert() { // Rechazar alerta
        try {
            driver.switchTo().alert().dismiss();
        } catch(NoAlertPresentException e) {
            System.out.println("The WebElement popup couldn't be found.");
            e.printStackTrace();
        }
    }

    public void validateText(String locator, String textToValidate) {
        Assert.assertEquals(textToValidate, findWebElement(locator).getText());
    }

    public String textFromElement(String locator) {
        
        return findWebElement(locator).getText(); // Retorna el texto que contenga el elemento o si no lanza una excepcion.
    }

    // Validar si un elemento esta siendo mostrado
    public boolean elementIsDisplayed(String locator) {

        return findWebElement(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator) {

        return findWebElement(locator).isSelected();
    }

    // Obtener una lista de elementos
    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.cssSelector(locator));
    }

    public void clickOnAKey(String key) {
        // TODO
    }

    public static void closeBrowser() {
        driver.quit(); // Cierra definitivamente la instancia
        //driver.close();
    }

}