package controller;

import model.*;

import java.util.Random;

public class WorldPopulator implements Populator {

    private PersonFactory factory;
    private GenealogyTree tree;
    private int layer;
    private int minSizePerLayer;
    private String maleTag = "M";
    private String femaleTag = "F";

    public WorldPopulator(PersonFactory factory) {

        this.layer = 0;
        this.minSizePerLayer = 10;
        
        this.factory = factory;
        this.tree = new GenealogyTree();
        this.tree.newLayer(this.maleTag + this.layer);
        this.tree.newLayer(this.femaleTag + this.layer);
    }

    @Override
    public GenealogyTree startGeneration(int maxGeneration) {

        this.firstGeneration();

        for (int index = 0; index < maxGeneration; index++) {
            this.nextGeneration();
        }

        this.tree.removeLayer(maleTag + 0);
        this.tree.removeLayer(femaleTag + 0);
        return this.tree;
    }

    @Override
    public int layerSize(){
        return this.layer;
    }
    
    private void firstGeneration() {

        while (true) {

            Person person = this.factory.spawn();

            String newLayer;
            if (person.getSex() == Sex.FEMALE) {
                newLayer = this.femaleTag + this.layer;
            } else {
                newLayer = this.maleTag + this.layer;
            }

            this.tree.addPersonInLayer(newLayer, person);

            int maleSize = this.tree.getLayerSize(this.femaleTag + this.layer);
            int femaleSize = this.tree.getLayerSize(this.maleTag + this.layer);
            
            boolean minMaleAmmount = (maleSize >= this.minSizePerLayer);
            boolean minFemaleAmmount = (femaleSize >= this.minSizePerLayer);

            if (minFemaleAmmount && minMaleAmmount) {
                break;
            }
        }
    }

    private void nextGeneration() {

        Random random = new Random();

        String maleLayer = this.maleTag + this.layer;
        String femaleLayer = this.femaleTag + this.layer;

        int maleSize = this.tree.getLayerSize(maleLayer);
        int femaleSize = this.tree.getLayerSize(femaleLayer);

        this.layer++;
        String newMaleLayer = this.maleTag + this.layer;
        String newFemaleLayer = this.femaleTag + this.layer;

        this.tree.newLayer(newMaleLayer);
        this.tree.newLayer(newFemaleLayer);

        while (true) {

            int randomMale = random.nextInt(maleSize);
            int randomFemale = random.nextInt(femaleSize);

            Person malePerson = this.tree.getPersonInLayer(maleLayer, randomMale);
            Person femalePerson = this.tree.getPersonInLayer(femaleLayer, randomFemale);

            Person person = this.factory.born(malePerson, femalePerson);

            if (person.getSex() == Sex.FEMALE) {
                this.tree.addPersonInLayer(newFemaleLayer, person);
            } else {
                this.tree.addPersonInLayer(newMaleLayer, person);
            }

            int newMaleSize = this.tree.getLayerSize(newMaleLayer);
            int newFemaleSize = this.tree.getLayerSize(newFemaleLayer);
            
            boolean minMaleAmmount = (newMaleSize >= this.minSizePerLayer);
            boolean minFemaleAmmount = (newFemaleSize >= this.minSizePerLayer);

            if (minFemaleAmmount && minMaleAmmount) {
                break;
            }
        }
    }
}
