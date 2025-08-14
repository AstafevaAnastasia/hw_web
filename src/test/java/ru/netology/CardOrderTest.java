package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardOrderTest extends BaseTest {

    @Test
    void shouldSubmitValidForm() {
        driver.get("http://localhost:9999");

        WebElement nameInput = driver.findElement(
                By.cssSelector("[data-test-id=name] input")
        );
        nameInput.sendKeys("Иванов-Петров Иван");

        WebElement phoneInput = driver.findElement(
                By.cssSelector("[data-test-id=phone] input")
        );
        phoneInput.sendKeys("+79211234567");

        WebElement agreementCheckbox = driver.findElement(
                By.cssSelector("[data-test-id=agreement]")
        );
        agreementCheckbox.click();

        WebElement submitButton = driver.findElement(
                By.cssSelector("button[type='button']")
        );
        submitButton.click();

        WebElement successMessage = driver.findElement(
                By.cssSelector("[data-test-id=order-success]")
        );
        String actualText = successMessage.getText().trim();

        assertEquals(
                "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.",
                actualText
        );
    }
}