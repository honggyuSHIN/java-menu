package menu.model;

public class Menu {
    private final String menuCountry;
    private final String[] menuNames;

    public Menu(String menuCountry, String[] menuNames) {
        this.menuCountry = menuCountry;
        this.menuNames = menuNames;
    }

    public String getMenuCountry() {
        return menuCountry;
    }

    public String[] getMenuNames() {
        return menuNames;
    }
}
