package lk.purna.HRnewV1.service.impl;

import lk.purna.HRnewV1.controller.model.Department;
import lk.purna.HRnewV1.controller.repository.DepartmentRepository;
import lk.purna.HRnewV1.controller.request.DepartmentRequest;
import lk.purna.HRnewV1.controller.response.DepartmentResponseBuilder;
import lk.purna.HRnewV1.controller.response.MessageResponse;
import lk.purna.HRnewV1.exception.DepartmentNotFoundException;
import lk.purna.HRnewV1.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.hibernate.engine.jdbc.dialect.spi.DialectFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentResponseBuilder add(DepartmentRequest departmentRequest){

        Department department = new Department();

        department.setName(departmentRequest.getName());

        departmentRepository.save(department);

        return DepartmentResponseBuilder.builder().id(department.getId()).name(department.getName()).build();

    }

    public DepartmentResponseBuilder getSpecific(Long departmentId)throws DepartmentNotFoundException {
        Optional<Department>departmentOptional = departmentRepository.findById(departmentId);

        if (!departmentOptional.isPresent()){
            throw new DepartmentNotFoundException("That Departments not in a database");
        }

        Department department = departmentOptional.get();

        return DepartmentResponseBuilder.builder().id(department.getId()).name(department.getName()).build();

    }

    public List<DepartmentResponseBuilder> getAll(){
        List<Department>departmentList = departmentRepository.findAll();

        return departmentList.stream().map(department -> DepartmentResponseBuilder.builder().id(department.getId()).name(department.getName()).build()).toList();
    }

    public DepartmentResponseBuilder update(Long departmentId,DepartmentRequest departmentRequest)throws DepartmentNotFoundException{
        Optional<Department>departmentOptional = departmentRepository.findById(departmentId);

        if (!departmentOptional.isPresent()){
            throw new DepartmentNotFoundException("That Department not found in a Database");
        }

        Department department = departmentOptional.get();

        department.setName(departmentRequest.getName());

        departmentRepository.save(department);

        return DepartmentResponseBuilder.builder().id(department.getId()).name(department.getName()).build();
    }
    public MessageResponse delete(Long departmentId)throws DepartmentNotFoundException{
        Optional<Department>departmentOptional = departmentRepository.findById(departmentId);

        if (!departmentOptional.isPresent()){
            throw new DepartmentNotFoundException("That Department not found in the database");
        }



        departmentRepository.deleteById(departmentId);

        MessageResponse messageResponse = new MessageResponse();
         messageResponse.setMessage("Successfully Delete : "+departmentId+" Department");

         return messageResponse;
    }

}
