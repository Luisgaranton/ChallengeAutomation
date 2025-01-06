package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {

    private WebDriver driver;

    private final By addSauceLabsBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeSauceLabsBackpackButton = By.id("remove-sauce-labs-backpack");
    private final By addSauceLabsBikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");

    private final By cartIcon = By.id("shopping_cart_container");
    private final By itemPriceLocator = By.className("inventory_item_price");
    private final By cartTotalLocator = By.className("summary_total_label");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addSauceLabsBackpack() {
        driver.findElement(addSauceLabsBackpackButton).click();
    }

    public void addSauceLabsBikeLight() {
        driver.findElement(addSauceLabsBikeLightButton).click();
    }

    public void removeSauceLabsBackpack() {
        driver.findElement(removeSauceLabsBackpackButton).click();
    }

    // Métodos adicionales
    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public boolean areChargesAccurate() {
        clickCartIcon();
        double calculatedTotal = calculateTotalPrice();
        double displayedTotal = getDisplayedCartTotal();
        return calculatedTotal == displayedTotal;
    }

    public boolean isPriceCorrect(String productPrice) {
        By productPriceLocator = By.xpath("//div[text()='" + productPrice +"']");
        WebElement priceElement = driver.findElement(productPriceLocator);
        return priceElement != null && !priceElement.getText().isEmpty();
    }

    public boolean areProductsListedOnCheckout() {
        clickCartIcon();
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        return cartItems.size() > 0; // Verifica que haya productos en el carrito
    }

    public boolean areCheckoutFieldsEnabled() {
        By firstNameField = By.id("first-name");
        By lastNameField = By.id("last-name");
        By postalCodeField = By.id("postal-code");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));

        return driver.findElement(firstNameField).isEnabled()
                && driver.findElement(lastNameField).isEnabled()
                && driver.findElement(postalCodeField).isEnabled();
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        List<WebElement> prices = driver.findElements(itemPriceLocator);
        for (WebElement priceElement : prices) {
            String priceText = priceElement.getText().replace("$", "").trim();
            total += Double.parseDouble(priceText);
        }
        return total;
    }

    public double getDisplayedCartTotal() {
        String totalText = driver.findElement(cartTotalLocator).getText().replace("Total: $", "").trim();
        return Double.parseDouble(totalText);
    }

    public void clickCheckoutButton() {
        By checkoutButton = By.id("checkout");
        driver.findElement(checkoutButton).click();
    }

    public int getCartItemCount() {
        clickCartIcon();
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        return cartItems.size();
    }

    public boolean areProductPricesCorrect() {
        clickCartIcon();
        List<WebElement> itemPrices = driver.findElements(itemPriceLocator);

        for (WebElement priceElement : itemPrices) {
            if (priceElement.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}