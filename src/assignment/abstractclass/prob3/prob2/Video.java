package assignment.abstractclass.prob3.prob2;

public class Video extends Content{
    private String genre;

    Video() {

    }
    public Video(String title, String genre) {
        super(title);
        setGenre(genre);
        totalPrice();
        show();
    }

    @Override
    void totalPrice() {
        switch (genre) {
            case "new" -> setPrice(2000);
            case "comic" -> setPrice(1500);
            case "child" -> setPrice(1000);
            default -> setPrice(500);
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
