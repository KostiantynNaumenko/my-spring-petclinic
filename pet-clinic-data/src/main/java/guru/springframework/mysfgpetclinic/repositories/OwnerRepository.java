package guru.springframework.mysfgpetclinic.repositories;

import guru.springframework.mysfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
