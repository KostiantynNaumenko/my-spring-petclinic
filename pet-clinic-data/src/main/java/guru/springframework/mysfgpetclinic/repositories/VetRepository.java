package guru.springframework.mysfgpetclinic.repositories;

import guru.springframework.mysfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
