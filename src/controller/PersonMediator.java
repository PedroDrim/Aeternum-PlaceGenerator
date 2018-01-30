package controller;

import model.GenealogyTree;
import model.Mediator;
import model.Person;
import model.ProceduralGeneration;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PersonMediator implements Mediator {

    private GenealogyTree tree;
    private Random random;
    private double avoidRate;

    public PersonMediator(GenealogyTree tree, double avoidRate) {
        this.tree = tree;
        this.avoidRate = avoidRate;
        this.random = new Random();
    }

    @Override
    public ProceduralGeneration call(ProceduralGeneration place) {

        int maxPerson = place.getMaxPersonAmmount();
        int streetSize = this.random.nextInt(maxPerson);
        int maxPlace = place.getMaxPlaceAmmount();
        
        for (int index = 0; index < streetSize; index++) {

            Person person = this.getRandomPerson();
            place.insertPerson(index, person);
        }

        List<ProceduralGeneration> list = place.getPlaceList();

        for (int index = 0; index < maxPlace; index++) {

            ProceduralGeneration element = list.get(index);
            this.call(element);
            place.insertPlace(index, element);
        }

        return place;
    }

    private Person getRandomPerson() {

        String[] layers = this.getValidLayers();
        Person person = null;

        double randomRate = (double) this.random.nextInt(101) / 100;

        boolean validationAvoid = this.avoidRate <= randomRate;
        boolean validationSize = layers.length != 0;

        if (validationSize && validationAvoid) {

            String randomLayer = layers[this.random.nextInt(layers.length)];
            int layerSize = this.tree.getLayerSize(randomLayer);
            int randomIndex = this.random.nextInt(layerSize);

            person = this.tree.getPersonInLayer(randomLayer, randomIndex);
            this.tree.removePersonInLayer(randomLayer, randomIndex);
        }

        return person;
    }

    private String[] getValidLayers() {

        Set<String> list = new HashSet();

        String[] layers = this.tree.getLayers();
        for (String l : layers) {
            if (this.tree.getLayerSize(l) > 0) {
                list.add(l);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
