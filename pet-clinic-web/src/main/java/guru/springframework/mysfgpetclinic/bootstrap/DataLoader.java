package guru.springframework.mysfgpetclinic.bootstrap;

import guru.springframework.mysfgpetclinic.model.Owner;
import guru.springframework.mysfgpetclinic.model.Pet;
import guru.springframework.mysfgpetclinic.model.PetType;
import guru.springframework.mysfgpetclinic.model.Vet;
import guru.springframework.mysfgpetclinic.services.OwnerService;
import guru.springframework.mysfgpetclinic.services.PetTypeService;
import guru.springframework.mysfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Backer str");
        owner1.setCity("London");
        owner1.setTelephone("123456");

        Pet mikesPet = new Pet();
        mikesPet.setName("Boby");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner1.setAddress("123b Paper str");
        owner1.setCity("Bruklin");
        owner1.setTelephone("120987");

        Pet fionasPet = new Pet();
        fionasPet.setName("Billy");
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setOwner(owner2);
        owner1.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
