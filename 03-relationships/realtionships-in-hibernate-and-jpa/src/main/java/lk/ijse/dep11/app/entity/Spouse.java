package lk.ijse.dep11.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "spouse")
@Entity
public class Spouse implements Serializable {
    @Id
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String contact;
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id", unique = true)
    private Employee employee;
}
