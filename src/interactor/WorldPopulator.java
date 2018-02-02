package interactor;

import model.*;

import java.util.Random;

/**
 * Gera um mundo preenchido
 * @see model.Populator
 */
public class WorldPopulator implements Populator {

    /**
     * Objeto para geração de pessoas
     * @see PersonFactory
     */
    private PersonFactory factory;

    /**
     * Arvore genealogica
     * @see GenealogyTree
     */
    private GenealogyTree tree;

    /**
     * Quantidade de camadas
     */
    private int layer;

    /**
     * Tamanho minimo de pessoas por camada
     */
    private int minSizePerLayer;

    /**
     * Tag masculino
     */
    private String maleTag = "M";

    /**
     * Tag feminimo
     */
    private String femaleTag = "F";

    /**
     * Construtor para inicializar os objetos principais
     * @param factory Objeto para geração de pessoas
     */
    public WorldPopulator(PersonFactory factory, int minSizePerLayer) {

        this.layer = 0;
        this.minSizePerLayer = minSizePerLayer;
        
        this.factory = factory;
        this.tree = new GenealogyTree();
        this.tree.newLayer(this.maleTag + this.layer);
        this.tree.newLayer(this.femaleTag + this.layer);
    }

    /**
     * Inicia a geração.
     * @param maxGeneration Quantidade profundidade máxima de geração
     * @return Arvore genealogica gerada
     */
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

    /**
     * Busca o tamanho das camadas
     * @return Tamanho das camadas
     */
    @Override
    public int layerSize(){
        return this.layer;
    }

    /**
     * Execussão da primeira geração
     */
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

    /**
     * Execussão das gerações posteriores a primeira
     */
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
