package guru.springframework.mysfgpetclinic.services.map;

import guru.springframework.mysfgpetclinic.model.Pet;
import guru.springframework.mysfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }
}
