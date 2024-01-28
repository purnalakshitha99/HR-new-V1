package lk.purna.HRnewV1.service.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import lk.purna.HRnewV1.controller.model.Employee;
import lk.purna.HRnewV1.controller.model.Insurance;
import lk.purna.HRnewV1.controller.repository.EmployeeRepository;
import lk.purna.HRnewV1.controller.repository.InsuranceRepository;
import lk.purna.HRnewV1.controller.request.InsuranceRequest;
import lk.purna.HRnewV1.controller.response.InsuranceResponseBuilder;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;
import lk.purna.HRnewV1.exception.InsuranceNotFoundException;
import lk.purna.HRnewV1.service.InsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final EmployeeRepository employeeRepository;
    private final InsuranceRepository insuranceRepository;

    public InsuranceResponseBuilder add(Long employeeId,InsuranceRequest insuranceRequest)throws EmployeeNotFoundException {

        Optional<Employee>employeeOptional = employeeRepository.findById(employeeId) ;

        if (!employeeOptional.isPresent()){
            throw new EmployeeNotFoundException("That Employee not in the this system : "+employeeId);
        }

        Employee employee = employeeOptional.get();

        Insurance insurance = new Insurance();
        insurance.setCompany(insuranceRequest.getCompany());
        insurance.setType(insuranceRequest.getType());

        insurance.setEmployee(employee);

        insuranceRepository.save(insurance);

        InsuranceResponseBuilder insuranceResponseBuilder = InsuranceResponseBuilder
                .builder()
                .id(insurance.getId())
                .company(insurance.getCompany())
                .type(insurance.getType())
                .build();


        return insuranceResponseBuilder;

    }
}
