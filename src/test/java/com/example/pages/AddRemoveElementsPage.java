package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemoveElementsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addElementBtn = By.xpath("//button[text()='Add Element']");
    private final By deleteBtn = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void clickAddElement() {
        clickAddElementAndWaitForCount(getDeleteButtonsCount() + 1);
    }

    private void clickAddElementAndWaitForCount(int expectedCount) {
        wait.until(ExpectedConditions.elementToBeClickable(addElementBtn)).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(deleteBtn, expectedCount));
    }

    public void clickFirstDeleteElement() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteBtn).size();
    }
}
