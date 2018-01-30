package view;

import model.Display;
import model.Person;
import model.ProceduralGeneration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class MyDisplay implements Display {

    private String personFileName;
    private String placeFileName;

    public MyDisplay(String personFileName, String placeFileName) {
        this.personFileName = personFileName;
        this.placeFileName = placeFileName;
    }

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

    private StringBuilder mountPersonInfo(ProceduralGeneration root, boolean first) {

        StringBuilder builder = new StringBuilder();
        if (first) {
            builder.append("name;sex;regency;father;mother;place\n");
            first = false;
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
            builder.append(this.mountPersonInfo(place, first));
        }

        return builder;
    }

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
