package model.enums;

/**
 * Obtem o tamanho
 */
public enum Size {

    SMALL(4), MEDIUM(8), LARGE(12), EXTRA(16), ROYAL(20);

    /**
     * Quantidade máxima de pessoas ou itens
     */
    private int maxSize;

    /**
     * Construtor de Enum
     * @param maxSize O tamanho maximo do enum
     */
    Size(int maxSize) {
        this.maxSize = maxSize;
     }

    /**
     * Retorna o tamanho maximo
     * @return
     */
    public int getSize() {
        return maxSize;
    }
}
