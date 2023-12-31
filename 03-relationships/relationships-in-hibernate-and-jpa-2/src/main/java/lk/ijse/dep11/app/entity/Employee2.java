package lk.ijse.dep11.app.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "employee2")
public class Employee2 implements Serializable {
    @Id
    private String id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 20)
    private String contact;

    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "employee")
    private Vehicle vehicle;

    public Employee2(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
}
