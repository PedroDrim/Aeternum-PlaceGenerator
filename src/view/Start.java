package view;

public class Start {

    public static void main(String[] args) {

        WorldGenerator universe = new WorldGenerator();
        universe.update_MAX_HOME_AMMOUNT_PER_CITY(10);
        universe.generateRandomCity();
    }
}
