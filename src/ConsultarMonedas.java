import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMonedas {
    MonedasApi convertir(String monedas1, String monedas2, int cantidad) {
        String TuApi="*********"; // Consiga su api en este link https://www.exchangerate-api.com/
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+TuApi+"/pair/"+monedas1+"/"+monedas2+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedasApi.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo Convertir");
        }
    }
}
