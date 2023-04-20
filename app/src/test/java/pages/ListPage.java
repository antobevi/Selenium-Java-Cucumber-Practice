package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {
    private String searchFieldLocator = "//body/div[1]/div[1]/div[1]/span[1]/input[2]";
    private String searchResults = "div.container:nth-child(1) div.example:nth-child(3) div.demo span.twitter-typeahead div.tt-menu:nth-child(4) > div.tt-dataset.tt-dataset-states"; // "tt-dataset tt-dataset-states"; "tt-menu tt-open";
   
    public ListPage() {
        super(driver);
    }

    public void navigateToListPage() {
        navigateTo("https://twitter.github.io/typeahead.js/examples/");
    }

    public void enterSearchCriteria(String textToWrite) throws InterruptedException {
        Thread.sleep(600);
        writeInSearchTextField(searchFieldLocator, textToWrite);
    }

    public List<String> getAllResults() {
        List<WebElement> webElements = bringMeAllElements(searchResults);
        List<String> stringFromList = new ArrayList<String>();

        for(WebElement e :webElements) {
            stringFromList.add(e.getText().toLowerCase());
        }
        
        return stringFromList;
    }
    
}