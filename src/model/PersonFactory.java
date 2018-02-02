package model;

/**
 * Interface para a geração de pessoas
 */
public interface PersonFactory {

    /**
     * Gera uma pessoa partido de outras duas
     * @param father pessoa do sexo masculino
     * @param mother pessoa do sexo feminimo
     * @see Person
     * @return uma nova pessoa
     */
    Person born(Person father, Person mother);

    /**
     * Gera uma pessoa partindo do nada
     * @return uma nova pessoa
     * @see Person
     */
    Person spawn();
}
