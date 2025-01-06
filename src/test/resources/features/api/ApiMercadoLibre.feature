# Archivo: Api.feature
@TestNG
Feature: Verificaci0n de servicios web en Mercado Libre

  @Api @TC-API-001
  Scenario: Validar que la API de Mercado Libre contenga departamentos
    Given el usuario realiza una solicitud GET al servicio de departamentos
    Then la respuesta debe contener una lista de departamentos