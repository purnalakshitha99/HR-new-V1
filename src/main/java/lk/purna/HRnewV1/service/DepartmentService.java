package lk.purna.HRnewV1.service;

import lk.purna.HRnewV1.controller.request.DepartmentRequest;
import lk.purna.HRnewV1.controller.response.DepartmentResponseBuilder;
import lk.purna.HRnewV1.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseBuilder add(DepartmentRequest departmentRequest);

    DepartmentResponseBuilder getSpecific(Long departmentId)throws DepartmentNotFoundException;

    List<DepartmentResponseBuilder> getAll();
}
