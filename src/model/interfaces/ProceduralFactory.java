package model.interfaces;

/**
 * Interface responsável por gerar locais proceduralmente
 */
public interface ProceduralFactory {

    /**
     * Gera locais proceduralmente
     * @return Objeto gerado proceduralmente
     * @see provider.HomeFactory
     * @see provider.CityFactory
     */
    ProceduralGeneration create();
}
