package simpleoop.references;

import java.util.HashSet;
import java.util.Set;

public class PrintBook {

    public static void main(String[] args) {

        Set<Book> set = new HashSet<Book>();

        Book book = new Book(1, "C++");

        set.add(book);

        set.add(new Book(2, "C++"));
        set.add(new Book(1, "Haskell"));
        /* Book "Haskell" same isbn - so same object
        as Book(1, "C++"). Won't get added to set, because
        of what a set is - no duplicates.
        This is because override the methods equals, hashCode
        in Book class.
        */
        book.setTitle("New C++ book");

        for (Book b : set) {
            System.out.println(b);
        }

    }
}

