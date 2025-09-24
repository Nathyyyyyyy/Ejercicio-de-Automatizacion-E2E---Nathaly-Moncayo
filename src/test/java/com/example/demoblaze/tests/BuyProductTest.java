package com.example.demoblaze.tests;

import com.example.demoblaze.pageobjects.CartPage;
import com.example.demoblaze.pageobjects.CheckoutPage;
import com.example.demoblaze.pageobjects.HomePage;
import com.example.demoblaze.pageobjects.ProductPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@ExtendWith(SerenityJUnit5Extension.class)
public class BuyProductTest {

    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    private void aceptarAlertaSiExiste() {
        try {
            new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.alertIsPresent());
            Serenity.getDriver().switchTo().alert().accept();
            // Esperar a que la alerta desaparezca
            new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(5))
                    .until(driver -> {
                        try {
                            driver.switchTo().alert();
                            return false;
                        } catch (NoAlertPresentException e) {
                            return true;
                        }
                    });
        } catch (Exception ignored) {}
    }

    @Test
    public void buy_a_product() {
        homePage.open();
        // Agregar primer producto
        homePage.openProductByName("Samsung galaxy s6");
        productPage.addToCart();
        aceptarAlertaSiExiste();
        // Regresar al home antes de buscar el segundo producto
        homePage.open();

        // Agregar segundo producto
        homePage.openProductByName("Nokia lumia 1520");
        productPage.addToCart();
        aceptarAlertaSiExiste();

        // Ir al carrito y realizar la compra
        Serenity.getDriver().get("https://www.demoblaze.com/cart.html");
        cartPage.placeOrder();
        checkoutPage.fillForm("Nathaly Moncayo", "Ecuador", "Quito", "1234567890", "12", "2025");
        checkoutPage.purchase();
    }
}
