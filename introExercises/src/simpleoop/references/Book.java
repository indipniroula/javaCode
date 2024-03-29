package simpleoop.references;

public class Book {

    private int isbn;
    private String title;

    Book(int isbn, String title) {
        this.isbn = isbn;
        setTitle(title);
    }

    void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            return isbn == ((Book) obj).isbn;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return isbn;
    }

    //equals and hasCode - combine to give 'identity' of object
    // so any Books with same isbn number seen as same object (reference)
    // if overriding equals - always override hashCode

    @Override
    public String toString() {
        return title + "(ISBN: " + isbn + ")";
    }

}
