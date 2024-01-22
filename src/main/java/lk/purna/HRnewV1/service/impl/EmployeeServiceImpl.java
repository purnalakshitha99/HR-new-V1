package lk.purna.HRnewV1.service.impl;

import lk.purna.HRnewV1.controller.model.Employee;
import lk.purna.HRnewV1.controller.repository.EmployeeRepository;
import lk.purna.HRnewV1.controller.request.EmployeeRequest;
import lk.purna.HRnewV1.controller.response.EmployeeResponse;
import lk.purna.HRnewV1.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeResponse add(EmployeeRequest employeeRequest){

        Employee employee = new Employee();

        employee.setName(employeeRequest.getName());

        employeeRepository.save(employee);


        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());

        return employeeResponse;


    }

    public EmployeeResponse get(Long employeeId){
        Optional<Employee>employeeOptional = employeeRepository.findById(employeeId);
        EmployeeResponse employeeResponse = new EmployeeResponse();

        if (employeeOptional.isPresent()){

            Employee employee = employeeOptional.get();

            employeeResponse.setId(employee.getId());
            employeeResponse.setName(employee.getName());

            return employeeResponse;
        }
return null;
    }

    public EmployeeResponse update(Long employeeId,EmployeeRequest employeeRequest){
        Optional<Employee>employeeOptional = employeeRepository.findById(employeeId);
        EmployeeResponse employeeResponse = new EmployeeResponse();

        if (employeeOptional.isPresent()){

            Employee employee = employeeOptional.get();

            employee.setName(employeeRequest.getName());

            employeeRepository.save(employee);

            employeeResponse.setId(employee.getId());
            employeeResponse.setName(employee.getName());

            return employeeResponse;
        }else {
            System.out.println("not in id");
        }

        return null;
    }


    

}
