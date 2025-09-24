package com.example.demoblaze.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends PageObject {

    @FindBy(css = ".btn-success")
    private WebElementFacade placeOrderButton;

    public void placeOrder() {
        placeOrderButton.click();
        // Esperar a que el modal de compra esté visible
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));
    }
}
