package guru.springframework.mysfgpetclinic.services.springdatajpa;

import guru.springframework.mysfgpetclinic.model.Speciality;
import guru.springframework.mysfgpetclinic.model.Vet;
import guru.springframework.mysfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.mysfgpetclinic.repositories.VetRepository;
import guru.springframework.mysfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"springdatajpa", "default"})
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialityRepository specialityRepository;

    public VetSDJpaService(VetRepository vetRepository, SpecialityRepository specialityRepository) {
        this.vetRepository = vetRepository;
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Vet save(Vet vet) {

        if (vet != null) {
            if (vet.getSpecialities().size() > 0) {
                vet.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpeciality = specialityRepository.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }

            return vetRepository.save(vet);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }
}
