package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By inputLocator = By.tagName("input");

    public InputsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    private WebElement getInputElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
    }

    public void sendKeys(String keys) {
        getInputElement().sendKeys(keys);
    }

    public void pressArrowUp() {
        getInputElement().sendKeys(Keys.ARROW_UP);
    }

    public void pressArrowDown() {
        getInputElement().sendKeys(Keys.ARROW_DOWN);
    }

    public void clear() {
        getInputElement().clear();
    }

    public String getValue() {
        return getInputElement().getAttribute("value");
    }
}
