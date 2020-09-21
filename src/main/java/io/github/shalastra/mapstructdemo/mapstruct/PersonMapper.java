package io.github.shalastra.mapstructdemo.mapstruct;

import io.github.shalastra.mapstructdemo.dto.ExtendedPerson;
import io.github.shalastra.mapstructdemo.entity.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PetMapper.class})
public interface PersonMapper {

    @Mapping(source = "address.streetName", target = "streetName")
    @Mapping(source = "address.houseNo", target = "houseNo")
    @Mapping(source = "address.cityName", target = "cityName")
    @Mapping(source = "address.zipCode", target = "zipCode")
    ExtendedPerson toDto(Person person);

    @InheritInverseConfiguration
    Person fromDto(ExtendedPerson extendedPerson);
}