package org.springdoc.demo.services.organization.client;

import java.util.List;

import org.springdoc.demo.services.organization.model.Employee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${app.feign.employee-service.name}", url = "${app.feign.employee-service.url}")
public interface EmployeeClient {

	@GetMapping("/organization/{organizationId}")
	List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId);
	
}
