package lk.purna.HRnewV1.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "insurances")
@Data
public class Insurance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String type;

    @ManyToOne
    private Employee employee;
}
