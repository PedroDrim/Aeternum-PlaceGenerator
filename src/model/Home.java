package model;

import java.util.ArrayList;
import java.util.List;

public class Home implements ProceduralGeneration {

    private String name;
    private int maxPersonAmmount;
    private int maxPlaceAmmount;
    private Utility utility;
    private List<Person> personList;
    private List<ProceduralGeneration> placeList;
    
    public Home(String name, Utility utility) {
        this.name = name;
        this.utility = utility;
        this.maxPersonAmmount = utility.getSize();
        this.maxPlaceAmmount = 0;
        this.personList = new ArrayList();
        this.placeList = new ArrayList();
    }

    public Utility getUtility() {
        return this.utility;
    }

    @Override
    public String getType() {
        return this.utility.getName();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMaxPersonAmmount() {
        return this.maxPersonAmmount;
    }

    @Override
    public int getPersonListSize() {
        return this.personList.size();
    }

    @Override
    public List<Person> getPersonList() {
        return this.personList;
    }

    @Override
    public void insertPerson(int index, Person person) {
        if (this.maxPersonAmmount > this.personList.size()) {
            this.personList.add(index, person);
        }
    }

    @Override
    public void removePerson(int index) {
        if (this.personList.size() > index) {
            this.personList.remove(index);
        }
    }

    @Override
    public int getMaxPlaceAmmount(){
        return this.maxPlaceAmmount;
    }
    
    @Override
    public int getPlaceListSize() {
        return this.placeList.size();
    }

    @Override
    public List<ProceduralGeneration> getPlaceList() {
        return this.placeList;
    }

    @Override
    public void insertPlace(int index, ProceduralGeneration gen) {
        if (this.maxPlaceAmmount > this.placeList.size()) {
            this.placeList.add(index, gen);
        }
    }

    @Override
    public void removePlace(int index) {
        if (this.maxPlaceAmmount > this.placeList.size()) {
            this.placeList.remove(index);
        }
    }
}
