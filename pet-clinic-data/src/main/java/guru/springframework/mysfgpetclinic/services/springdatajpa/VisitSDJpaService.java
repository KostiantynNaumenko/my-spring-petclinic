package guru.springframework.mysfgpetclinic.services.springdatajpa;

import guru.springframework.mysfgpetclinic.model.Pet;
import guru.springframework.mysfgpetclinic.model.Visit;
import guru.springframework.mysfgpetclinic.repositories.PetRepository;
import guru.springframework.mysfgpetclinic.repositories.VisitRepository;
import guru.springframework.mysfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;
    private final PetRepository petRepository;

    public VisitSDJpaService(VisitRepository visitRepository, PetRepository petRepository) {
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Visit save(Visit visit) {

        if(visit != null) {
            Pet pet = visit.getPet();
            if(pet != null) {
                if (pet.getId() == null) {
                    petRepository.save(pet);
                }

                return visitRepository.save(visit);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }
}
