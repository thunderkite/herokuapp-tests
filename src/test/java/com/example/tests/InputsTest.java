package com.example.tests;

import com.example.base.TestBase;
import com.example.pages.InputsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends TestBase {

    @Test(description = "Ввод стрелками ARROW_UP и ARROW_DOWN")
    public void testKeyboardArrowsInput() {
        InputsPage page = new InputsPage(driver, wait);
        page.open();

        page.pressArrowUp();
        Assert.assertEquals(page.getValue(), "1", "После одной стрелки вверх значение должно быть 1");

        page.pressArrowUp();
        Assert.assertEquals(page.getValue(), "2", "После повторной стрелки вверх значение должно быть 2");

        page.pressArrowDown();
        Assert.assertEquals(page.getValue(), "1", "После стрелки вниз значение должно стать 1");
    }

@Test(description = "Негативный кейс: ввод нецифровых символов в числовой инпут")
public void testNonNumericInputRejection() {
    InputsPage page = new InputsPage(driver, wait);
    page.open();

    // 1. Проверяем, что буквы не принимаются числовым полем
    page.sendKeys("abcdef");
    Assert.assertEquals(page.getValue(), "", "Поле не должно принимать буквы");

    // 2. Очищаем буфер поля
    page.clear();

    // 3. Проверяем, что числовые значения вводятся корректно
    page.sendKeys("42");
    Assert.assertEquals(page.getValue(), "42", "Поле должно корректно принимать цифры");
	}
}
