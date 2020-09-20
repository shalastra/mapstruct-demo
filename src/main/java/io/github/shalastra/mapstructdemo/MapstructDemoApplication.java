package io.github.shalastra.mapstructdemo;

import io.github.shalastra.mapstructdemo.dto.ExtendedPerson;
import io.github.shalastra.mapstructdemo.entity.Address;
import io.github.shalastra.mapstructdemo.entity.Person;
import io.github.shalastra.mapstructdemo.entity.Pet;
import io.github.shalastra.mapstructdemo.entity.PetType;
import io.github.shalastra.mapstructdemo.mapstruct.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class MapstructDemoApplication implements CommandLineRunner {

    private final PersonMapper personMapper;

    public MapstructDemoApplication(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MapstructDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Pet dog = new Pet(PetType.DOG, "cat");
        Pet cat = new Pet(PetType.CAT, "dog");

        Address bobAddress = new Address("Street", "1", "Warsaw", "112233");

        Person bob = new Person("Bob", "Mock", 27, bobAddress, List.of(dog, cat));

		ExtendedPerson extendedPerson = personMapper.toDto(bob);

		log.info(extendedPerson.toString());
	}
}