package menu.controller;

import menu.model.Menu;
import menu.model.Menus;
import menu.model.People;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private final MenuService menuService;


    public PersonController(MenuService saveMenuService) {
        this.menuService = saveMenuService;
    }

    public void run() {
//        한식 : 비빔밥, 김밥, ...
        Menus menus = saveMenu();
//        감독 이름 : 신홍규, 김민수, ...
        People people = getCoachNames();

        makeCategory(menus, people);
    }

    public Menus saveMenu() {
        List<Menu> menusInput = new ArrayList<>();
        Menus menus = menuService.saveMenu(menusInput);
//        OutputView.printMenu(menus);
        return menus;
    }

    public People getCoachNames() {
        String coachNames = InputView.getCoachNames();
        String[] manyCoachNames = coachNames.split(",");

        List<String[]> cantFoods = InputView.getCantFood(manyCoachNames);
        People people = menuService.saveCantFoods(manyCoachNames, cantFoods);
//        OutputView.printPeople(people);
        return people;
    }

    public void makeCategory(Menus menus, People people) {
        while (true) {
//            5일 식사 카테고리(한식, 일식 ...)
            List<String> category = menuService.makeCategory();
            boolean checkRepeat = menuService.checkCategory(category);
            if(checkRepeat) {
//                true : 검증 통과
                People peopleForAnswer = menuService.makeMenu(menus, category, people);
                boolean checkHateMenu = menuService.checkHateMenu(peopleForAnswer, people);
                boolean checkMenuRepeat = menuService.checkMenuRepeat(peopleForAnswer);
//                OutputView.printPeople(peopleForAnswer);

                if(checkHateMenu && checkMenuRepeat) {
                    OutputView.result(peopleForAnswer, category);
                    break;
                }

            }
            break;
        }


    }
}
