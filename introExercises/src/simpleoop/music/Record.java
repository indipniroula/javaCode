package simpleoop.music;

public class Record {
    private String title;
    public enum Genre {
        Rock,
        Pop,
        Jazz
    }
    private Genre genre;

    public Record(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return ("Title: " + title + ", Genre: " + genre);
    }
}
