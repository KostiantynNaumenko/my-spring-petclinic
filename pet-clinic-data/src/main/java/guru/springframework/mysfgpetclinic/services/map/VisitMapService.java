package guru.springframework.mysfgpetclinic.services.map;

import guru.springframework.mysfgpetclinic.model.Pet;
import guru.springframework.mysfgpetclinic.model.Visit;
import guru.springframework.mysfgpetclinic.services.PetService;
import guru.springframework.mysfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("map")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private final PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Visit save(Visit visit) {

        if(visit != null) {
            Pet pet = visit.getPet();
            if(pet != null) {
                if (pet.getId() == null) {
                    petService.save(pet);
                }

                return super.save(visit);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
