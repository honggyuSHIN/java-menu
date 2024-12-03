package menu.model;

import java.util.List;
import java.util.Map;

public class People {
    private final List<Person> people;

    public People(List<Person> people) {
        this.people = people;
    }

    public void savePerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}
