package provider;

import java.util.Random;

/**
 * Classe para geração de Strings aleatórias
 */
public class RandomString {

    /**
     * Caracteres de consoantes
     */
    private String consonant;

    /**
     * Caracteres de vogais
     */
    private String vowel;

    /**
     * Principio da aleatoriedade
     */
    private Random random;

    /**
     * Construtor publico para inicialização das variaveis principais
     */
    public RandomString() {
        this.consonant = "bcdfghjklmnpqrstvwxyz";
        this.vowel = "aeiou";
        this.random = new Random();
    }

    /**
     * Gera um nome de pessoa, com nome e sobrenome
     * @param sizeFirstName Tamanho do nome
     * @param sizeSecondName Tamanho do sobrenome
     * @return Um nome e sobrenome
     */
    public String generatePersonName(int sizeFirstName, int sizeSecondName) {
        StringBuilder builder = new StringBuilder();

        builder.append(this.generateName(sizeFirstName));
        builder.append(" ");
        builder.append(this.generateName(sizeSecondName));

        return builder.toString();
    }

    /**
     * Gera um nome aleatório
     * @param size quantidade de letras do nome
     * @return o nome
     */
    public String generateName(int size) {
        StringBuilder builder = new StringBuilder();
        String[] consonantArray = this.consonant.split("");
        String[] vowelArray = this.vowel.split("");

        for (int index = 0; index < size; index++) {
            String n;
            if (index % 2 == 0) {
                n = consonantArray[random.nextInt(this.consonant.length())];
            } else {
                n = vowelArray[random.nextInt(this.vowel.length())];
            }

            if (index == 0) {
                n = n.toUpperCase();
            }
            builder.append(n);
        }

        return builder.toString();
    }
}
