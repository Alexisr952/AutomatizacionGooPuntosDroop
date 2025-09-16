package Servicios;

import org.json.JSONObject;
import okhttp3.*;
import java.io.IOException;

public class actualizar_recaudo_offline {


    public String Actualizar_Recaudo(String terminal,String habilitado) throws IOException {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        String json=
                     "{\n" +
                             "    \"terminal\": \""+terminal+"\",\n" +
                             "    \"habilitado\": \""+habilitado+"\"\n" +
                     "}";
        RequestBody body = RequestBody.create(json,JSON);
        System.out.println(json);
        Request request = new Request.Builder()
                .url("https://us-central1-cm-tim-goo-test.cloudfunctions.net/recaudoOffline/actualizar-recaudo-offline")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }

}
