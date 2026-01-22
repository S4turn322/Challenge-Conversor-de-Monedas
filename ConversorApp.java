import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {

    public Moneda conversorDeMoneda(int cantidad,
                                          String monedaBase,
                                          String monedaDestino){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6f3fc414cd0a6ebf9bb1f233/pair/"+
                        monedaBase+"/"+
                        monedaDestino+"/"+
                        cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("Error al convertir moneda");
        }

    }

}
