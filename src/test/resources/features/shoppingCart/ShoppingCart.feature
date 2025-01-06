# Archivo: shoppingCart.feature
@TestNG
Feature: Verificación del Carrito de Compras en Swag Labs

  Background:
    Given el usuario está logueado en la página de Swag Labs

  @Shopping @CART_001
  Scenario: Agregar Producto al Carrito de Compras
    Given el usuario ha agregado el producto Sauce Labs Backpack al carrito
    Then el número de artículos en el carrito debería ser 1

  @Shopping @CART_002
  Scenario: Verificar Productos en el Carrito de Compras
    Given el usuario ha agregado el producto Sauce Labs Backpack al carrito
    When el usuario navega al carrito
    Then el número de artículos en el carrito debería ser 1
    And el precio del producto debería ser el correcto

  @Shopping @CART_003
  Scenario: Eliminar Producto del Carrito de Compras
    Given el usuario ha agregado el producto Sauce Labs Backpack al carrito
    When el usuario elimina el producto Sauce Labs Backpack del carrito
    Then el carrito debería estar vacío
    And el número de artículos en el carrito debería ser 0

  @Shopping @CART_004
  Scenario: Verificar Precios de los Productos en el Carrito
    Given el usuario ha agregado los productos Sauce Labs Backpack y Sauce Labs Bike Light al carrito
    When el usuario navega al carrito
    Then los precios de los productos en el carrito deberían ser correctos

  @Shopping @CART_005
  Scenario: Proceder al Pago desde el Carrito de Compras
    Given el usuario ha agregado el producto Sauce Labs Backpack al carrito
    When el usuario hace clic en "Checkout" para proceder al pago
    Then el usuario debería ser redirigido a la página de pago
    And los campos para ingresar los datos del usuario deberían estar habilitados
