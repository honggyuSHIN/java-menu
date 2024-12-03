package menu.view;

import menu.model.Menus;
import menu.model.People;
import menu.model.Person;

import java.util.List;

public class OutputView {
    public static void printMenu(Menus menus) {
        for (int i = 0; i < menus.getMenus().size(); i++) {
            System.out.println(menus.getMenus().get(i).getMenuCountry());
            for (int j = 0; j < menus.getMenus().get(i).getMenuNames().length; j++) {
                System.out.print(menus.getMenus().get(i).getMenuNames()[j]+" ");
            }
            System.out.println();
        }
    }

    public static void printPeople(People people) {
        for (int i = 0; i < people.getPeople().size(); i++) {
            System.out.println(people.getPeople().get(i).getPersonName());
            for (int j = 0; j < people.getPeople().get(i).getCantFoods().length; j++) {
                System.out.print(people.getPeople().get(i).getCantFoods()[j]+" ");
            }
            System.out.println();
        }
    }

    public static void result(People people, List<String> category) {
        System.out.println("메뉴 추천 결과입니다.\n" + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
//        [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
        System.out.print("[ 카테고리 ");
        for(String name : category) {
            System.out.print(" | " + name);
        }
        System.out.print(" ]");
        System.out.println();

        for (Person person : people.getPeople()) {
            System.out.print(person.getPersonName());
            for (int i = 0; i < category.size(); i++) {
                System.out.print(" | " + person.getCantFoods()[i]);
            }
            System.out.println();
        }
        System.out.println("추천을 완료했습니다.");
    }
}
