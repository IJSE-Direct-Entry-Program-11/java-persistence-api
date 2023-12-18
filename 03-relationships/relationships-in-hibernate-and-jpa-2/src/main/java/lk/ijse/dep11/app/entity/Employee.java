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
@Table(name = "employee")
@IdClass(EmployeePK.class)
public class Employee implements Serializable {
    @Id
    @Column(length = 100)
    private String name;
    @Id
    @Column(length = 50)
    private String department;
    @Column(length = 20, nullable = false)
    private String contact;
}
