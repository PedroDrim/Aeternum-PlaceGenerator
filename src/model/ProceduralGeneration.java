package model;

import java.util.List;

public interface ProceduralGeneration {

    String getName();
    
    String getType();

    int getMaxPersonAmmount();

    int getPersonListSize();

    List<Person> getPersonList();

    void insertPerson(int index, Person person);

    void removePerson(int index);

    int getMaxPlaceAmmount();
    
    int getPlaceListSize();

    List<ProceduralGeneration> getPlaceList();

    void insertPlace(int index, ProceduralGeneration gen);

    void removePlace(int index);
}
