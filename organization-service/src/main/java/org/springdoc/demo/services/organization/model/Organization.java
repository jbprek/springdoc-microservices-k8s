package org.springdoc.demo.services.organization.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Organization {

	private Long id;
	private String name;
	private String address;

	public Organization(String name, String address) {
		this.name = name;
		this.address = address;
	}
}
