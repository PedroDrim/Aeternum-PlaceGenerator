package model;

import java.util.List;

/**
 * Interface para a abstração de uma pessoa
 */
public interface Person {

    /**
     * Obtem o nome da pessoa
     * @return o nome da pessoa
     */
    String getName();

    /**
     * Obtem a regencia da pessoa
     * @return regencia da pessoa
     */
    Regency getRegency();

    /**
     * Obtem o sexo da pessoa
     * @return sexo da pessoa
     */
    Sex getSex();

    /**
     * Obtem o pai da pessoa
     * @return pai da pessoa
     */
    Person getFather();

    /**
     * Obtem a mãe da pessoa
     * @return mãe da pessoa
     */
    Person getMother();

    /**
     * Obtem a lista de filhos da pessoa
     * @return lista de filhos da pessoa
     */
    List<Person> getChildren();

    /**
     * Define o pai da pessoa
     * @param father o novo pai
     */
    void setFather(Person father);

    /**
     * Defina a mae da pessoa
     * @param mother a nova mae
     */
    void setMother(Person mother);

    /**
     * Adiciona uma criança
     * @param child criança a ser adicionada
     */
    void setChildren(Person child);

    /**
     * Obtem as informações da pessoa
     * @return informações da pessoa
     */
    String getInfo();
}
