package symantic;

import java.io.IOException;

/**
 * Created by ajeya.hb on 19/09/16.
 */
public class Person {

    private int age;
    private String name;
    private String add;
    private int num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (num != person.num) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return add != null ? add.equals(person.add) : person.add == null;

    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (add != null ? add.hashCode() : 0);
        result = 31 * result + num;
        return result;
    }

    public int get(String id) throws IOException {
        return 0;
    }
}
