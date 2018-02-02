package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe referente á uma cidade
 * @see model.ProceduralGeneration
 */
public class City implements ProceduralGeneration {

    /**
     * Tipo de economia
     */
    private Economy economy;

    /**
     * Nome da cidade
     */
    private String name;

    /**
     * Quantidade máxima de locais
     */
    private int maxPlaceAmmount;

    /**
     * Quantidade máxima de pessoas
     */
    private int maxPersonAmmount;

    /**
     * Lista de pessoas
     */
    private List<Person> personList;

    /**
     * Lista de locais
     */
    private List<ProceduralGeneration> placeList;

    /**
     * Construtor que inicializa as variaveis principais
     * @param name Nome da cidade
     * @param economy Tipo de economia
     * @param maxPlaceAmmount Quantidade maxima de locais
     */
    public City(String name, Economy economy, int maxPlaceAmmount) {
        this.economy = economy;
        this.name = name;
        this.maxPlaceAmmount = maxPlaceAmmount;
        this.maxPersonAmmount = economy.getMaxPersonOnStreet();
        this.personList = new ArrayList();
        this.placeList = new ArrayList();
    }

    /**
     * Obtem o tipo do objeto
     * @return tipo do objeto
     */
    @Override
    public String getType() {
        return this.economy.getName();
    }

    /**
     * Obtem o nome do objeto
     * @return nome do objeto
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Obtem a quantidade máxima de pessoas
     * @return quantidade máxima de pessoas
     */
    @Override
    public int getMaxPersonAmmount() {
        return this.maxPersonAmmount;
    }

    /**
     * Obtem a quantidade atual de pessoas
     * @return quantidade atual de pessoas
     */
    @Override
    public int getPersonListSize() {
        return this.personList.size();
    }

    /**
     * Obtem as pessoas nele inseridas
     * @return as pessoas nele inseridas
     */
    @Override
    public List<Person> getPersonList() {
        return this.personList;
    }

    /**
     * Insere uma pessoa no local
     * @param index indice na lista
     * @param person pessoa a ser inserida
     */
    @Override
    public void insertPerson(int index, Person person) {
        if (this.maxPersonAmmount > this.personList.size()) {
            this.personList.add(index, person);
        }
    }

    /**
     * Remove uma pessoa no local
     * @param index indice da pessoa a ser removida
     */
    @Override
    public void removePerson(int index) {
        if (this.personList.size() > index) {
            this.personList.remove(index);
        }
    }

    /**
     * Obtem a quantidade máxima de locais
     * @return quantidade máxima de locais
     */
    @Override
    public int getMaxPlaceAmmount() {
        return this.maxPlaceAmmount;
    }

    /**
     * Obtem a quantidade atual de locais
     * @return quantidade atual de locais
     */
    @Override
    public int getPlaceListSize() {
        return this.placeList.size();
    }

    /**
     * Obtem a lista de locais
     * @return lista de locais
     */
    @Override
    public List<ProceduralGeneration> getPlaceList() {
        return this.placeList;
    }

    /**
     * Insere um local
     * @param index indice na lista
     * @param gen local a ser inserido
     */
    @Override
    public void insertPlace(int index, ProceduralGeneration gen) {
        if (this.maxPlaceAmmount > this.placeList.size()) {
            this.placeList.add(index, gen);
        }
    }

    /**
     * Remove um local
     * @param index indice do local a ser removido
     */
    @Override
    public void removePlace(int index) {
        if (this.placeList.size() > index) {
            this.placeList.remove(index);
        }
    }
}
