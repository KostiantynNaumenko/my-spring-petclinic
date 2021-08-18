package guru.springframework.mysfgpetclinic.repositories;

import guru.springframework.mysfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
