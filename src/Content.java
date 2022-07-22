public class Content {
    private final String title;
    private final String urlImage;

    public Content(String title, String imageUrl) {
        this.title = title;
        this.urlImage = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImage() {
        return urlImage;
    }

}
