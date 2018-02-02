package model;

/**
 * Interface para serialização de objetos
 */
public interface Display {

    /**
     * Método que serializa os objetos em arquivos
     * @param place objeto a ser serializado
     * @see provider.MyDisplay
     */
    void display(ProceduralGeneration place);
}
