package lk.ijse.dep11.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {
    @Id
    @Column(name = "reg_number", length = 50)
    private String registrationNumber;
    @Column(nullable = false, length = 50)
    private String model;

    @OneToOne
    @JoinTable(name = "employee_vehicle",
            joinColumns = @JoinColumn(name = "vehicle_number", referencedColumnName = "reg_number"),
            inverseJoinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"))
    private Employee2 employee;
}
