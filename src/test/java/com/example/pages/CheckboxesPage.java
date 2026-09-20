package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;

    // Локатор согласно заданию
    private final By checkboxes = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    private List<WebElement> getAllCheckboxes() {
        return driver.findElements(checkboxes);
    }

    public boolean isFirstCheckboxSelected() {
        return getAllCheckboxes().get(0).isSelected();
    }

    public void clickFirstCheckbox() {
        getAllCheckboxes().get(0).click();
    }

    public boolean isSecondCheckboxSelected() {
        return getAllCheckboxes().get(1).isSelected();
    }

    public void clickSecondCheckbox() {
        getAllCheckboxes().get(1).click();
    }
}
