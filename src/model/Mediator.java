package model;

/**
 * Interface que insere coisas dentro de outras coisas
 */
public interface Mediator {

    /**
     * Insere coisas dentro de outras coisas
     * @param place Objeto contendo as coisas a serem preenchidas
     * @return Objeto preenchido
     * @see interactor.PlaceMediator
     * @see interactor.PersonMediator
     */
    ProceduralGeneration call(ProceduralGeneration place);
}
