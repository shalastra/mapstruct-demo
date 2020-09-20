package io.github.shalastra.mapstructdemo.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtendedPerson {
    
    private String firstName;
    private String lastName;
    private String age;
    private String streetName;
    private String houseNo;
    private String zipCode;
    private String cityName;
    private List<Map<String, String>> pets; 
}
