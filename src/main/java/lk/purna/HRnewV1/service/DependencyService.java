package lk.purna.HRnewV1.service;

import lk.purna.HRnewV1.controller.request.DependencyRequest;
import lk.purna.HRnewV1.controller.response.DependencyResponse;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;

import java.util.List;

public interface DependencyService {

    DependencyResponse add(Long employeeId, DependencyRequest dependencyRequest)throws EmployeeNotFoundException;

    List<DependencyResponse> getAll();
}
