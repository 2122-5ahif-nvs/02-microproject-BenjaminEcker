package at.htl.farm.controller;

import at.htl.farm.entity.Animal;
import at.htl.farm.entity.HarvestGood;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class HarvestGoodRepository implements PanacheRepository<HarvestGood> {
    @Inject
    EntityManager em;

    public HarvestGood addHarvestGood(HarvestGood harvestGood){
        if(findById(harvestGood.getId()) != null) {
            em.merge(harvestGood);
            return harvestGood;
        }
        throw new IllegalArgumentException("Harvest Good already exists");
    }

    @Transactional
    public HarvestGood updateHarvestGood(HarvestGood harvestGood) {
        if(findById(harvestGood.getId()) == null) {
            em.merge(harvestGood);
            return harvestGood;
        }
        throw new IllegalArgumentException("Harvest Good doesn't exists");
    }

    @Transactional
    public void deleteHarvestGood(Long id){
        if(findById(id) == null) {
            em.remove(findById(id));
        }
        throw new IllegalArgumentException("Harvest Good doesn't exists");
    }
}
