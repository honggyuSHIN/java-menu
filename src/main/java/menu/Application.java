package menu;

import menu.controller.PersonController;
import menu.service.MenuService;

public class Application {
    public static void main(String[] args) {
        MenuService saveMenuService = new MenuService();

        PersonController personController = new PersonController(saveMenuService);
        personController.run();
    }
}
