package steps;

import pages.GridPage;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GridSteps {
    private GridPage grid = new GridPage();

    @Given("^I navigate to the Grid Page$")
    public void navigateToGridPage() {
        grid.navigateToGridPage();
    }

    @Then("^I get the text of the cell that I need$")
    public void getTextCell() {
        String cellText = grid.getValueFromGrid(3, 2);

        Assert.assertEquals("", cellText);
    }

}
