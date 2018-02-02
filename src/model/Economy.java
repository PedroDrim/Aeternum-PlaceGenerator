package model;

/**
 * Obtem o tipo de economia de "City"
 * @see City
 */
public enum Economy {
    TRADE("Trade", 100), MINNING("Minning", 100),
    SELF_SUSTAIN("Self sustain", 100), TOURISM("Tourism", 100),
    ANOTHER("Another", 100);

    /**
     * Nome da economia
     */
    private String value;

    /**
     * Quantidade máxima de pessoas fora de casas
     */
    private int maxPersonOnStreet;

    /**
     * Construtor de Enum
     * @param value O tipo de economia
     * @param personSize  Quantidade máxima de pessoas
     */
    Economy(String value, int personSize) {
        this.value = value;
        this.maxPersonOnStreet = personSize;
    }

    public String getName() {
        return this.value;
    }
    
    public int getMaxPersonOnStreet(){
        return this.maxPersonOnStreet;
    }
}
