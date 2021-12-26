package hello.core.singleton;

public class Menu {
    private String name;
    private static final Menu instance = new Menu();

    private Menu(){

    }

    public static Menu getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;

    }
}

