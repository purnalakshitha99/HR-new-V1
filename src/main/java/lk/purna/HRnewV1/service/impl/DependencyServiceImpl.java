package lk.purna.HRnewV1.service.impl;

import lk.purna.HRnewV1.controller.model.Dependencies;
import lk.purna.HRnewV1.controller.model.Employee;
import lk.purna.HRnewV1.controller.repository.DependencyRepository;
import lk.purna.HRnewV1.controller.repository.EmployeeRepository;
import lk.purna.HRnewV1.controller.request.DependencyRequest;
import lk.purna.HRnewV1.controller.response.DependencyResponse;
import lk.purna.HRnewV1.controller.response.EmployeeResponse;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;
import lk.purna.HRnewV1.service.DependencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DependencyServiceImpl implements DependencyService {

    private final DependencyRepository dependencyRepository;
    private final EmployeeRepository employeeRepository;

    public DependencyResponse add(Long employeeId, DependencyRequest dependencyRequest) throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);


        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Not found that Id : " + employeeId);
        } else {

            Employee employee = employeeOptional.get();

            Dependencies dependencies = new Dependencies();

            dependencies.setRelationship(dependencyRequest.getRelationship());
            dependencies.setEmployee(employee);

            dependencyRepository.save(dependencies);

            DependencyResponse dependencyResponse = DependencyResponse.builder().id(dependencies.getId()).relationship(dependencies.getRelationship()).build();

            return dependencyResponse;
        }

    }


    public List<DependencyResponse> getAll() {
        List<Dependencies> dependenciesList = dependencyRepository.findAll();

        return dependenciesList.stream().map(dependencies -> DependencyResponse.builder().id(dependencies.getId()).relationship(dependencies.getRelationship()).build()).toList();
    }

    public DependencyResponse getSpecificDependencies(Long employeeId, Long dependenciesId) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);


        if (!employeeOptional.isPresent()) {

            throw new EmployeeNotFoundException("That employee not found in the database : " + employeeId);

        }

        Employee employee = employeeOptional.get();
        List<Dependencies> dependenciesList = employee.getDependenciesList();

        Dependencies getToSpecific = dependenciesList.stream().filter(dependencies -> dependencies.getId().equals(dependenciesId)).findFirst().orElse(null);

        if (getToSpecific == null) {

            throw new EmployeeNotFoundException("Dependencies id not found");

        }
        DependencyResponse dependencyResponse = DependencyResponse.builder().id(getToSpecific.getId()).relationship(getToSpecific.getRelationship()).build();

        return dependencyResponse;



    }


}
