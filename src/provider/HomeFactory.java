package provider;

import model.Home;
import model.ProceduralFactory;
import model.ProceduralGeneration;
import model.Utility;

import java.util.Random;

/**
 * Classe responsável por gerar uma casa
 * @see model.ProceduralFactory
 */
public class HomeFactory implements ProceduralFactory {

    /**
     * Principio da aleatoriedade
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
     * Tamanho miinimo de nome
     */
    private int minNameSize;

    /**
     * Construtor responsável por inicializar as variaveis principais
     */
    public HomeFactory(int maxNameSize, int minNameSize) {
        this.random = new Random();
        this.randomString = new RandomString();
        this.maxNameSize = maxNameSize;
        this.minNameSize = minNameSize;
    }

    @Override
    public ProceduralGeneration create() {

        int nameSize = this.minNameSize + this.random.nextInt(this.maxNameSize);

        String placeName = this.randomString.generateName(nameSize);

        Utility utility = RandomizeEnum.randomUtility();

        ProceduralGeneration home = new Home(placeName, utility);
        return home;
    }

}
