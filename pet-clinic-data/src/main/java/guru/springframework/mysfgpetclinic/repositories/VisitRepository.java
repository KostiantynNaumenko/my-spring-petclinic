package guru.springframework.mysfgpetclinic.repositories;

import guru.springframework.mysfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
