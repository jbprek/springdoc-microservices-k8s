package org.springdoc.demo.services.organization.service;


import org.mapstruct.Mapper;
import org.springdoc.demo.services.organization.model.Employee;
import org.springdoc.demo.services.organization.model.EmployeeView;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeView entityToView(Employee employee);
    List<EmployeeView> entityListToViewList(List<Employee> employee);
}
