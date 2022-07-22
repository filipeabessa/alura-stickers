import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {
    public List<Content> extractContent(String json) {
        // extrair só os dados relevantes do JSON
        JsonParser parser = new JsonParser();
        List<Map<String, String>> contentsAttributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> attributes : contentsAttributesList) {
            String title = attributes.get("title");
            String imageUrl = attributes.get("url");
            var content = new Content(title, imageUrl);
            contents.add(content);
        }

        return contents;
    }
}
