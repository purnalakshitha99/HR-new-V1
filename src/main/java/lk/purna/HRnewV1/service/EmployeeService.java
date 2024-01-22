package lk.purna.HRnewV1.service;

import lk.purna.HRnewV1.controller.request.EmployeeRequest;
import lk.purna.HRnewV1.controller.response.EmpResponseBuilder;
import lk.purna.HRnewV1.controller.response.EmployeeResponse;
import lk.purna.HRnewV1.controller.response.MessageResponse;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse add(EmployeeRequest employeeRequest);

    EmployeeResponse get(Long employeeId)throws EmployeeNotFoundException;

    EmployeeResponse update(Long employeeId,EmployeeRequest employeeRequest)throws EmployeeNotFoundException;

    MessageResponse delete(Long employeeId)throws EmployeeNotFoundException;

    List<EmpResponseBuilder> getAll();
}
