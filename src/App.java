import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Fazer comunicação HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        var client = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        // pegar só os dados que interessam (titulo, poster, classificação, ano)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaFilmes = parser.parse(body);

        // exibir e manipular os dados
        var generator = new StickerGenerator();
        for (Map<String, String> filme : listaFilmes) {
            String imageUrl = filme.get("image");
            String title = filme.get("title");
            String outputImageFileName = title + ".jpg";

            try {
                var inputStream = new URL(imageUrl).openStream();
                generator.create(inputStream, outputImageFileName);
            } catch (Exception e) {
                System.out.println("Erro ao gerar sticker para o filme " + title);
            }
            System.out.println(title);
            System.out.println("---------------------------------");
        }

    }
}
