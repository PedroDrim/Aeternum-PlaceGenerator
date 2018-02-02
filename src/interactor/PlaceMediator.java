package interactor;

import model.Mediator;
import model.ProceduralFactory;
import model.ProceduralGeneration;

import java.util.Random;

/**
 * Classe responsável por distribuir os locais dentro de outros locais
 * @see model.Mediator
 */
public class PlaceMediator implements Mediator {

    /**
     * Objeto responsável por gerar os locais de forma randomica
     * @see ProceduralFactory
     */
    private ProceduralFactory factory;

    /**
     * Construtor inicial
     * @param factory objeto responsável por gerar os locais
     */
    public PlaceMediator(ProceduralFactory factory) {
        this.factory = factory;
    }

    /**
     * Insere locais dentro de outros locais
     * @param place Objeto contendo as coisas a serem preenchidas
     * @return Objeto preenchido
     * @see Mediator
     */
    @Override
    public ProceduralGeneration call(ProceduralGeneration place) {

        int max = place.getMaxPlaceAmmount();

        for (int index = 0; index < max; index++) {

            ProceduralGeneration newPlace = this.factory.create();
            this.call(newPlace);
            place.insertPlace(index, newPlace);
        }

        return place;
    }
}
