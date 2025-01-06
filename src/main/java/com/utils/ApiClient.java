package com.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ApiClient {

    private static final String BASE_URL = "https://www.mercadolibre.com.ar";
    private final OkHttpClient client;

    public ApiClient() {
        this.client = new OkHttpClient();
    }

    // Metodo para obtener los departamentos
    public String getDepartments() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/menu/departments")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error en la solicitud: Código HTTP " + response.code());
            }
            return response.body().string();
        }
    }
}