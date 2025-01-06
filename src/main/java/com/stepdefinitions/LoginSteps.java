package com.stepdefinitions;

import com.pages.LoginPage;
import com.hooks.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private final WebDriver driver;
    private final LoginPage loginPage;

    public LoginSteps(BaseTest baseTest) {
        this.driver = baseTest.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("el usuario está en la página de login")
    public void elUsuarioEstaEnLaPaginaDeLogin() {
        loginPage.goToPage();
    }

    @When("el usuario ingresa el nombre de usuario {string}")
    public void elUsuarioIngresaElNombreDeUsuario(String username) {
        loginPage.enterUsername(username);
    }

    @When("el usuario ingresa la contraseña {string}")
    public void elUsuarioIngresaLaContrasena(String password) {
        loginPage.enterPassword(password);
    }

    @When("el usuario hace clic en el botón de login")
    public void elUsuarioHaceClicEnElBotonDeLogin() {
        loginPage.isLoginButtonVisible();
        loginPage.clickLoginButton();
    }

    @Then("el usuario debería ver el mensaje de error {string}")
    public void elUsuarioDeberiaVerElMensajeDeError(String expectedErrorMessage) {
        boolean isErrorDisplayed = loginPage.isErrorDisplayed(expectedErrorMessage);
        Assert.assertTrue(isErrorDisplayed, "El mensaje de error no se muestra correctamente.");
    }

    @Then("el usuario debería ser redirigido a la página de inicio")
    public void elUsuarioDeberiaSerRedirigidoALaPaginaDeInicioError() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "El usuario no fue redirigido a la página de inicio.");
    }
}