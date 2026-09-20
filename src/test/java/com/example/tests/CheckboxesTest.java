package com.example.tests;

import com.example.base.TestBase;
import com.example.pages.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends TestBase {

    @Test(description = "Проверка первого чекбокса: uncheck -> check")
    public void testFirstCheckboxToggle() {
        CheckboxesPage page = new CheckboxesPage(driver, wait);
        page.open();

        Assert.assertFalse(page.isFirstCheckboxSelected(), "Первый чекбокс должен быть изначально снят");
        page.clickFirstCheckbox();
        Assert.assertTrue(page.isFirstCheckboxSelected(), "Первый чекбокс должен стать отмеченным");
    }

    @Test(description = "Проверка второго чекбокса: check -> uncheck")
    public void testSecondCheckboxToggle() {
        CheckboxesPage page = new CheckboxesPage(driver, wait);
        page.open();

        Assert.assertTrue(page.isSecondCheckboxSelected(), "Второй чекбокс должен быть изначально отмечен");
        page.clickSecondCheckbox();
        Assert.assertFalse(page.isSecondCheckboxSelected(), "Второй чекбокс должен быть снят");
    }
}
