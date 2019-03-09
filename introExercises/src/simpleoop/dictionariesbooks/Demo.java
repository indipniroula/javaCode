package simpleoop.dictionariesbooks;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Book b1 = new Book("d", "d", 10);
        Book b2 = new Book("d", "d", 12);
        Book b3 = new Book("d", "d", 130);
        Book b4 = new Book("d", "d", 103);
        Dictionary d1 = new Dictionary("d", "d,", 1, "a", "a", 10);
        Dictionary d2 = new Dictionary("d", "d,", 2, "a", "a", 10);

        Bookshelf bookshelf = new Bookshelf();
        bookshelf.printLeftToRight();
        System.out.println();
        bookshelf.printRightToLeft();

        rearrange(bookshelf);
        System.out.println();
        bookshelf.printLeftToRight();
    }

    public static void rearrange(Bookshelf b1) {

    }
}
