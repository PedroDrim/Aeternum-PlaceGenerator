package model;

import java.util.ArrayList;
import java.util.List;

public class Human implements Person {

    private String name;
    private Sex sex;
    private Regency regency;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Human(String name, Sex sex, Regency regency) {

        boolean nameValidation = (name == null || name.isEmpty());
        if (nameValidation) {
            throw new IllegalArgumentException("Invalid name.");
        } else {
            this.name = name;
        }

        boolean regencyValidation = (regency == null);
        if (regencyValidation) {
            throw new IllegalArgumentException("Invalid regence.");
        } else {
            this.regency = regency;
        }

        boolean sexValidation = (sex == null);
        if (sexValidation) {
            throw new IllegalArgumentException("Invalid sex.");
        } else {
            this.sex = sex;
        }

        this.children = new ArrayList();
    }

    @Override
    public void setFather(Person father) {
        if (father != null) {
            this.father = father;
        }
    }

    @Override
    public void setMother(Person mother) {
        if (mother != null) {
            this.mother = mother;
        }
    }

    @Override
    public void setChildren(Person child) {
        if (child != null) {
            this.children.add(child);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Regency getRegency() {
        return this.regency;
    }

    @Override
    public Sex getSex() {
        return this.sex;
    }

    @Override
    public Person getFather() {
        return this.father;
    }

    @Override
    public Person getMother() {
        return this.mother;
    }

    @Override
    public List<Person> getChildren() {
        return this.children;
    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person: ").append(this.name);
        builder.append(" - The ").append(this.sex.getName());
        builder.append(" ").append(this.regency.getName());

        return builder.toString();
    }
}
