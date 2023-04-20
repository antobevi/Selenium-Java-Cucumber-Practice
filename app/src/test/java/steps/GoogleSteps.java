package steps;

import pages.GooglePage;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GoogleSteps {
    private GooglePage google = new GooglePage();

    @Given("^I navigate to Google$")
    public void navigateToGoogle() {
        google.navigateToGoogle();
    }
    
    @When("^I enter a search criteria$")
    public void enterSearchCriteria() {
        google.enterSearchCriteria("Mercado Libre Argentina");
    }

    @And("^I click on the search button$")
    public void clickSearchButton() {
        google.clickSearchButton();
    }

    @Then("^I get the results$")
    public void getSearchResults() {
        Assert.assertEquals("Mercado Libre Argentina - Envíos Gratis en el día", google.getFirstResult());
        google.clickOnFirstResult();
    }
    
}
