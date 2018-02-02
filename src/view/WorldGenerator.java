package view;

import provider.CityFactory;
import provider.HomeFactory;
import provider.HumanFactory;
import provider.MyDisplay;
import interactor.PersonMediator;
import interactor.PlaceMediator;
import interactor.*;
import model.Display;
import model.GenealogyTree;
import model.Mediator;
import model.ProceduralGeneration;

import java.util.Properties;

/**
 * Classe responsável por criar um mundo.
 */
public class WorldGenerator {

    /**
     * Taxa de evasao de personagem
     */
    private double AVOID_RATE;

    /**
     * Quantidade de geracoes
     */
    private int DEEP_LAYER;

    /**
     * Tamanho maximo de nome de pessoas
     */
    private int MAX_PERSON_NAME_SIZE;

    /**
     * Tamanho minimo de nome de pessoas
     */
    private int MIN_PERSON_NAME_SIZE;

    /**
     * Tamanho maximo de nome de locais
     */
    private int MAX_PLACE_NAME_SIZE;

    /**
     * Tamanho minimo de nome de locais
     */
    private int MIN_PLACE_NAME_SIZE;

    /**
     * Quantidade maxima de casa por cidade
     */
    private int MAX_HOME_AMMOUNT_PER_CITY;

    /**
     * Quantidade minima de casa por cidade
     */
    private int MIN_HOME_AMMOUNT_PER_CITY;

    /**
     * Arquivo de saida de pessoas
     */
    private String OUTPUT_PERSON_FILE_NAME;

    /**
     * Arquivo de saida de locais
     */
    private String OUTPUT_PLACE_FILE_NAME;

    /**
     * Quantidade minima de pessoas por geração
     */
    private int MIN_SIZE_PER_LAYER;

    /**
     * Construtor padrão
     */
    public WorldGenerator(Properties properties) {

        this.AVOID_RATE = Double.parseDouble(properties.getProperty("AVOID_RATE"));
        this.DEEP_LAYER = Integer.parseInt(properties.getProperty("DEEP_LAYER"));

        this.MAX_PERSON_NAME_SIZE = Integer.parseInt(properties.getProperty("MAX_PERSON_NAME_SIZE"));
        this.MIN_PERSON_NAME_SIZE = Integer.parseInt(properties.getProperty("MIN_PERSON_NAME_SIZE"));

        this.MAX_PLACE_NAME_SIZE = Integer.parseInt(properties.getProperty("MAX_PLACE_NAME_SIZE"));
        this.MIN_PLACE_NAME_SIZE = Integer.parseInt(properties.getProperty("MIN_PLACE_NAME_SIZE"));

        this.MAX_HOME_AMMOUNT_PER_CITY = Integer.parseInt(properties.getProperty("MAX_HOME_AMMOUNT_PER_CITY"));
        this.MIN_HOME_AMMOUNT_PER_CITY = Integer.parseInt(properties.getProperty("MIN_HOME_AMMOUNT_PER_CITY"));

        this.MIN_SIZE_PER_LAYER = Integer.parseInt(properties.getProperty("MIN_SIZE_PER_LAYER"));

        this.OUTPUT_PERSON_FILE_NAME = properties.getProperty("OUTPUT_PERSON_FILE_NAME");
        this.OUTPUT_PLACE_FILE_NAME = properties.getProperty("OUTPUT_PLACE_FILE_NAME");
    }

    /**
     * Gera uma cidade já populada randomicamente
     */
    public void generateRandomCity() {

        HumanFactory humanFactory = new HumanFactory(this.MAX_PERSON_NAME_SIZE, this.MIN_PERSON_NAME_SIZE);

        WorldPopulator world = new WorldPopulator(humanFactory, this.MIN_SIZE_PER_LAYER);
        GenealogyTree population = world.startGeneration(this.DEEP_LAYER);

        CityFactory cityFactory = new CityFactory(
                this.MAX_PLACE_NAME_SIZE, this.MIN_PLACE_NAME_SIZE,
                this.MAX_HOME_AMMOUNT_PER_CITY, this.MIN_HOME_AMMOUNT_PER_CITY);

        ProceduralGeneration city = cityFactory.create();

        HomeFactory homeFactory = new HomeFactory(this.MAX_PLACE_NAME_SIZE, this.MIN_PLACE_NAME_SIZE);

        Mediator placeMediator = new PlaceMediator(homeFactory);
        city = placeMediator.call(city);

        Mediator personMediator = new PersonMediator(population, this.AVOID_RATE);
        city = personMediator.call(city);

        Display display = new MyDisplay(
                this.OUTPUT_PERSON_FILE_NAME,
                this.OUTPUT_PLACE_FILE_NAME
        );

        display.display(city);
    }
}
