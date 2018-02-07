package model;

import model.enums.Size;
import model.enums.Utility;
import model.interfaces.Displayable;
import model.interfaces.Person;
import model.interfaces.ProceduralGeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe referente á uma casa
 * @see ProceduralGeneration
 */
public class Home implements ProceduralGeneration, Displayable {

    /**
     * Nome da casa
     */
    private String name;

    /**
     * Tipo de utilidade da casa
     */
    private Utility utility;

    /**
     * Tamanho de locais
     */
    private Size size;

    /**
     * Lista de pessoas
     */
    private List<Person> personList;

    /**
     * Construtor que inicializa as variaveis principais
     * @param name Nome da casa
     * @param utility Tipo de utilidade
     */
    public Home(String name, Utility utility, Size size) {
        this.name = name;
        this.utility = utility;
        this.size = size;
        this.personList = new ArrayList();
    }

    /**
     * Obtem o tipo do objeto
     * @return tipo do objeto
     */
    @Override
    public String getType() {
        return this.utility.getName();
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
        return this.personList.size();
    }

    /**
     * Obtem as pessoas nele inseridas
     * @return as pessoas nele inseridas
     */
    @Override
    public List<Person> getList() {
        return this.personList;
    }

    /**
     * Insere uma pessoa no local
     * @param index indice na lista
     * @param object pessoa a ser inserida
     */
    @Override
    public void insert(int index, Object object) {
        if (this.size.getSize() > this.personList.size()) {
            this.personList.add(index, (Person) object);
        }
    }

    /**
     * Remove uma pessoa no local
     * @param index indice da pessoa a ser removida
     */
    @Override
    public void remove(int index) {
        if (this.personList.size() > index) {
            this.personList.remove(index);
        }
    }

    @Override
    public String display() {

        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append(";");
        builder.append(this.size.getSize()).append(";");
        builder.append(this.utility.getName()).append("\n");

        return builder.toString();
    }
}
