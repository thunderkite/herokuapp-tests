package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropdownPage {
    private final WebDriver driver;
    private final By dropdownLocator = By.id("dropdown");

    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    private Select getSelect() {
        return new Select(driver.findElement(dropdownLocator));
    }

    public List<WebElement> getAllOptions() {
        return getSelect().getOptions();
    }

    public void selectByVisibleText(String text) {
        getSelect().selectByVisibleText(text);
    }

    public String getFirstSelectedOptionText() {
        return getSelect().getFirstSelectedOption().getText();
    }
}
