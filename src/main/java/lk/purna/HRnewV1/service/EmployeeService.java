package lk.purna.HRnewV1.service;

import lk.purna.HRnewV1.controller.request.EmployeeRequest;
import lk.purna.HRnewV1.controller.response.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse add(EmployeeRequest employeeRequest);

    EmployeeResponse get(Long employeeId);

    EmployeeResponse update(Long employeeId,EmployeeRequest employeeRequest);
}
