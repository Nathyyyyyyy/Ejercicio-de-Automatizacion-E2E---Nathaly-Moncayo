package com.example.demoblaze.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage extends PageObject {

    @FindBy(css = "a.btn.btn-success.btn-lg")
    private WebElementFacade addToCartButton;

    public void addToCart() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            // Esperar a que el botón esté presente usando el texto
            WebElementFacade addToCartButton = find(By.xpath("//a[contains(text(),'Add to cart')]"));
            wait.until(ExpectedConditions.visibilityOf(addToCartButton));
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCartButton.click();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar o hacer clic en el botón 'Add to cart'. Verifica el selector y el estado de la página.", e);
        }
    }
}
