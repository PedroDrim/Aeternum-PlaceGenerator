package model.enums;

import model.Home;

/**
 * Tipos de utilizades para as 'Homes'
 * @see Home
 */
public enum Utility {

    INN("Inn"), PUB("Pub"), SHOP("Shop"), HOUSE("House"), ABANDONED("Abandoned");

    /**
     * Tipo da Home
     */
    private String value;

    /**
     * Construtor de enum
     * @param value Tipo
     */
    Utility(String value){
        this.value = value;
    }

    /**
     * Obtem o valor do Enum
     * @return O tipo da Home
     */
    public String getName(){
        return this.value;
    }
}
