package controller;

import model.Home;
import model.ProceduralFactory;
import model.ProceduralGeneration;
import model.Utility;

import java.util.Random;

public class HomeFactory implements ProceduralFactory {

    private Random random;
    private RandomString randomString;

    private int maxNameSize;
    private int minNameSize;

    public HomeFactory() {
        this.random = new Random();
        this.randomString = new RandomString();

        this.maxNameSize = 9;
        this.minNameSize = 3;
    }

    public void setMaxNameSize(int maxNameSize) {
        if (maxNameSize > this.minNameSize) {
            this.maxNameSize = maxNameSize;
        }
    }

    public void setMinNameSize(int minNameSize) {
        if (minNameSize <= 0) {
            this.minNameSize = minNameSize;
        }
    }

    @Override
    public ProceduralGeneration create() {

        int nameSize = this.minNameSize + random.nextInt(this.maxNameSize);

        String placeName = this.randomString.generateName(nameSize);

        Utility utility = RandomizeEnum.randomUtility();

        ProceduralGeneration home = new Home(placeName, utility);
        return home;
    }

}
