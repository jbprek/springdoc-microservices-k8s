package org.springdoc.demo.services.organization.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Department {

	public Department(Long organizationId, String name) {
		this.organizationId = organizationId;
		this.name = name;
	}

	private Long id;
	private Long organizationId;
	private String name;

}
