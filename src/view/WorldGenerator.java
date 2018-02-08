package view;

import com.google.gson.Gson;
import model.Home;
import model.Human;
import model.interfaces.Person;
import model.interfaces.ProceduralFactory;
import model.interfaces.ProceduralGeneration;
import provider.CityFactory;
import provider.HomeFactory;
import provider.HumanFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe responsável por criar um mundo.
 */
public class WorldGenerator {

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
     * Arquivo de saida de pessoas
     */
    private String OUTPUT_FILE_NAME;

    /**
     * Construtor padrão
     */
    public WorldGenerator(Properties properties) {

        this.MAX_PERSON_NAME_SIZE = Integer.parseInt(properties.getProperty("MAX_PERSON_NAME_SIZE"));
        this.MIN_PERSON_NAME_SIZE = Integer.parseInt(properties.getProperty("MIN_PERSON_NAME_SIZE"));

        this.MAX_PLACE_NAME_SIZE = Integer.parseInt(properties.getProperty("MAX_PLACE_NAME_SIZE"));
        this.MIN_PLACE_NAME_SIZE = Integer.parseInt(properties.getProperty("MIN_PLACE_NAME_SIZE"));

        this.OUTPUT_FILE_NAME = properties.getProperty("OUTPUT_FILE_NAME");
    }

    /**
     * Gera uma cidade já populada randomicamente
     */
    public void generateRandomCity() {

        HumanFactory humanFactory = new HumanFactory( this.MAX_PERSON_NAME_SIZE, this.MIN_PERSON_NAME_SIZE );

        ProceduralFactory homeFactory = new HomeFactory( humanFactory,
                this.MAX_PLACE_NAME_SIZE,
                this.MIN_PLACE_NAME_SIZE
        );

        ProceduralFactory cityFactory = new CityFactory( homeFactory,
                this.MAX_PLACE_NAME_SIZE,
                this.MIN_PLACE_NAME_SIZE
        );

        this.createFile(cityFactory.create());
    }

    private void createFile(ProceduralGeneration city){

        try {
            Gson gson = new Gson();
            FileOutputStream outputStream = new FileOutputStream(this.OUTPUT_FILE_NAME);
            byte[] strToBytes = gson.toJson(city).getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Não foi possivel serializar o objeto.");
        }
    }
}
