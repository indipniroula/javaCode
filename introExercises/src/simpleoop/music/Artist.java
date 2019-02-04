package simpleoop.music;

import java.util.ArrayList;
import java.util.List;

public class Artist {
   private String name;
   private List<Record> catalogue = new ArrayList<>();
   private Record.Genre mainGenre;

   public Artist(String name, List<Record> catalogue, Record.Genre mainGenre){
       this.name = name;
       this.catalogue = catalogue;
       this.mainGenre = mainGenre;
   }
   public void addRecord(String name) {
       catalogue.add(new Record(name, mainGenre));
   }

   public void addRecord(String name, Record.Genre genre) {
       catalogue.add(new Record(name, genre));
   }

   public void showCatalogue() {
       System.out.println(catalogue.toString());
   }

   public void showGenre(Record.Genre genre) {
       for (Record record: catalogue) {
           if (record.getGenre().equals(genre)) {
               System.out.print(record.toString());
               System.out.println();
           }
       }
   }




}
