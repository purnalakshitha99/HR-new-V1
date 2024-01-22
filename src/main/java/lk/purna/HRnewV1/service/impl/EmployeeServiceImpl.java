package lk.purna.HRnewV1.service.impl;

import lk.purna.HRnewV1.controller.model.Employee;
import lk.purna.HRnewV1.controller.repository.EmployeeRepository;
import lk.purna.HRnewV1.controller.request.EmployeeRequest;
import lk.purna.HRnewV1.controller.response.EmpResponseBuilder;
import lk.purna.HRnewV1.controller.response.EmployeeResponse;
import lk.purna.HRnewV1.controller.response.MessageResponse;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;
import lk.purna.HRnewV1.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
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

    public EmployeeResponse get(Long employeeId)throws EmployeeNotFoundException {
        Optional<Employee>employeeOptional = employeeRepository.findById(employeeId);
        EmployeeResponse employeeResponse = new EmployeeResponse();

        if (!employeeOptional.isPresent()){

            throw new EmployeeNotFoundException("That Employee Not in a Db");

        }
        Employee employee = employeeOptional.get();

        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());

        return employeeResponse;

    }

    public EmployeeResponse update(Long employeeId,EmployeeRequest employeeRequest)throws EmployeeNotFoundException{
        Optional<Employee>employeeOptional = employeeRepository.findById(employeeId);
        EmployeeResponse employeeResponse = new EmployeeResponse();

        if (!employeeOptional.isPresent()){


            throw new EmployeeNotFoundException("That Employee Not Found");

        }else {
            Employee employee = employeeOptional.get();

            employee.setName(employeeRequest.getName());

            employeeRepository.save(employee);

            employeeResponse.setId(employee.getId());
            employeeResponse.setName(employee.getName());


        }



        return employeeResponse;
    }


    public MessageResponse delete(Long employeeId)throws EmployeeNotFoundException{

        Optional<Employee>employeeOptional = employeeRepository.findById(employeeId);
        MessageResponse messageResponse = new MessageResponse();

        if (!employeeOptional.isPresent()){

            throw new EmployeeNotFoundException("employee no in a DB : "+employeeId);
        }

        Employee employee = employeeOptional.get();

        employeeRepository.delete(employee);

        messageResponse.setMessage("Delete by employee : "+employeeId);

        return messageResponse;

    }


    public List<EmpResponseBuilder> getAll(){

        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream()
                .map(employee -> EmpResponseBuilder.builder().id(employee.getId()).name(employee.getName())
                        .build()).toList();
    }


}
