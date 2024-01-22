package lk.purna.HRnewV1.controller;

import lk.purna.HRnewV1.controller.request.DependencyRequest;
import lk.purna.HRnewV1.controller.response.DependencyResponse;
import lk.purna.HRnewV1.exception.EmployeeNotFoundException;
import lk.purna.HRnewV1.service.DependencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DependencyController {

    private DependencyService dependencyService;

@PostMapping("/dependencies/{employee_id}")
    public DependencyResponse add(@PathVariable("employee_id")Long employeeId, @RequestBody DependencyRequest dependencyRequest)throws EmployeeNotFoundException {

        System.out.println("dependency add");
      return   dependencyService.add(employeeId,dependencyRequest);
    }


    @GetMapping("/dependencies")
    public List<DependencyResponse> getAll(){
        System.out.println("get all dependencies");

       return dependencyService.getAll();
    }
}
