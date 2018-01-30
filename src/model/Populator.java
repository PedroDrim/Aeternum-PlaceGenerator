package model;

public interface Populator {
    
    GenealogyTree startGeneration(int maxGeneration);
    int layerSize();
}
