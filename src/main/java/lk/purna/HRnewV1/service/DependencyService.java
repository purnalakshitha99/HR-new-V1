package lk.purna.HRnewV1.service;

import lk.purna.HRnewV1.controller.model.Dependencies;
import lk.purna.HRnewV1.controller.request.DependencyRequest;
import lk.purna.HRnewV1.controller.response.DependencyResponse;
import lk.purna.HRnewV1.exception.DependenciesNotFoundException;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;

import java.util.List;

public interface DependencyService {

    DependencyResponse add(Long employeeId, DependencyRequest dependencyRequest)throws EmployeeNotFoundException;

    List<DependencyResponse> getAll();

    DependencyResponse getSpecificDependencies(Long employeeId,Long dependenciesId)throws EmployeeNotFoundException,DependenciesNotFoundException;

    DependencyResponse updateSpecificDependencies(Long employeeId,Long dependenciesId,DependencyRequest dependencyRequest)throws EmployeeNotFoundException,DependenciesNotFoundException;

    List<DependencyResponse> getSpecificDependenciesList(Long employeeId)throws EmployeeNotFoundException,DependenciesNotFoundException;

    DependencyResponse deleteSpecificDependencies(Long employeeId,Long dependenciesId)throws EmployeeNotFoundException, DependenciesNotFoundException;
}
