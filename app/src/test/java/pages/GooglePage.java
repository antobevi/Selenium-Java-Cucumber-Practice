package pages;

public class GooglePage extends BasePage { // Herencia
    private String searchTextFieldLocator = "//textarea[@id='APjFqb']";
    private String searchButtonLocator = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[8]/center[1]/input[1]"; // "Buscar con Google" button
    //private String searchButtonLocator = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/*[1]"; // Magnifying glass button
    private String firstResultLocator = "//h3[contains(text(),'Mercado Libre Argentina - Envíos Gratis en el día')]";

    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle() {
        BasePage.navigateTo("https://www.google.com");
    }

    public void enterSearchCriteria(String criteria) {
        writeInSearchTextField(searchTextFieldLocator, criteria);
    }

    public void clickSearchButton() {
        clickElement(searchButtonLocator);
    }

    public String getFirstResult() {
        return textFromElement(firstResultLocator);
    }

    public void clickOnFirstResult() {
        clickElement(firstResultLocator);
    }

}
