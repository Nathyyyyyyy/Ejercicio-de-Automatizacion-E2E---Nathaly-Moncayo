package com.example.demoblaze.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PageObject {

    @FindBy(id = "name")
    private WebElementFacade nameField;

    @FindBy(id = "country")
    private WebElementFacade countryField;

    @FindBy(id = "city")
    private WebElementFacade cityField;

    @FindBy(id = "card")
    private WebElementFacade cardField;

    @FindBy(id = "month")
    private WebElementFacade monthField;

    @FindBy(id = "year")
    private WebElementFacade yearField;

    @FindBy(css = ".btn-primary")
    private WebElementFacade purchaseButton;

    public void fillForm(String name, String country, String city, String card, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void purchase() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        // Esperar a que el modal de compra esté visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));
        // Buscar el botón Purchase solo dentro del modal de compra
        WebElementFacade modalPurchaseButton = find(By.cssSelector("#orderModal .btn-primary"));
        wait.until(ExpectedConditions.visibilityOf(modalPurchaseButton));
        wait.until(ExpectedConditions.elementToBeClickable(modalPurchaseButton));
        wait.until(driver -> modalPurchaseButton.isEnabled());
        evaluateJavascript("arguments[0].scrollIntoView(true);", modalPurchaseButton);
        try {
            modalPurchaseButton.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(modalPurchaseButton));
            modalPurchaseButton.click();
        }
    }
}
