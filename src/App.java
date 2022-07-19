import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        // Fazer comunicação HTTP e buscar os top 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";
        var client = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        // pegar só os dados que interessam (titulo, poster, classificação, ano)

        // exibir e manipular os dados

    }
}
