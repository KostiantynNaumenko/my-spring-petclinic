package guru.springframework.mysfgpetclinic.repositories;

import guru.springframework.mysfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
