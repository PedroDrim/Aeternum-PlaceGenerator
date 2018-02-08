package model;

import model.enums.Economy;
import model.enums.Size;
import model.interfaces.Person;
import model.interfaces.ProceduralGeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe referente á uma cidade
 * @see ProceduralGeneration
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
     * Tamanho de locais
     */
    private Size size;

    /**
     * Lista de locais
     */
    private List<ProceduralGeneration> placeList;

    /**
     * Construtor que inicializa as variaveis principais
     * @param name Nome da cidade
     * @param economy Tipo de economia
     * @param size Quantidade maxima de locais
     */
    public City(String name, Economy economy, Size size) {
        this.economy = economy;
        this.name = name;
        this.size = size;
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
    public int getMaxSize() {
        return this.size.getSize();
    }

    /**
     * Obtem a quantidade atual de pessoas
     * @return quantidade atual de pessoas
     */
    @Override
    public int getActualSize() {
        return this.placeList.size();
    }

    @Override
    public List getList() {
        return this.placeList;
    }

    @Override
    public void insert(int index, Object object) {
        if (this.size.getSize() > this.placeList.size()) {
            this.placeList.add(index, (Home) object);
        }
    }

    @Override
    public void remove(int index) {
        this.placeList.remove(index);
    }
}
