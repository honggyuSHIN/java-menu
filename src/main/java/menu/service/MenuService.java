package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Menu;
import menu.model.Menus;
import menu.model.People;
import menu.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MenuService {

    public Menus saveMenu(List<Menu> menusInput) {
        String[] menuCountries = {"일식", "한식", "중식", "아시안", "양식"};
        String[][] menuNames = {
                {"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"},
                {"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"},
                {"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"},
                {"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"},
                {"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"}
        };
        Menus menus = new Menus(menusInput);

        for (int i = 0; i < 5; i++) {
            String menuCountry = menuCountries[i];
            Menu menu = new Menu(menuCountry, menuNames[i]);
            menus.saveMenu(menu);
        }
        return menus;
    }

    public List<String> makeCategory02() {
        List<String> candidate = Arrays.asList("일식", "한식", "중식", "아시안", "양식");
        List<String> category = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String firstCategory = Randoms.shuffle(candidate).get(0);
            category.add(firstCategory);
        }
        return category;
    }

    public List<String> makeCategory() {
        List<String> candidate = Arrays.asList("일식", "한식", "중식", "아시안", "양식");

        candidate.add(0,"");

        List<String> category = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String firstCategory = candidate.get(Randoms.pickNumberInRange(1,5));
            category.add(firstCategory);
        }
        return category;
    }

    public boolean checkCategory(List<String> category) {
        for(String name : category) {
        }
        for (String categoryItem : category) {
            if (Collections.frequency(category, categoryItem) >= 3) {
                return false;
            }
        }
        return true;
    }

    public People saveCantFoods(String[] coachNames, List<String[]> cantFoods) {
        List<Person> person = new ArrayList<>();

        People people = new People(person);

        for(int i=0; i<coachNames.length; i++) {
            people.savePerson(new Person(coachNames[i], cantFoods.get(i)));
        }
        return people;
    }

    public People makeMenu(Menus menus, List<String> category, People people) {
//        menus : 각 나라에 대한 음식 저장
//        category : 5일간의 식사 카테고리
//        people : 감독 이름과 싫어하는 음식 저장

        List<Person> peopleForAnswer = new ArrayList<>();

        for (Person person : people.getPeople()) {
            String coachName = person.getPersonName();
            String[] eatFoods = new String[5];
            Person personForAnswer = chooseEatMenu(menus, category, person);
//            사람 이름 : 메뉴 5개 목록을 반환받음
            peopleForAnswer.add(personForAnswer);
        }
        People temp = new People(peopleForAnswer);


        return temp;

    }

    private Person chooseEatMenu(Menus menus, List<String> category, Person person) {
//        전체 메뉴 저장된 menus
//        5일 카테고리인 category
//        감독 이름과 싫어하는 음식 저장된 person
//        반환을 위해 객체 생성
        List<String> eatFoods = new ArrayList<>();
        String name = person.getPersonName();
        for (String categoryMenu : category) {
            Menu sameMenu = menus.getSameMenu(categoryMenu);
            String[] sameMenus = sameMenu.getMenuNames();
//                그 요일에 맞는 요리 목록 가져옴
            String menu = Randoms.shuffle(Arrays.asList(sameMenus)).get(0);
            eatFoods.add(menu);
        }

        return new Person(name, eatFoods.toArray(new String[0]));

    }

    public boolean checkHateMenu(People peopleForAnswer, People people) {
//        people에서 싫어하는 음식 꺼내서 ForAnswer와 대조하기
//        선택한 음식 5개 중에서 싫어하는 음식 확인
        for (int i = 0; i < people.getPeople().size(); i++) {
            return checkFood(peopleForAnswer.getPeople().get(i), people.getPeople().get(i));
        }
        return false;
    }

    private boolean checkFood(Person person, Person person1) {
        String[] candidateFoods = person.getCantFoods();
        String[] cantFoods = person1.getCantFoods();
        for (String candidateFood : candidateFoods) {
            for (String cantFood : cantFoods) {
                if (candidateFood.equals(cantFood)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkHateFood(Person person, Person person1) {
        String[] eatFoods = person.getCantFoods();
        String[] cantFoods = person1.getCantFoods();
        for (String eatFood : eatFoods) {
            for (String cantFood : cantFoods) {
                if (eatFood.equals(cantFood)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkMenuRepeat(People peopleForAnswer) {


        for (Person person : peopleForAnswer.getPeople()) {

            List<String> eatFoods = new ArrayList<>();


            String[] eatFood = person.getCantFoods();
            for (String s : eatFood) {
                if (eatFoods.contains(s)) {
                    return false;
                }
                eatFoods.add(s);
            }
        }
        return true;
    }
}
