package lk.purna.HRnewV1.controller.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "dependencies")
public class Dependencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String relationship;

    @ManyToOne
    private Employee employee;
}
