package lk.ijse.dep11.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    private int id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 20)
    private String contact;
    @Column(nullable = false, length = 500)
    private String address;

    @ToString.Exclude
    @OneToOne(mappedBy = "employee")
    private Spouse spouse;

    public Employee(int id, String name, String contact, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public void setSpouse(Spouse spouse){
        this.spouse = spouse;
        spouse.setEmployee(this);
    }
}
