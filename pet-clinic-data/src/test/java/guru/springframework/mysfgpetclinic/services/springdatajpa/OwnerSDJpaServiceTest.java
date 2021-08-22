package guru.springframework.mysfgpetclinic.services.springdatajpa;

import guru.springframework.mysfgpetclinic.model.Owner;
import guru.springframework.mysfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    private final Owner returnOwner = new Owner();
    private Set<Owner> returnOwnerSet;
    private final Owner returnOwner2 = new Owner();
    @BeforeEach

    void setUp() {
        returnOwner.setLastName(LAST_NAME);
        returnOwner.setId(1L);

        returnOwner2.setId(2L);

        returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(returnOwner);
        returnOwnerSet.add(returnOwner2);
    }

    @Test
    void save() {
        Owner savebleOwner = new Owner();
        savebleOwner.setId(3L);
        when(ownerRepository.save(any())).thenReturn(savebleOwner);

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
        service.save(returnOwner);
        returnOwnerSet.add(savebleOwner);

        Set<Owner> owners = service.findAll();

        assertEquals(3, owners.size());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(returnOwner);

        Owner owner = service.findByLastName(LAST_NAME);

        assertNotNull(owner);
    }
}