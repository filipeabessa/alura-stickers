import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Fazer comunicação HTTP e buscar os top 250 filmes
        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";

        var clientHttp = new ClientHttp();
        String json = clientHttp.searchData(url);

        // exibir e manipular os dados
        NasaContentExtractor nasaContentStractor = new NasaContentExtractor();
        List<Content> contents = nasaContentStractor.extractContent(json);

        var generator = new StickerGenerator();
        for (int i = 0; i < contents.size(); i++) {
            Content content = contents.get(i);
            String imageUrl = content.getUrlImage();
            String title = content.getTitle();

            var inputStream = new URL(imageUrl).openStream();
            String outputImageFileName = title + ".png";
            generator.create(inputStream, outputImageFileName);

            System.out.println(title);
            System.out.println();
        }

    }
}
