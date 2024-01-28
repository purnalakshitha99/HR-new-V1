package lk.purna.HRnewV1.service;

import lk.purna.HRnewV1.controller.request.InsuranceRequest;
import lk.purna.HRnewV1.controller.response.InsuranceResponseBuilder;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;

public interface InsuranceService {

    InsuranceResponseBuilder add(Long employeeId, InsuranceRequest insuranceRequest)throws EmployeeNotFoundException;
}
