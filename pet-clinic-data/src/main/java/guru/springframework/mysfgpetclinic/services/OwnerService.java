package guru.springframework.mysfgpetclinic.services;

import guru.springframework.mysfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
