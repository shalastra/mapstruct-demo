package io.github.shalastra.mapstructdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String streetName;
	private String houseNo;
	private String cityName;
	private String zipCode;
}