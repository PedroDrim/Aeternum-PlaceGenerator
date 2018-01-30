package model;

public interface PersonFactory {
    
    Person born(Person father, Person mother);
    Person spawn();
}
