import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Fazer comunicação HTTP e buscar os top 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";
        var client = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        HttpRequest build = HttpRequest.newBuilder(endereco).GET().build();
        // pegar só os dados que interessam (titulo, poster, classificação, ano)

        // exibir e manipular os dados

    }
}
