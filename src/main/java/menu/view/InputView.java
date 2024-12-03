package menu.view;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static String getCoachNames() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n" +
                "코치의 이름을 입력해 주세요. (, 로 구분)");
        Scanner scanner = new Scanner(System.in);
        String coachNames = scanner.nextLine();
        return coachNames;
    }

    public static List<String[]> getCantFood(String[] coachNames) {
        List<String[]> cantFoods = new ArrayList<>();
        for (String coachName : coachNames) {
            System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            Scanner scanner = new Scanner(System.in);
            String cantFood = scanner.nextLine();
            cantFoods.add(cantFood.split(","));
        }
        return cantFoods;
    }
}
