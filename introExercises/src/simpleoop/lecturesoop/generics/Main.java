package simpleoop.lecturesoop.generics;

public class Main {
    public static void main(String[] args) {
        Pair stringAndInteger = new Pair("Hello", 4); //Implicit upcasting - no issues.
        //Here need to insert downcasts as "Hello" is an Object due to typing of Pair, not a string.
        String s = (String) stringAndInteger.getFirst();
        // If you wanna access string methods - also gotta cast. But better to create variable to cast once.
        // rather than casting everytime.
        System.out.println(((String) stringAndInteger.getFirst()).charAt(1));

        GenericPair<String, Integer> genericPair = new GenericPair<>("hello", 4);
        String s1 = genericPair.getFirst(); //No downcasts required.
        System.out.println(s1);


    }

}
