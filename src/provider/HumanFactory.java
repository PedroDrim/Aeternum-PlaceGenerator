package provider;

import model.*;

import java.util.Random;

/**
 * Classe responsavel por gerar uma pessoa aleatoriamente
 * @see model.PersonFactory
 */
public class HumanFactory implements PersonFactory {

    /**
     * Principio da aleatoriedade
     */
    private Random random;

    /**
     * String randomica
     */
    private RandomString randomString;

    /**
     * Tamanho máximo de nome
     */
    private int maxNameSize;

    /**
     * Tamanho miinimo de nome
     */
    private int minNameSize;

    /**
     * Construtor responsável por inicializar as variaveis principais
     */
    public HumanFactory(int maxNameSize, int minNameSize) {
        this.random = new Random();
        this.randomString = new RandomString();
        this.maxNameSize = maxNameSize;
        this.minNameSize = minNameSize;
    }

    /**
     * Gera uma pessoa partindo do nada
     * @return uma nova pessoa
     * @see Person
     */
    @Override
    public Person spawn() {

        int firstNameSize = minNameSize + random.nextInt(this.maxNameSize);
        int secondNameSize = minNameSize + random.nextInt(this.maxNameSize);

        String personName = this.randomString
                .generatePersonName(firstNameSize, secondNameSize);

        Sex sex = RandomizeEnum.randomSex();
        Regency regency = RandomizeEnum.randomRegency();

        return new Human(personName, sex, regency);
    }

    /**
     * Gera uma pessoa partido de outras duas
     * @param father pessoa do sexo masculino
     * @param mother pessoa do sexo feminimo
     * @see Person
     * @return uma nova pessoa
     */
    @Override
    public Person born(Person father, Person mother) {

        int firstNameSize = minNameSize + random.nextInt(this.maxNameSize);
        int secondNameSize = minNameSize + random.nextInt(this.maxNameSize);

        String personName = this.randomString
                .generatePersonName(firstNameSize, secondNameSize);

        Sex sex = RandomizeEnum.randomSex();
        Regency regency = RandomizeEnum.randomRegency();

        Person parent =  this.random.nextBoolean()? father : mother;

        personName = personName.split(" ")[0];
        String familyName = parent.getName().split(" ")[1];

        personName = personName + " " + familyName;
        Person person = new Human(personName, sex, regency);

        father.setChildren(person);
        mother.setChildren(person);
        person.setFather(father);
        person.setMother(mother);

        return person;
    }
}
