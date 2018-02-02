package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe responsável por representar uma árvore genealógica
 */
public class GenealogyTree {

    /**
     * Objeto para mapear as gerações e seus integrantes
     */
    private Map<String, List<Person>> tree;

    /**
     * Construtor que inicializa as variaveis principais
     */
    public GenealogyTree() {
        this.tree = new HashMap();
    }

    /**
     * Cria uma nova camada de gerações
     * @param layer nome da camada
     */
    public void newLayer(String layer) {
        List<Person> list = new ArrayList();
        this.tree.put(layer, list);
    }

    /**
     * Remove uma camada de gerações
     * @param layer nome da camada
     */
    public void removeLayer(String layer){
        this.tree.remove(layer);
    }

    /**
     * Obtem os nomes das camadas válidas
     * @return nomes das camadas válidas
     */
    public String[] getLayers() {
        Set<String> keys = this.tree.keySet();
        String[] obj = keys.toArray(new String[keys.size()]);
        return obj;
    }

    /**
     * Obtem a lista referente á uma camada
     * @param layer identificador da camada
     * @return lista referente á camada
     */
    public List<Person> getListByLayer(String layer) {
        return this.tree.get(layer);
    }

    /**
     * Adiciona uma pessoa á uma camada
     * @param layer camada referente
     * @param person pessoa a ser adicionada
     */
    public void addPersonInLayer(String layer, Person person) {
        List<Person> list = this.tree.get(layer);
        list.add(person);

        this.tree.put(layer, list);
    }

    /**
     * Remove uma pessoa á uma camada
     * @param layer camada referente
     * @param index indice da pessoa
     */
    public void removePersonInLayer(String layer, int index) {
        List<Person> list = this.tree.get(layer);
        list.remove(index);

        this.tree.put(layer, list);
    }

    /**
     * Obtem uma pessoa referente á uma camada
     * @param layer camada referente
     * @param index indice da pessoa
     * @return pessoa referente
     */
    public Person getPersonInLayer(String layer, int index) {
        List<Person> list = this.tree.get(layer);
        return list.get(index);
    }

    /**
     * Obtem a quantidade de pessoas entre todas as camadas
     * @return a quantidade de pessoas entre todas as camadas
     */
    public int getMaxSize() {
        int maxSize = 0;

        for (List<Person> l : this.tree.values()) {
            maxSize += l.size();
        }

        return maxSize;
    }

    /**
     * Obtem a quantidade de pessoas em uma camada
     * @param layer camada referente
     * @return a quantidade de pessoas na camada
     */
    public int getLayerSize(String layer) {
        List<Person> list = this.tree.get(layer);

        return list.size();
    }
}
