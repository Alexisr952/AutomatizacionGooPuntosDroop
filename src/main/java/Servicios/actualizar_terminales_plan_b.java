package Servicios;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class actualizar_terminales_plan_b {

    public String Actualizar_terminales(Boolean estado) throws IOException {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        String json =
                "{\n" +
                        "    \"estado\": " + estado + "\n" +
                        "}";
        RequestBody body = RequestBody.create(json, JSON);
        System.out.println(json);
        Request request = new Request.Builder()
                .url("https://goo-recogidas.coordinadora.com/goo-app/cm-recogidas-planb-op/actualizar-terminales")
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }
}
