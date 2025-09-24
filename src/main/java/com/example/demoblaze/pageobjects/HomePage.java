package com.example.demoblaze.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {

    @FindBy(css = "#tbodyid .card-title a")
    private WebElementFacade firstProduct;

    public void openFirstProduct() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            // Esperar a que haya al menos un enlace de producto en el contenedor #tbodyid
            wait.until(driver -> driver.findElements(By.cssSelector("#tbodyid a")).size() > 0);
            WebElementFacade firstProduct = find(By.cssSelector("#tbodyid a"));
            wait.until(ExpectedConditions.visibilityOf(firstProduct));
            wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
            firstProduct.click();
        } catch (Exception e) {
            throw new RuntimeException("No se encontró el primer producto en la página de inicio. Verifica el selector o la carga de la página.", e);
        }
    }

    public void openProductByName(String productName) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(driver -> driver.findElements(By.cssSelector("#tbodyid .card-title a")).size() > 0);
            for (WebElementFacade product : findAll(By.cssSelector("#tbodyid .card-title a"))) {
                if (product.getText().trim().equalsIgnoreCase(productName.trim())) {
                    wait.until(ExpectedConditions.visibilityOf(product));
                    wait.until(ExpectedConditions.elementToBeClickable(product));
                    product.click();
                    return;
                }
            }
            throw new RuntimeException("Producto '" + productName + "' no encontrado en la página de inicio.");
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el producto '" + productName + "' en la página de inicio.", e);
        }
    }
}