package lk.purna.HRnewV1.service;

import lk.purna.HRnewV1.controller.request.DepartmentRequest;
import lk.purna.HRnewV1.controller.response.DepartmentResponseBuilder;

public interface DepartmentService {

    DepartmentResponseBuilder add(DepartmentRequest departmentRequest);
}
