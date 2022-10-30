package org.springdoc.demo.services.organization.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.demo.services.organization.model.Department;
import org.springdoc.demo.services.organization.model.Organization;
import org.springdoc.demo.services.organization.model.OrganizationView;
import org.springdoc.demo.services.organization.repository.DepartmentRepository;
import org.springdoc.demo.services.organization.repository.OrganizationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class OrganizationController {

	
	private OrganizationRepository organizationRepository;
	private DepartmentRepository departmentRepository;


	@PostMapping("/organizations")
	public Organization add(@RequestBody Organization organization) {
		log.info("Organization add: {}", organization);
		return organizationRepository.add(organization);
	}
	
	@GetMapping("/organizations")
	public List<Organization> findAll() {
		log.info("Organization find");
		return organizationRepository.findAll();
	}
	
	@GetMapping("/organizations/{id}")
	public Organization findById(@PathVariable("id") Long id) {
		log.info("Organization find: id={}", id);
		return organizationRepository.findById(id);
	}

	@GetMapping("/organizations/{id}/departments")
	public OrganizationView findByIdWithDepartments(@PathVariable("id") Long id) {
		log.info("Organization find: id={}", id);
		var organization = organizationRepository.findById(id);
		var departments = departmentRepository.findByOrganization(id);
		return OrganizationView.of(organization.getId(),
				organization.getName(),
				organization.getAddress(),
				departments);
	}

	@PostMapping("/departments")
	public Department addDepartment(@RequestBody Department department) {
		log.info("Department add: {}", department);
		return departmentRepository.add(department);
	}

	@GetMapping("/departments")
	public List<Department> findAllDepartments() {
		log.info("Department find");
		return departmentRepository.findAll();
	}

	@GetMapping("/departments/{id}")
	public Department findDepartmentById(@PathVariable("id") Long id) {
		log.info("Department find: id={}", id);
		return departmentRepository.findById(id);
	}
	

	
}
