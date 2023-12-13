package lk.ijse.dep11.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "contact")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {
    @Id
    @Column(length = 15)
    private String telephone;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;
}
