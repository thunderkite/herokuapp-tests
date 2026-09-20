package com.example.tests;

import com.example.base.TestBase;
import com.example.pages.AddRemoveElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends TestBase {

    @Test(description = "Добавление 2 элементов и удаление 1 (проверка итогового количества)")
    public void testAddAndRemoveElements() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver, wait);
        page.open();

        page.clickAddElement();
        page.clickAddElement();
        Assert.assertEquals(page.getDeleteButtonsCount(), 2, "Должно быть создано 2 кнопки Delete");

        page.clickFirstDeleteElement();
        Assert.assertEquals(page.getDeleteButtonsCount(), 1, "Должна остаться ровно 1 кнопка Delete");
    }

    @Test(description = "Проверка исходного состояния: отсутствие кнопок Delete")
    public void testInitialStateNoDeleteButtons() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver, wait);
        page.open();

        Assert.assertEquals(page.getDeleteButtonsCount(), 0, "Изначально кнопок Delete быть не должно");
    }
}
