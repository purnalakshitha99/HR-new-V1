package lk.purna.HRnewV1.service.impl;

import lk.purna.HRnewV1.controller.model.Department;
import lk.purna.HRnewV1.controller.repository.DepartmentRepository;
import lk.purna.HRnewV1.controller.request.DepartmentRequest;
import lk.purna.HRnewV1.controller.response.DepartmentResponseBuilder;
import lk.purna.HRnewV1.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentResponseBuilder add(DepartmentRequest departmentRequest){

        Department department = new Department();

        department.setName(departmentRequest.getName());

        departmentRepository.save(department);

        return DepartmentResponseBuilder.builder().id(department.getId()).name(department.getName()).build();

    }

}
