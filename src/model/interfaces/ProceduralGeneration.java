package model.interfaces;

import java.util.List;

/**
 * Interface para geração de objetos de forma procedural
 */
public interface ProceduralGeneration<T> {

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
     * Obtem o tamanho maximo
     * @return tamanho maximo
     */
    int getMaxSize();

    /**
     * Obtem a quantidade atual de pessoas
     * @return quantidade atual de pessoas
     */
    int getActualSize();

    /**
     * Obtem as pessoas nele inseridas
     * @return as pessoas nele inseridas
     */
    List<T> getList();

    /**
     * Insere uma pessoa no local
     * @param index indice na lista
     * @param object pessoa a ser inserida
     */
    void insert(int index, T object);

    /**
     * Remove uma pessoa no local
     * @param index indice da pessoa a ser removida
     */
    void remove(int index);
}
