package lk.purna.HRnewV1.controller;


import lk.purna.HRnewV1.controller.request.EmployeeRequest;
import lk.purna.HRnewV1.controller.response.EmployeeResponse;
import lk.purna.HRnewV1.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/employees")
    public EmployeeResponse add(@RequestBody EmployeeRequest employeeRequest){

        System.out.println("employee add");
        return employeeService.add(employeeRequest);

    }

    @GetMapping("/employees/{employee_id}")
    public EmployeeResponse get(@PathVariable("employee_id")Long employeeId){
        System.out.println("get employee");

        return employeeService.get(employeeId);
    }

    @PutMapping("/employees/{employee_id}")
    public EmployeeResponse update(@PathVariable("employee_id")Long employeeId,@RequestBody EmployeeRequest employeeRequest){
        System.out.println("update employee ");

        return employeeService.update(employeeId,employeeRequest);
    }



}
