package org.springdoc.demo.services.organization.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
public class OrganizationView {

	private Long id;
	private String name;
	private String address;

	private List<Department> departments;


}
