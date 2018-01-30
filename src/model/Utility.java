package model;

/**
 * Tipos de utilizades para as 'Homes'
 * @see Home
 */
public enum Utility {

    INN("Inn", 10), PUB("Pub", 25), SHOP("Shop", 10),
    SMALL_HOUSE("Small house", 5), MEDIUM_HOUSE("Medium house", 10),
    BIG_HOUSE("Big house", 20), ABANDONED("Abandoned", 20);

    /**
     * Tipo da Home
     */
    private String value;

    /**
     * Tamanho da Home
     */
    private int size;

    /**
     * Construtor de enum
     * @param value Tipo
     * @param size Tamanho de moradores
     */
    Utility(String value, int size){
        this.value = value;
        this.size = size;
    }

    /**
     * Obtem o valor do Enum
     * @return O tipo da Home
     */
    public String getName(){
        return this.value;
    }

    /**
     * Obtem o tamanho do Enum
     * @return A quantidade máxima de moradores
     */
    public int getSize(){
        return this.size;
    }
}
