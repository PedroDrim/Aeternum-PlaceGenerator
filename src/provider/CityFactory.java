package provider;

import model.City;
import model.Economy;
import model.ProceduralFactory;
import model.ProceduralGeneration;

import java.util.Random;

/**
 * Classe responsável por gerar uma cidade
 * @see ProceduralFactory
 */
public class CityFactory implements ProceduralFactory {

    /**
     * Princípio da aleatoriedade
     */
    private Random random;

    /**
     * String aleatoria
     */
    private RandomString randomString;

    /**
     * Tamanho máximo de nome
     */
    private int maxNameSize;

    /**
     * Tamanho minimo de nome
     */
    private int minNameSize;

    /**
     * Tamanho máximo de casas
     */
    private int maxHomeAmmount;

    /**
     * Tamanho minimo de casas
     */
    private int minHomeAmmount;

    /**
     * Construtor que inicializa as variaveis principais
     */
    public CityFactory(int maxNameSize, int minNameSize, int maxHomeAmmount, int minHomeAmmount) {
        this.random = new Random();
        this.randomString = new RandomString();
        this.maxNameSize = maxNameSize;
        this.minNameSize = minNameSize;
        this.maxHomeAmmount = maxHomeAmmount;
        this.minHomeAmmount = minHomeAmmount;
    }

    /**
     * Gera uma cidade proceduralmente
     * @see ProceduralGeneration
     * @return cidade gerada proceduralmente
     */
    @Override
    public ProceduralGeneration create() {

        int nameSize = this.minNameSize + this.random.nextInt(this.maxNameSize);
        int ammount = this.minHomeAmmount + this.random.nextInt(this.maxHomeAmmount);

        String placeName = this.randomString.generateName(nameSize);

        Economy economy = RandomizeEnum.randomEconomy();

        ProceduralGeneration city = new City(placeName, economy, ammount);

        return city;
    }
}
