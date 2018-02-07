package provider;

import interactor.Randomizer;
import model.City;
import model.enums.Economy;
import model.enums.Size;
import model.interfaces.ProceduralFactory;
import model.interfaces.ProceduralGeneration;

import java.util.Random;

/**
 * Classe responsável por gerar uma cidade
 * @see ProceduralFactory
 */
public class CityFactory implements ProceduralFactory {

    /**
     * Tamanho máximo de nome
     */
    private int maxNameSize;

    /**
     * Tamanho minimo de nome
     */
    private int minNameSize;

    /**
     * Fábrica para geração de casas
     */
    private ProceduralFactory factory;

    /**
     * Construtor que inicializa as variaveis principais
     */
    public CityFactory(ProceduralFactory factory, int maxNameSize, int minNameSize) {
        this.maxNameSize = maxNameSize;
        this.minNameSize = minNameSize;
        this.factory = factory;
    }

    /**
     * Gera uma cidade proceduralmente
     * @see ProceduralGeneration
     * @return cidade gerada proceduralmente
     */
    @Override
    public ProceduralGeneration create() {

        Random random = new Random();

        int constant = this.maxNameSize - this.minNameSize;
        int nameSize = this.minNameSize + random.nextInt(constant);

        String placeName = Randomizer.generateRandomName(nameSize);
        Economy economy = Randomizer.randomEconomy();
        Size size = Randomizer.randomSize();

        ProceduralGeneration city = new City(placeName, economy, size);

        for(int index = 0; index < size.getSize(); index++){
            ProceduralGeneration home = factory.create();
            city.insert(index, home);
        }

        return city;
    }
}
