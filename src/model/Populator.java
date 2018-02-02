package model;

/**
 * Interface para a geração completa de locais
 */
public interface Populator {

    /**
     * Inicia a geração do local
     * @param maxGeneration profundidade máxima de parentes
     * @return
     */
    GenealogyTree startGeneration(int maxGeneration);

    /**
     * Obtem a quantidade de camadas
     * @return Quantidade de camadas
     */
    int layerSize();
}
