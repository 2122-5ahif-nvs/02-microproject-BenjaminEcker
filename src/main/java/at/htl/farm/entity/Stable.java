package at.htl.farm.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Stable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "animal_id")
    private List<Animal> animals;
    @OneToMany
    @JoinColumn(name = "harvest_good_id")
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

    public void addAnimals(Animal animal){
        if(!animals.contains(animal)){
            animals.add(animal);
        }
        throw new IllegalArgumentException("Animal already in Stable");
    }

    public void addHarvestGood(HarvestGood harvestGood) {
        if(!harvestGoods.contains(harvestGood)) {
            harvestGoods.add(harvestGood);
        }
        throw new IllegalArgumentException("Harvest Good already in Stable");
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
