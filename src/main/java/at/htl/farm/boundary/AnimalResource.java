package at.htl.farm.boundary;

import at.htl.farm.controller.AnimalRepository;
import at.htl.farm.entity.Animal;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("animals")
@Tag(name = "Animal")
public class AnimalResource {
    @Inject
    AnimalRepository animalRepository;

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Animal> findAllAnimals(){
        return animalRepository.listAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal findAnimalById(@PathParam("id") Long id){
        return this.animalRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAnimal(Animal animal) {
        return Response.ok(animalRepository.addAnimal(animal), MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAnimal(Animal animal){
        return Response.ok(animalRepository.updateAnimal(animal), MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAnimal(@PathParam("id") Long id){
        return Response.ok().build();
    }
}
