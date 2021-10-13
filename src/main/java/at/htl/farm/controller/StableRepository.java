package at.htl.farm.controller;

import at.htl.farm.entity.Animal;
import at.htl.farm.entity.Stable;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class StableRepository implements PanacheRepository<Stable> {
    @Inject
    EntityManager em;

    @Inject
    AnimalRepository animalRepository;

    @Inject
    HarvestGoodRepository harvestGoodRepository;

    @Transactional
    public Stable addStable(Stable stable) {
        if(findById(stable.getId()) != null) {
            em.merge(stable);
            return stable;
        }
        throw new IllegalArgumentException("Stable already exists");
    }

    @Transactional
    public void deleteStable(Long id){
        if(findById(id) == null) {
            em.remove(findById(id));
        }
        throw new IllegalArgumentException("Stable doesn't exists");
    }

    public void addAnimalToStable(Long stableId, Long animalId){
        if(animalRepository.findById(animalId) != null) {
            findById(stableId).addAnimals(animalRepository.findById(animalId));
        }
    }

    public void addHarvestGoodToStable(Long stableId, Long harvestGoodId){
        if(harvestGoodRepository.findById(harvestGoodId) != null){
            findById(stableId).addHarvestGood(harvestGoodRepository.findById(harvestGoodId));
        }
    }
}
