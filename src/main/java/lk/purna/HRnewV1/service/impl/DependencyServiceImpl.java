package lk.purna.HRnewV1.service.impl;

import lk.purna.HRnewV1.controller.model.Dependencies;
import lk.purna.HRnewV1.controller.model.Employee;
import lk.purna.HRnewV1.controller.repository.DependencyRepository;
import lk.purna.HRnewV1.controller.repository.EmployeeRepository;
import lk.purna.HRnewV1.controller.request.DependencyRequest;
import lk.purna.HRnewV1.controller.request.EmployeeRequest;
import lk.purna.HRnewV1.controller.response.DependencyResponse;
import lk.purna.HRnewV1.controller.response.EmployeeResponse;
import lk.purna.HRnewV1.exception.DependenciesNotFoundException;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;
import lk.purna.HRnewV1.service.DependencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
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

    public DependencyResponse getSpecificDependencies(Long employeeId, Long dependenciesId) throws EmployeeNotFoundException,DependenciesNotFoundException{
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);


        if (!employeeOptional.isPresent()) {

            throw new EmployeeNotFoundException("That employee not found in the database : " + employeeId);

        }

        Employee employee = employeeOptional.get();
        List<Dependencies> dependenciesList = employee.getDependenciesList();

        Dependencies getToSpecific = dependenciesList.stream().filter(dependencies -> dependencies.getId().equals(dependenciesId)).findFirst().orElse(null);

        if (getToSpecific == null) {

            throw new DependenciesNotFoundException("Dependencies id not found");

        }
        DependencyResponse dependencyResponse = DependencyResponse.builder().id(getToSpecific.getId()).relationship(getToSpecific.getRelationship()).build();

        return dependencyResponse;

    }

    public List<DependencyResponse> getSpecificDependenciesList(Long employeeId)throws EmployeeNotFoundException,DependenciesNotFoundException{
        Optional<Employee>employeeOptional = employeeRepository.findById(employeeId);

        List<DependencyResponse> dependencyResponseList = new ArrayList<>();

        if (!employeeOptional.isPresent()){
            throw new EmployeeNotFoundException("That employee Not found in the database");
        }

        Employee employee = employeeOptional.get();
        List<Dependencies> dependenciesList = employee.getDependenciesList();

        if (dependenciesList == null){
            throw new DependenciesNotFoundException("that dependent list not in the db");
        }

       dependencyResponseList = dependenciesList.stream().map(dependencies -> DependencyResponse.builder().id(dependencies.getId()).relationship(dependencies.getRelationship()).build()).toList();

        return dependencyResponseList;


    }

    public DependencyResponse updateSpecificDependencies(Long employeeId,Long dependenciesId,DependencyRequest dependencyRequest)throws EmployeeNotFoundException,DependenciesNotFoundException{

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (!employeeOptional.isPresent()){
            throw new EmployeeNotFoundException("That Employee not found in the data base : "+employeeId);
        }

        Employee employee = employeeOptional.get();
        List<Dependencies> dependenciesList = employee.getDependenciesList();

        Dependencies updateToDependent = dependenciesList.stream().filter(dependencies -> dependencies.getId().equals(dependenciesId)).findFirst().orElse(null);

        if (updateToDependent == null){
            throw new DependenciesNotFoundException("Dependencies list not found");
        }

        updateToDependent.setRelationship(dependencyRequest.getRelationship());
        dependencyRepository.save(updateToDependent);

        DependencyResponse dependencyResponse = DependencyResponse.builder().id(updateToDependent.getId()).relationship(updateToDependent.getRelationship()).build();
        return dependencyResponse;
    }

    public DependencyResponse deleteSpecificDependencies(Long employeeId,Long dependenciesId)throws EmployeeNotFoundException,DependenciesNotFoundException{
        Optional<Employee>employeeOptional = employeeRepository.findById(employeeId);

        if (!employeeOptional.isPresent()){
            throw new EmployeeNotFoundException("That employee not having a system");
        }

        Employee employee = employeeOptional.get();
        List<Dependencies>dependenciesList = employee.getDependenciesList();

        Dependencies deleteToDependencies = dependenciesList.stream().filter(dependencies -> dependencies.getId().equals(dependenciesId)).findFirst().orElse(null);

        if (deleteToDependencies == null){
            throw new DependenciesNotFoundException("That dependencies not found in a database");
        }

        dependenciesList.remove(deleteToDependencies); //employee ekka sambanda siyalu dewal remove kr damai
        employeeRepository.save(employee);////remove krt passe emp repo eka update wenna

        DependencyResponse dependencyResponse = DependencyResponse.builder()
                .id(deleteToDependencies.getId())
                .relationship(deleteToDependencies.getRelationship())
                .build();

        return dependencyResponse;
    }



}
