package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private static final String PAGE_URL = "https://www.saucedemo.com/";
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public boolean isRedirectedToHomePage() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        try {
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.urlToBe(expectedUrl));
            Thread.sleep(1000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void goToPage() {
        driver.get(PAGE_URL);
        waitForElementToBeVisible(usernameField, "El campo de username no está visible en la página de login.");
        try {
            Thread.sleep(1000); // Pausa de 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterUsername(String username) {
        typeText(usernameField, username);
    }

    public void enterPassword(String password) {
        typeText(passwordField, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton, "El botón de login no es clickeable.");
    }

    // Validaciones
    public boolean isLoginButtonVisible() {
        return isElementVisible(loginButton, "El botón de login no está visible.");
    }

    public boolean isErrorDisplayed(String errorMessage) {
        By errorLocator = By.xpath("//h3[contains(text(),'" + errorMessage + "')]");
        return isElementVisible(errorLocator, "El mensaje de error no es visible: " + errorMessage);
    }

    // Métodos utilitarios
    private void typeText(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator, "No se pudo encontrar el campo para escribir.");
        element.clear();
        element.sendKeys(text);
        // Pausa opcional después de escribir para observar el comportamiento
        try {
            Thread.sleep(500); // Pausa de 500ms (opcional)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clickElement(By locator, String errorMessage) {
        WebElement element = waitForElementToBeClickable(locator, errorMessage);
        element.click();
        // Pausa opcional después del clic para observar el comportamiento
        try {
            Thread.sleep(1000); // Pausa de 1 segundo (opcional)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isElementVisible(By locator, String errorMessage) {
        try {
            waitForElementToBeVisible(locator, errorMessage);
            // Pausa opcional para observar el elemento visible
            Thread.sleep(500); // Pausa de 500ms (opcional)
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private WebElement waitForElementToBeVisible(By locator, String errorMessage) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .withMessage(errorMessage)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForElementToBeClickable(By locator, String errorMessage) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .withMessage(errorMessage)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}