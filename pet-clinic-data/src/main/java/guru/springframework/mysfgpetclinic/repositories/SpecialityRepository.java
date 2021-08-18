package guru.springframework.mysfgpetclinic.repositories;

import guru.springframework.mysfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
