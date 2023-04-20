package steps;

import java.util.List;

import io.cucumber.java.en.*;
import pages.ListPage;

public class ListSteps {
    private ListPage listPage = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToListPage() {
        listPage.navigateToListPage();
    }

    @When("^I search (.+) in the list$") // El (.+) significa "cualquier string que le pasemos"
    public void searchTheList(String textToWrite) throws InterruptedException {
        listPage.enterSearchCriteria(textToWrite);
    }
    
    @Then("^I can find (.+) in the list$")
    public void findTextInTheList(String searchedText) throws InterruptedException {
        List<String> allResults = listPage.getAllResults();
        Boolean textIsOnTheList = allResults.contains(searchedText);

        if(textIsOnTheList) {
            System.out.println("YAY! The text is on the list.");
        } else {
            System.out.println("ERROR! The text isn't on the list.");
        }
    }
    
}
