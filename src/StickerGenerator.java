import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
    public void create(InputStream inputStream, String outputFileName) throws IOException {
        // leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("input/sticker.jpg"));
        // InputStream inputStream = new URL(
        // "https://m.media-amazon.com/images/M/MV5BOTJiNDEzOWYtMTVjOC00ZjlmLWE0NGMtZmE1OWVmZDQ2OWJhXkEyXkFqcGdeQXVyNTIzOTk5ODM@.jpg")
        // .openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);

        // cria nova imagem com transparencia e com tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // configurar fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(font);

        // escrever uma frase na nova imagem

        graphics.drawString("TESTE", (width / 2) - 100, newHeight - 100);

        // escrever a imagem nova em um arquivo

        ImageIO.write(newImage, "png", new File("output/" + outputFileName));
    }
}
