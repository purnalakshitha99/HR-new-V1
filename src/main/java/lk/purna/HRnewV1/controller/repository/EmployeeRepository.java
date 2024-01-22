package lk.purna.HRnewV1.controller.repository;

import lk.purna.HRnewV1.controller.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
