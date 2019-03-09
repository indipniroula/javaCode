package simpleoop.lecturesoop.documentmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PageElement a = new Menu(10, 20, "Menu", new ArrayList<>(Arrays.asList("Hello", "Hi")));
        // Apparent type PageElement, actual type Menu.
        // Menu has methods such as addOption, getOptions - they are extra and specific to Menu, not in PageElement.
        //But can't access these methods - because of apparent type.
        // Need to downcast PageElement in order to access the methods.
        // Downcast - so may need to check if safe to downcast.
        // e.g ((Menu) a).addOption();


    }



}
