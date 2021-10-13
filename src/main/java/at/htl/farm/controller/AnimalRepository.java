package at.htl.farm.controller;

import at.htl.farm.entity.Animal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class AnimalRepository implements PanacheRepository<Animal> {
    @Inject
    EntityManager em;

    @Transactional
    public Animal addAnimal(Animal animal) {
        if(findById(animal.getId()) != null) {
            em.merge(animal);
            return animal;
        }
        throw new IllegalArgumentException("Animal already exists");
    }

    @Transactional
    public Animal updateAnimal(Animal animal) {
        if(findById(animal.getId()) == null) {
            em.merge(animal);
            return animal;
        }
        throw new IllegalArgumentException("Animal doesn't exists");
    }

    @Transactional
    public void deleteAnimal(Long id){
        if(findById(id) == null) {
            em.remove(findById(id));
        }
        throw new IllegalArgumentException("Animal doesn't exists");
    }
}
