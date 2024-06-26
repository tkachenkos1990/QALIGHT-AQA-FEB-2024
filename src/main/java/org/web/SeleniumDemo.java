package org.web;

import org.web.driver.WebDriverFactory;
import org.web.page.GooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SeleniumDemo {

    //TODO: HOMEWORK
    //TODO: 1. Make Finnair a page object
    //TODO: 2. Add method that clicks "login" button
    //TODO: 3. Click email, click password, click "keep me logged in"
    //TODO: 4. Confirm error messages appear for login and pwd

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();

        GooglePage googlePage = new GooglePage(driver);

        Random random = new Random();
        GoogleActions action;
        if (random.nextBoolean()) {
            action = GoogleActions.REGULAR_SEARCH;
        } else {
            action = GoogleActions.LUCKY_SEARCH;
        }

        try {
            googlePage.loadPage();
            googlePage.acceptCookiesIfPresent();
            googlePage.setSearchText("Ben Affleck");

            if (action.equals(GoogleActions.REGULAR_SEARCH)) {
                googlePage.performSearch();
                List<WebElement> searchHeaders = googlePage.getSearchHeaders();
                for (WebElement e : searchHeaders) {
                    if (e.getText().contains("Ben Affleck")) {
                        System.out.println("Ben found!");
                        break;
//                        asd
                        //asdasd
                    }
                    System.out.println("this is new");
                }
            } else if (action.equals(GoogleActions.LUCKY_SEARCH)) {
                System.out.println("removed");
            } else {
                throw new RuntimeException("No action selected");
            }
        } finally {
            driver.quit();
        }
    }
}
