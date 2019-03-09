package simpleoop.lecturesoop.documentmanager;

import java.util.List;

public class Menu implements PageElement {
    private final int width;
    private final int height;
    private final String id;
    private final List<String> options;

    public Menu(int width, int height, String id, List<String> options) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.options = options;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getId() {
        return id;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public List<String> getOptions() {
        return options;
    }
}
