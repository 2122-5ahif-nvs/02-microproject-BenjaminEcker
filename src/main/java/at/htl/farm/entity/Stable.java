package at.htl.farm.entity;

import java.util.LinkedList;
import java.util.List;

public class Stable {
    private Long id;
    private List<Animal> animals;
    private List<HarvestGood> harvestGoods;

    public Stable() {
        this.animals = new LinkedList<>();
        this.harvestGoods = new LinkedList<>();
    }

    public Stable(Long id, List<Animal> animals, List<HarvestGood> harvestGoods) {
        this.id = id;
        this.animals = new LinkedList<>();
        this.harvestGoods = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<HarvestGood> getHarvestGoods() {
        return harvestGoods;
    }

    public void setHarvestGoods(List<HarvestGood> harvestGoods) {
        this.harvestGoods = harvestGoods;
    }

    @Override
    public String toString() {
        return "Stable{" +
                "id=" + id +
                ", animals=" + animals +
                ", harvestGoods=" + harvestGoods +
                '}';
    }
}
