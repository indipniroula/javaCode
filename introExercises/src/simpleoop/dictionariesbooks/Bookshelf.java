package simpleoop.dictionariesbooks;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Bookshelf {
    private List<Book> books;

    public Bookshelf() {
        books = new LinkedList<>();
    }

    public int size() {
        return books.size();
    }

    public void addBookOnLeftSide(Book b) {
        books.add(0, b);
    }

    public void addOnRight(Book b) {
        books.add(b);
    }

    public void addBook(int i, Book b) {
        books.add(i, b);
    }

    public Book remove(int i) {
        return books.remove(i);
    }

    public void printLeftToRight() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printRightToLeft() {
        for (int i = books.size() - 1; i >= 0; i--) {
            System.out.println(books.get(i));
        }

        //Alternative
        ListIterator<Book> it = books.listIterator(books.size());
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }
}
