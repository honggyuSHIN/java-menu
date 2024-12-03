package menu.model;

import java.util.List;

public class Menus {

    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public void saveMenu(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Menu getSameMenu(String menuName) {
        for (Menu menu : menus) {
            if (menu.getMenuCountry().equals(menuName)) {
                return menu;
            }
        }
        return null;
    }
}
