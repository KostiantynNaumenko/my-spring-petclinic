package guru.springframework.mysfgpetclinic.services.map;

import guru.springframework.mysfgpetclinic.model.Owner;
import guru.springframework.mysfgpetclinic.model.Pet;
import guru.springframework.mysfgpetclinic.services.OwnerService;
import guru.springframework.mysfgpetclinic.services.PetService;
import guru.springframework.mysfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@Profile("map")
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {

        if (owner != null) {
            if (owner.getPets().size() > 0) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType().getId() != null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else {
                        throw new RuntimeException("Pet Type is Required!");
                    }

                    if (pet.getId() != null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() instanceof Owner) {
                Owner tempOwner = (Owner) entry.getValue();
                if (tempOwner.getLastName().equals(lastName)) return tempOwner;
            }
        }
        return null;
    }
}
