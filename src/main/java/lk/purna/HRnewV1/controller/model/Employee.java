package lk.purna.HRnewV1.controller.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "employee")
    private List<Dependencies>dependenciesList;

    @OneToMany(mappedBy = "employee")
    private List<Insurance>insuranceList;

    @JoinTable(name = "employee_department",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "department_id"))
    @ManyToMany
    private List<Department>departmentList;
}
