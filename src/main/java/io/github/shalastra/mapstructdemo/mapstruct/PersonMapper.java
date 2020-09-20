package io.github.shalastra.mapstructdemo.mapstruct;

import io.github.shalastra.mapstructdemo.dto.ExtendedPerson;
import io.github.shalastra.mapstructdemo.entity.Person;
import io.github.shalastra.mapstructdemo.entity.Pet;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source = "address.streetName", target = "streetName")
    @Mapping(source = "address.houseNo", target = "houseNo")
    @Mapping(source = "address.cityName", target = "cityName")
    @Mapping(source = "address.zipCode", target = "zipCode")
    ExtendedPerson toDto(Person person);

    List<Map<String, String>> mapPets(List<Pet> pets);
    
    default Map<String, String> map(Pet pet) {
        return Map.of(pet.getPetType().toString().toLowerCase(), pet.getName());
    }
}