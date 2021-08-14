package guru.springframework.mysfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

    Set<T> findAll();

    T findById(ID id);
}
