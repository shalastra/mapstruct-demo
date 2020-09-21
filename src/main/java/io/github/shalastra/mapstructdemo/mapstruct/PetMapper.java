package io.github.shalastra.mapstructdemo.mapstruct;

import io.github.shalastra.mapstructdemo.entity.Pet;
import io.github.shalastra.mapstructdemo.entity.PetType;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface PetMapper {

    List<Map<String, String>> mapPets(List<Pet> pets);

    List<Pet> mapPetsFromDto(List<Map<String, String>> pets);

    default Map<String, String> map(Pet pet) {
        return Map.of(pet.getPetType().toString().toLowerCase(), pet.getName());
    }

    default Pet map(Map<String, String> pets) {
        return pets.entrySet()
                .stream()
                .map(entry -> new Pet(PetType.valueOf(entry.getKey()), entry.getValue()))
                .findFirst()
                .orElseThrow();
    }
}
