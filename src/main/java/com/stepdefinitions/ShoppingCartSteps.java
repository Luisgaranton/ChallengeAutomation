package com.stepdefinitions;

import com.pages.LoginPage;
import com.pages.ShoppingCartPage;
import com.hooks.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShoppingCartSteps {

    private final WebDriver driver;
    private final ShoppingCartPage shoppingCartPage;
    private final LoginPage loginPage;

    public ShoppingCartSteps(BaseTest baseTest) {
        this.driver = baseTest.getDriver();
        this.shoppingCartPage = new ShoppingCartPage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Given("el usuario está logueado en la página de Swag Labs")
    public void elUsuarioEstaLogueadoEnLaPaginaDeSwagLabs() {
        loginPage.goToPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isRedirectedToHomePage(), "El usuario no pudo iniciar sesión correctamente.");
    }

    @Given("el usuario ha agregado el producto Sauce Labs Backpack al carrito")
    public void elUsuarioHaAgregadoElProductoSauceLabsBackpackAlCarrito() {
        shoppingCartPage.addSauceLabsBackpack();
        Assert.assertEquals(shoppingCartPage.getCartItemCount(), 1, "El producto Sauce Labs Backpack no fue agregado correctamente.");
    }

    @Given("el usuario ha agregado los productos Sauce Labs Backpack y Sauce Labs Bike Light al carrito")
    public void elUsuarioHaAgregadoLosProductosSauceLabsBackpackYSauceLabsBikeLightAlCarrito() {
        shoppingCartPage.addSauceLabsBackpack();
        shoppingCartPage.addSauceLabsBikeLight();
        Assert.assertEquals(shoppingCartPage.getCartItemCount(), 2, "Los productos no fueron agregados correctamente.");
    }

    @When("el usuario elimina el producto Sauce Labs Backpack del carrito")
    public void elUsuarioEliminaElProductoSauceLabsBackpackDelCarrito() {
        shoppingCartPage.removeSauceLabsBackpack();
        Assert.assertEquals(shoppingCartPage.getCartItemCount(), 0, "El producto Sauce Labs Backpack no fue eliminado correctamente.");
    }

    @When("el usuario hace clic en {string} para proceder al pago")
    public void elUsuarioHaceClicEnParaProcederAlPago(String buttonName) {
        shoppingCartPage.clickCheckoutButton();
    }

    @Then("el usuario debería ser redirigido a la página de pago")
    public void elUsuarioDeberiaSerRedirigidoALaPaginaDePago() {
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "El usuario no fue redirigido a la página de pago.");
    }

    @Then("el carrito debería estar vacío")
    public void elCarritoDeberiaEstarVacio() {
        int itemCount = shoppingCartPage.getCartItemCount();
        Assert.assertEquals(itemCount, 0, "El carrito no está vacío.");
    }

    @Then("el total del carrito debería ser la suma de los precios de los productos agregados")
    public void elTotalDelCarritoDeberiaSerLaSumaDeLosPreciosDeLosProductosAgregados() {
        double calculatedTotal = shoppingCartPage.calculateTotalPrice();
        double displayedTotal = shoppingCartPage.getDisplayedCartTotal();
        Assert.assertEquals(calculatedTotal, displayedTotal, "El total del carrito no coincide con la suma de los precios de los productos.");
    }

    @Then("no debe haber cargos adicionales ni erróneos")
    public void noDebeHaberCargosAdicionalesNiErroneos() {
        Assert.assertTrue(shoppingCartPage.areChargesAccurate(), "Se encontraron cargos adicionales o erróneos.");
    }

    @When("el usuario navega al carrito")
    public void elUsuarioNavegaAlCarrito() {
        shoppingCartPage.clickCartIcon();
    }

    @Then("el precio del producto debería ser el correcto")
    public void elPrecioDelProductoDeberiaSerElCorrecto() {
        boolean isPriceCorrect = shoppingCartPage.isPriceCorrect("29.99");
        Assert.assertTrue(isPriceCorrect, "El precio del producto no es el correcto.");
    }

    @Then("los productos en el carrito deberían estar listados en la página de pago")
    public void losProductosEnElCarritoDeberianEstarListadosEnLaPaginaDePago() {
        boolean areProductsListed = shoppingCartPage.areProductsListedOnCheckout();
        Assert.assertTrue(areProductsListed, "Los productos no están listados correctamente en la página de pago.");
    }

    @Then("los campos para ingresar los datos del usuario deberían estar habilitados")
    public void losCamposParaIngresarLosDatosDelUsuarioDeberianEstarHabilitados() {
        boolean areFieldsEnabled = shoppingCartPage.areCheckoutFieldsEnabled();
        Assert.assertTrue(areFieldsEnabled, "Los campos para ingresar los datos del usuario no están habilitados.");
    }

    @Then("los precios de los productos en el carrito deberían ser correctos")
    public void losPreciosDeLosProductosEnElCarritoDeberianSerCorrectos() {
        boolean arePricesCorrect = shoppingCartPage.areProductPricesCorrect();
        Assert.assertTrue(arePricesCorrect, "Los precios de los productos en el carrito no son correctos.");
    }

    @Then("el número de artículos en el carrito debería ser 0")
    public void elNumeroDeArticulosEnElCarritoDeberiaSerCero() {
        int itemCount = shoppingCartPage.getCartItemCount();
        Assert.assertEquals(itemCount, 0, "El número de artículos en el carrito no es 0 como se esperaba.");
    }

    @Then("el número de artículos en el carrito debería ser 1")
    public void elNumeroDeArticulosEnElCarritoDeberiaSerUno() {
        int itemCount = shoppingCartPage.getCartItemCount();
        Assert.assertEquals(itemCount, 1, "El número de artículos en el carrito no es 1 como se esperaba.");
    }
}