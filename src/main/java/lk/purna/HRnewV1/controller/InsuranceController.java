package lk.purna.HRnewV1.controller;

import lk.purna.HRnewV1.controller.request.InsuranceRequest;
import lk.purna.HRnewV1.controller.response.InsuranceResponseBuilder;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;
import lk.purna.HRnewV1.exception.InsuranceNotFoundException;
import lk.purna.HRnewV1.service.InsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class InsuranceController {

    private InsuranceService insuranceService;

    @PostMapping("/insurances")
    public InsuranceResponseBuilder add( @RequestBody InsuranceRequest insuranceRequest) {
        System.out.println("add insurance");

       return insuranceService.add(insuranceRequest);
    }
}
