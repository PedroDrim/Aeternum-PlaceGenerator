package model;

import java.util.List;

public interface Person {

    String getName();
    Regency getRegency();
    Sex getSex();
    Person getFather();
    Person getMother();
    List<Person> getChildren();
    void setFather(Person father);
    void setMother(Person mother);
    void setChildren(Person child);
    String getInfo();
}
