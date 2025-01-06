# Archivo: login.feature
@TestNG
Feature: Validación del inicio de sesión
  Background:
    Given el usuario está en la página de login

  @Login @LOGIN_001
  Scenario: Inicio de sesión exitoso
    When el usuario ingresa el nombre de usuario "standard_user"
    And el usuario ingresa la contraseña "secret_sauce"
    And el usuario hace clic en el botón de login
    Then el usuario debería ser redirigido a la página de inicio
  @Login @LOGIN_002
  Scenario: Inicio de sesión fallido (Para probar las capturas de pantalla)
    When el usuario ingresa el nombre de usuario "(==(&%#$#%"
    And el usuario ingresa la contraseña "23233/(//("
    And el usuario hace clic en el botón de login
    Then el usuario debería ser redirigido a la página de inicio
  @Login @LOGIN_003
  Scenario: Inicio de sesión con contraseña incorrecta
    When el usuario ingresa el nombre de usuario "standard_user"
    And el usuario ingresa la contraseña "wrong_password"
    And el usuario hace clic en el botón de login
    Then el usuario debería ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"
  @Login @LOGIN_004
  Scenario: Inicio de sesión con nombre de usuario incorrecto
    When el usuario ingresa el nombre de usuario "wrong_user"
    And el usuario ingresa la contraseña "secret_sauce"
    And el usuario hace clic en el botón de login
    Then el usuario debería ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"
  @Login @LOGIN_005
  Scenario: Inicio de sesión sin ingresar credenciales
    When el usuario ingresa el nombre de usuario ""
    And el usuario ingresa la contraseña ""
    And el usuario hace clic en el botón de login
    Then el usuario debería ver el mensaje de error "Epic sadface: Username is required"