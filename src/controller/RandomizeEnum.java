package controller;

import model.Economy;
import model.Regency;
import model.Sex;
import model.Utility;

import java.util.Random;

public class RandomizeEnum {

    public static Utility randomUtility() {

        Random random = new Random();

        Utility utility;
        int option = random.nextInt(13);
        switch (option) {
            case 0:
            case 1:
                utility = Utility.BIG_HOUSE;
                break;

            case 2:
            case 3:
            case 11:
                utility = Utility.MEDIUM_HOUSE;
                break;

            case 4:
            case 5:
            case 10:
            case 12:
                utility = Utility.SMALL_HOUSE;
                break;

            case 6:
                utility = Utility.PUB;
                break;

            case 7:
                utility = Utility.SHOP;
                break;

            case 8:
                utility = Utility.INN;
                break;

            case 9:
                utility = Utility.ABANDONED;
                break;

            default:
                utility = Utility.SMALL_HOUSE;
        }

        return utility;
    }

    public static Economy randomEconomy() {

        Random random = new Random();
        Economy economy;

        int option = random.nextInt(4);
        switch (option) {
            case 0:
                economy = Economy.MINNING;
                break;

            case 1:
                economy = Economy.SELF_SUSTAIN;
                break;

            case 2:
                economy = Economy.TOURISM;
                break;

            case 3:
                economy = Economy.TRADE;
                break;

            default:
                economy = Economy.ANOTHER;
        }

        return economy;
    }

    public static Regency randomRegency() {

        Random random = new Random();
        Regency regency;

        int option = random.nextInt(32);
        switch (option) {
            case 0:
            case 1:
            case 2:
                regency = Regency.RUNIC;
                break;

            case 3:
            case 4:
            case 5:
                regency = Regency.SHOOTER;
                break;

            case 6:
            case 7:
            case 8:
                regency = Regency.ILLUSIONIST;
                break;

            case 9:
            case 10:
            case 11:
                regency = Regency.METAPHISIC;
                break;

            case 12:
            case 13:
            case 14:
                regency = Regency.ORACLE;
                break;

            case 15:
            case 16:
            case 17:
                regency = Regency.SUMMONER;
                break;

            case 18:
            case 19:
            case 20:
                regency = Regency.TAMER;
                break;

            case 21:
            case 22:
            case 23:
                regency = Regency.WARRIOR;
                break;

            case 24:
            case 25:
            case 26:
                regency = Regency.WILY;
                break;

            case 27:
            case 28:
            case 29:
                regency = Regency.WIZARD;
                break;

            case 30:
                regency = Regency.ARCAN;
                break;

            case 31:
                regency = Regency.GRUNPH;
                break;

            default:
                regency = Regency.GRUNPH;
        }

        return regency;
    }

    public static Sex randomSex() {

        Random random = new Random();
        Sex sex = random.nextBoolean()? Sex.MALE : Sex.FEMALE;

        return sex;
    }
}
