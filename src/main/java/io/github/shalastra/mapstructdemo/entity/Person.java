package io.github.shalastra.mapstructdemo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	private List<Pet> pets;
}