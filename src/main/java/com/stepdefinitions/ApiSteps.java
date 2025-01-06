package com.stepdefinitions;

import com.utils.ApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

public class ApiSteps {

    private final ApiClient apiClient;
    private String responseBody;

    public ApiSteps() {
        this.apiClient = new ApiClient();
    }

    @Given("el usuario realiza una solicitud GET al servicio de departamentos")
    public void elUsuarioRealizaUnaSolicitudGETAlServicioDeDepartamentos() {
        try {
            responseBody = apiClient.getDepartments();
            Assert.assertNotNull(responseBody, "La respuesta del servicio no es nula.");
        } catch (Exception e) {
            Assert.fail("Error al realizar la solicitud: " + e.getMessage());
        }
    }

    @Then("la respuesta debe contener una lista de departamentos")
    public void laRespuestaDebeContenerUnaListaDeDepartamentos() {
        try {
            JSONObject jsonResponse = new JSONObject(responseBody);

            JSONArray departments = jsonResponse.getJSONArray("departments");
            Assert.assertNotNull(departments, "La lista de departamentos es nula.");
            Assert.assertFalse(departments.isEmpty(), "No se encontraron departamentos en la respuesta.");

            for (int i = 0; i < departments.length(); i++) {
                JSONObject department = departments.getJSONObject(i);
                Assert.assertTrue(department.has("name"), "El departamento no tiene un campo 'name'.");
                Assert.assertFalse(department.getString("name").isEmpty(), "El campo 'name' está vacío.");
            }

        } catch (Exception e) {
            Assert.fail("Error al procesar la respuesta: " + e.getMessage());
        }
    }
}