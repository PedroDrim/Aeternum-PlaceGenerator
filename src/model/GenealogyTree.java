package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenealogyTree {

    private Map<String, List<Person>> tree;

    public GenealogyTree() {
        this.tree = new HashMap();
    }

    public void newLayer(String layer) {
        List<Person> list = new ArrayList();
        this.tree.put(layer, list);
    }
    
    public void removeLayer(String layer){
        this.tree.remove(layer);
    }

    public String[] getLayers() {
        Set<String> keys = this.tree.keySet();
        String[] obj = keys.toArray(new String[keys.size()]);
        return obj;
    }

    public List<Person> getListByLayer(String layer) {
        return this.tree.get(layer);
    }

    public void addPersonInLayer(String layer, Person person) {
        List<Person> list = this.tree.get(layer);
        list.add(person);

        this.tree.put(layer, list);
    }

    public void removePersonInLayer(String layer, int index) {
        List<Person> list = this.tree.get(layer);
        list.remove(index);

        this.tree.put(layer, list);
    }

    public Person getPersonInLayer(String layer, int index) {
        List<Person> list = this.tree.get(layer);
        return list.get(index);
    }

    public int getMaxSize() {
        int maxSize = 0;

        for (List<Person> l : this.tree.values()) {
            maxSize += l.size();
        }

        return maxSize;
    }

    public int getLayerSize(String layer) {
        List<Person> list = this.tree.get(layer);

        return list.size();
    }
}
