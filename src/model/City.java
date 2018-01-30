package model;

import java.util.ArrayList;
import java.util.List;

public class City implements ProceduralGeneration {

    private Economy economy;
    private String name;
    private int maxPlaceAmmount;
    private int maxPersonAmmount;
    private List<Person> personList;
    private List<ProceduralGeneration> placeList;

    public City(String name, Economy economy, int maxPlaceAmmount) {
        this.economy = economy;
        this.name = name;
        this.maxPlaceAmmount = maxPlaceAmmount;
        this.maxPersonAmmount = economy.getMaxPersonOnStreet();
        this.personList = new ArrayList();
        this.placeList = new ArrayList();
    }

    @Override
    public String getType() {
        return this.economy.getName();
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
    public int getMaxPlaceAmmount() {
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
        if (this.placeList.size() > index) {
            this.placeList.remove(index);
        }
    }
}
