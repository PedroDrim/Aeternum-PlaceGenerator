package provider;

import interactor.Randomizer;
import model.Home;
import model.enums.Size;
import model.interfaces.*;
import model.enums.Utility;

import java.util.Random;

/**
 * Classe responsável por gerar uma casa
 * @see ProceduralFactory
 */
public class HomeFactory implements ProceduralFactory {

    /**
     * Tamanho máximo de nome
     */
    private int maxNameSize;

    /**
     * Tamanho minimo de nome
     */
    private int minNameSize;

    /**
     * Fábrica para geração de pessoas
     */
    private PersonFactory factory;

    /**
     * Construtor responsável por inicializar as variaveis principais
     */
    public HomeFactory(PersonFactory factory, int maxNameSize, int minNameSize) {
        this.maxNameSize = maxNameSize;
        this.minNameSize = minNameSize;
        this.factory = factory;
    }

    @Override
    public ProceduralGeneration create() {

        Random random = new Random();

        int constant = this.maxNameSize - this.minNameSize;
        int nameSize = this.minNameSize + random.nextInt(constant);

        String placeName = Randomizer.generateRandomName(nameSize);
        Utility utility = Randomizer.randomUtility();
        Size size = Randomizer.randomSize();

        ProceduralGeneration home = new Home(placeName, utility, size);

        for(int index = 0; index < size.getSize(); index++){
            Person person = this.factory.createRandom();
            home.insert(index, person);
        }

        return home;
    }

}
