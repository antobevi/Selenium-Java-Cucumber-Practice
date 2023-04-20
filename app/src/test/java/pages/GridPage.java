package pages;

public class GridPage extends BasePage {
    private String cellLocator = "";

    public GridPage() {
        super(driver);
    }

    public void navigateToGridPage() {
        navigateTo("");
    }

    public String getValueFromGrid(int row, int column) {
        
        return getValueFromTable(cellLocator, row, column);
    }

}
