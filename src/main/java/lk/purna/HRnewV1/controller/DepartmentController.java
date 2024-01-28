package lk.purna.HRnewV1.controller;

import lk.purna.HRnewV1.controller.request.DepartmentRequest;
import lk.purna.HRnewV1.controller.response.DepartmentResponseBuilder;
import lk.purna.HRnewV1.exception.DepartmentNotFoundException;
import lk.purna.HRnewV1.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public DepartmentResponseBuilder add(@RequestBody DepartmentRequest departmentRequest){

        System.out.println("add department");
       return departmentService.add(departmentRequest);

    }

    @GetMapping("/departments/{department_id}")
    public DepartmentResponseBuilder getSpecific(@PathVariable("department_id")Long departmentId)throws DepartmentNotFoundException {
        System.out.println("get specific Department");

        return departmentService.getSpecific(departmentId);
    }


}
