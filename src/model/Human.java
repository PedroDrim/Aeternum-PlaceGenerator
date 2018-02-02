package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por referênciar um humano
 * @see model.Person
 */
public class Human implements Person {

    /**
     * Nome da pessoa
     */
    private String name;

    /**
     * Sexo da pessoa
     */
    private Sex sex;

    /**
     * Regencia da pessoa
     */
    private Regency regency;

    /**
     * Pai da pessoa
     */
    private Person father;

    /**
     * Mãe da pessoa
     */
    private Person mother;

    /**
     * Lista de crias da pessoa
     */
    private List<Person> children;

    /**
     * Construtor que inicializa as variaveis principais
     * @param name Nome da pessoa
     * @param regency Regencia da pessoa
     * @param sex Sexo da pessoa
     */
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

    /**
     * Define o pai da pessoa
     * @param father o novo pai
     */
    @Override
    public void setFather(Person father) {
        if (father != null) {
            this.father = father;
        }
    }

    /**
     * Defina a mae da pessoa
     * @param mother a nova mae
     */
    @Override
    public void setMother(Person mother) {
        if (mother != null) {
            this.mother = mother;
        }
    }

    /**
     * Adiciona uma criança
     * @param child criança a ser adicionada
     */
    @Override
    public void setChildren(Person child) {
        if (child != null) {
            this.children.add(child);
        }
    }

    /**
     * Obtem o nome da pessoa
     * @return o nome da pessoa
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Obtem a regencia da pessoa
     * @return regencia da pessoa
     */

    @Override
    public Regency getRegency() {
        return this.regency;
    }

    /**
     * Obtem o sexo da pessoa
     * @return sexo da pessoa
     */
    @Override
    public Sex getSex() {
        return this.sex;
    }

    /**
     * Obtem o pai da pessoa
     * @return pai da pessoa
     */
    @Override
    public Person getFather() {
        return this.father;
    }

    /**
     * Obtem a mãe da pessoa
     * @return mãe da pessoa
     */
    @Override
    public Person getMother() {
        return this.mother;
    }

    /**
     * Obtem a lista de filhos da pessoa
     * @return lista de filhos da pessoa
     */
    @Override
    public List<Person> getChildren() {
        return this.children;
    }

    /**
     * Obtem as informações da pessoa
     * @return informações da pessoa
     */
    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person: ").append(this.name);
        builder.append(" - The ").append(this.sex.getName());
        builder.append(" ").append(this.regency.getName());

        return builder.toString();
    }
}