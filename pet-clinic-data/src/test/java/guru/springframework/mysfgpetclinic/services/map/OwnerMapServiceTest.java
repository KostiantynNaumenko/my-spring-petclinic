package guru.springframework.mysfgpetclinic.services.map;

import guru.springframework.mysfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    private final Long owner1ID = 1L;
    private final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        Owner owner1 = new Owner();
        owner1.setId(owner1ID);
        owner1.setLastName(lastName);

        ownerMapService.save(owner1);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(owners.size(), 1);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(owner1ID);

        assertEquals(owner.getId(), owner1ID);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner = new Owner();
        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertEquals(id, savedOwner.getId());
    }

    void saveNoId() {
        Owner savedOwner = ownerMapService.save(new Owner());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(owner1ID);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(owner1ID));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner foundedOwner = ownerMapService.findByLastName(lastName);

        assertNotNull(foundedOwner);
        assertEquals(owner1ID, foundedOwner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner foundedOwner = ownerMapService.findByLastName("foo");

        assertNull(foundedOwner);
    }
}