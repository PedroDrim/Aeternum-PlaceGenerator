package model.enums;

import model.City;

/**
 * Obtem o tipo de economia de "City"
 * @see City
 */
public enum Economy {
    TRADE("Trade"), MINNING("Minning"), SELF_SUSTAIN("Self sustain"), TOURISM("Tourism"), ANOTHER("Another");

    /**
     * Nome da economia
     */
    private String value;

    /**
     * Construtor de Enum
     * @param value O tipo de economia
     */
    Economy(String value) {
        this.value = value;
    }

    public String getName() {
        return this.value;
    }
}
