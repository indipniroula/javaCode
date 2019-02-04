package simpleoop.music;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Record record1 = new Record("Weeknd", Record.Genre.Pop);
        Record record2 = new Record("Hello", Record.Genre.Pop);
        List<Record> catalog = new ArrayList<>(Arrays.asList(record1, record2));
        Artist artist = new Artist("Weeknd", catalog, Record.Genre.Pop);
        artist.showGenre(Record.Genre.Pop);
    }
}
