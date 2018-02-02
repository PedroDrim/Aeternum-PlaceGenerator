package model;

import java.util.List;

/**
 * Interface para geração de objetos de forma procedural
 */
public interface ProceduralGeneration {

    /**
     * Obtem o nome do objeto
     * @return nome do objeto
     */
    String getName();

    /**
     * Obtem o tipo do objeto
     * @return tipo do objeto
     */
    String getType();

    /**
     * Obtem a quantidade máxima de pessoas
     * @return quantidade máxima de pessoas
     */
    int getMaxPersonAmmount();

    /**
     * Obtem a quantidade atual de pessoas
     * @return quantidade atual de pessoas
     */
    int getPersonListSize();

    /**
     * Obtem as pessoas nele inseridas
     * @return as pessoas nele inseridas
     */
    List<Person> getPersonList();

    /**
     * Insere uma pessoa no local
     * @param index indice na lista
     * @param person pessoa a ser inserida
     */
    void insertPerson(int index, Person person);

    /**
     * Remove uma pessoa no local
     * @param index indice da pessoa a ser removida
     */
    void removePerson(int index);

    /**
     * Obtem a quantidade máxima de locais
     * @return quantidade máxima de locais
     */
    int getMaxPlaceAmmount();

    /**
     * Obtem a quantidade atual de locais
     * @return quantidade atual de locais
     */
    int getPlaceListSize();

    /**
     * Obtem a lista de locais
     * @return lista de locais
     */
    List<ProceduralGeneration> getPlaceList();

    /**
     * Insere um local
     * @param index indice na lista
     * @param gen local a ser inserido
     */
    void insertPlace(int index, ProceduralGeneration gen);

    /**
     * Remove um local
     * @param index indice do local a ser removido
     */
    void removePlace(int index);
}
