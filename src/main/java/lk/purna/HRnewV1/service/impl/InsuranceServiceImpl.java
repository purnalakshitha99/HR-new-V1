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




    @Override
    public InsuranceResponseBuilder add(InsuranceRequest insuranceRequest) {

        Insurance insurance = new Insurance();

        insurance.setType(insuranceRequest.getType());
        insurance.setCompany(insuranceRequest.getCompany());

        insuranceRepository.save(insurance);

        return InsuranceResponseBuilder.builder().id(insurance.getId()).type(insurance.getType()).company(insurance.getCompany()).build();
    }
}
