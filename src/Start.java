import view.WorldGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe inicial do projeto
 */
public class Start {

    /**
     * Método inicial
     * @param args parametros de sistema
     */
    public static void main(String[] args) {

        if(args.length > 0) {

            String arquivo = args[0];

            try {
                InputStream input = new FileInputStream(arquivo);
                Properties properties = new Properties();
                properties.load(input);

                WorldGenerator universe = new WorldGenerator(properties);
                universe.generateRandomCity();

            } catch (IOException exception) {
                System.out.println("Não foi possivel ler o arquivo: " + arquivo);
            }
        }else{
            System.out.println("O arquivo de configuração não foi declarado");
        }
    }
}
