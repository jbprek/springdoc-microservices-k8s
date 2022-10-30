package org.springdoc.demo.services.organization.service;

import org.mapstruct.Mapper;
import org.springdoc.demo.services.organization.model.Department;
import org.springdoc.demo.services.organization.model.DepartmentView;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentView entityToView(Department entity);
    List<DepartmentView> entityListToViewList(List<Department> entityList);
}
