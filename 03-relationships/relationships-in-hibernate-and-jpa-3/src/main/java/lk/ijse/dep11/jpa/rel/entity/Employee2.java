package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee2")
public class Employee2 {
    @Id
    @Column(length = 10)
    private String id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String contact;

    @OneToOne
    @JoinTable(name = "married_employee",
            joinColumns = @JoinColumn(name = "emp_id1", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id2", referencedColumnName = "id",
                    unique = true, nullable = false))
    private Employee2 married;

    public Employee2(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
}
