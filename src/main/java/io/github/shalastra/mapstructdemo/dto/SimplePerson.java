package io.github.shalastra.mapstructdemo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplePerson {
    
    private String fullName;
    private String fullAddress;
    private List<String> petNames;
}
