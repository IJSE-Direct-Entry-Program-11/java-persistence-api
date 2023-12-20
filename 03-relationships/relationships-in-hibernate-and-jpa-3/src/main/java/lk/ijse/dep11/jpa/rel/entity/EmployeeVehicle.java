package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_vehicle")
public class EmployeeVehicle implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @OneToOne
    @JoinColumn(name = "reg_number", referencedColumnName = "reg_number", unique = true, nullable = false)
    private Vehicle vehicle;
    @Column(name = "assign_by", nullable = false)
    private String assignBy;
    @Temporal(TemporalType.DATE)
    @Column(name = "assign_date", nullable = false)
    private Date assignDate;
}
