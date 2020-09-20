package io.github.shalastra.mapstructdemo.classic;

import io.github.shalastra.mapstructdemo.dto.ExtendedPerson;
import io.github.shalastra.mapstructdemo.dto.SimplePerson;
import io.github.shalastra.mapstructdemo.entity.Address;
import io.github.shalastra.mapstructdemo.entity.Person;
import io.github.shalastra.mapstructdemo.entity.Pet;
import io.github.shalastra.mapstructdemo.entity.PetType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonMapper {

    public static SimplePerson toDto(Person person) {
        SimplePerson simplePerson = new SimplePerson();

        String fullName = person.getFirstName() + " " + person.getLastName();
        String fullAddress = "";

        if (person.getAddress() != null) {
            String street = person.getAddress().getStreetName() + " " + person.getAddress().getHouseNo();
            String cityWithZipCode = person.getAddress().getZipCode() + " " + person.getAddress().getCityName();

            fullAddress = street + " " + cityWithZipCode;
        }

        simplePerson.setFullName(fullName);
        simplePerson.setFullAddress(fullAddress);
        simplePerson.setPetNames(person.getPets().stream().map(Pet::getName).collect(Collectors.toList()));

        return simplePerson;
    }

    public static Person fromDto(ExtendedPerson extendedPerson) {
        Person person = new Person();

        person.setFirstName(extendedPerson.getFirstName());
        person.setLastName(extendedPerson.getLastName());
        person.setAge(Integer.parseInt(extendedPerson.getAge()));

        Address address = new Address();
        address.setStreetName(extendedPerson.getStreetName());
        address.setHouseNo(extendedPerson.getHouseNo());
        address.setCityName(extendedPerson.getCityName());
        address.setZipCode(extendedPerson.getZipCode());

        List<Pet> pets = extendedPerson
                .getPets()
                .stream()
                .flatMap(o -> o.entrySet()
                        .stream()
                        .map(PersonMapper::create))
                .collect(Collectors.toList());

        person.setAddress(address);
        person.setPets(pets);

        return person;
    }

    private static Pet create(Map.Entry<String, String> entry) {
        return new Pet(PetType.valueOf(entry.getKey()), entry.getValue());
    }
}
