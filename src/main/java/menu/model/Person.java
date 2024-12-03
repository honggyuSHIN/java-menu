package menu.model;

public class Person {
    String name;
    String[] cantMenu;

    public Person(String name, String[] cantMenu) {
        this.name = name;
        this.cantMenu = cantMenu;
    }

    public String getPersonName() {
        return name;
    }

    public String[] getCantFoods() {
        return cantMenu;
    }

}
