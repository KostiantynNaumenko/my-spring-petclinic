package guru.springframework.mysfgpetclinic.services.map;

import guru.springframework.mysfgpetclinic.model.Owner;
import guru.springframework.mysfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
        return super.save(owner);
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
