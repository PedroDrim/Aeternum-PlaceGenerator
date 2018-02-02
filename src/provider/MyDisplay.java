package provider;

import model.Display;
import model.Person;
import model.ProceduralGeneration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Classe responsável por serializar os objetos na forma de um .csv
 * @see Display
 */
public class MyDisplay implements Display {

    /**
     * Arquivo de pessoas
     */
    private String personFileName;

    /**
     * Arquivo de locais
     */
    private String placeFileName;

    /**
     * Construtor para definir os arquivos de output
     * @param personFileName nome do arquivo de pessoas
     * @param placeFileName nome do arquivo de locais
     */
    public MyDisplay(String personFileName, String placeFileName){
        this.personFileName = personFileName;
        this.placeFileName = placeFileName;
    }

    /**
     * Método que serializa os objetos em arquivos .csv
     * @param root objeto a ser serializado
     */
    @Override
    public void display(ProceduralGeneration root) {

        StringBuilder personBuilder = this.mountPersonInfo(root, true);
        StringBuilder placeBuilder = this.mountPlaceInfo(root);

        try {
            PrintWriter personWriter = new PrintWriter(this.personFileName, "UTF-8");
            personWriter.println(personBuilder.toString());
            personWriter.close();

            PrintWriter placeWriter = new PrintWriter(this.placeFileName, "UTF-8");
            placeWriter.println(placeBuilder.toString());
            placeWriter.close();

        } catch (FileNotFoundException | UnsupportedEncodingException ex) {

        }
    }

    /**
     * Obtem e organiza as informações das pessoas
     * @param root objeto a ser serializado
     * @param append unir arquivo á outro
     * @return uma string contendo as informações tratadas
     */
    private StringBuilder mountPersonInfo(ProceduralGeneration root, boolean append) {

        StringBuilder builder = new StringBuilder();
        if (append) {
            builder.append("name;sex;regency;father;mother;place\n");
            append = false;
        }

        List<Person> personList = root.getPersonList();
        List<ProceduralGeneration> placeList = root.getPlaceList();

        for (Person person : personList) {

            if (person != null) {
                
                builder.append(person.getName()).append(";");
                builder.append(person.getSex().getName()).append(";");
                builder.append(person.getRegency().getName()).append(";");
                builder.append(person.getFather().getName()).append(";");
                builder.append(person.getMother().getName()).append(";");
                builder.append(root.getName()).append("\n");
            }
        }

        for (ProceduralGeneration place : placeList) {
            builder.append(this.mountPersonInfo(place, append));
        }

        return builder;
    }

    /**
     * Obtem e organiza as informações dos locais
     * @param root objeto a ser serializado
     * @return uma string contendo as informações tratadas
     */
    private StringBuilder mountPlaceInfo(ProceduralGeneration root) {

        StringBuilder builder = new StringBuilder();
        builder.append("city;cityEconomy;home;homeUtility\n");

        List<ProceduralGeneration> placeList = root.getPlaceList();

        for (ProceduralGeneration place : placeList) {
            builder.append(root.getName()).append(";");
            builder.append(root.getType()).append(";");
            builder.append(place.getName()).append(";");
            builder.append(place.getType()).append("\n");
        }

        return builder;
    }
}
