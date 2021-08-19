package guru.springframework.mysfgpetclinic.services.springdatajpa;

import guru.springframework.mysfgpetclinic.model.Visit;
import guru.springframework.mysfgpetclinic.repositories.PetRepository;
import guru.springframework.mysfgpetclinic.repositories.VisitRepository;
import guru.springframework.mysfgpetclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile({"springdatajpa", "default"})
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository, PetRepository petRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null
                || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return visitRepository.save(visit);
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
