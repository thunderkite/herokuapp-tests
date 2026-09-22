package com.example.tests;

import com.example.base.TestBase;
import com.example.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends TestBase {

    @Test(description = "Проверка начального значения выпадающего списка")
    public void testDropdownDefaultOption() {
        DropdownPage page = new DropdownPage(driver, wait);
        page.open();

        Assert.assertEquals(page.getFirstSelectedOptionText(), "Please select an option",
                "При открытии должен быть выбран placeholder");
    }

    @Test(description = "Проверка наличия всех элементов в выпадающем списке")
    public void testDropdownElementsPresence() {
        DropdownPage page = new DropdownPage(driver, wait);
        page.open();

        Assert.assertEquals(page.getAllOptions().size(), 3, "Список должен содержать ровно 3 опции");
    }

    @Test(description = "Выбор Option 1 и Option 2 с проверкой статуса")
    public void testSelectDropdownOptions() {
        DropdownPage page = new DropdownPage(driver, wait);
        page.open();

        page.selectByVisibleText("Option 1");
        Assert.assertEquals(page.getFirstSelectedOptionText(), "Option 1", "Должен быть выбран Option 1");

        page.selectByVisibleText("Option 2");
        Assert.assertEquals(page.getFirstSelectedOptionText(), "Option 2", "Должен быть выбран Option 2");
    }
}
