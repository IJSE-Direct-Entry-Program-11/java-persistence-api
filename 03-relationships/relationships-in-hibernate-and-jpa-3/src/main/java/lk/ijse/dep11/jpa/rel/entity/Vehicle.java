package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {
    @Id
    @Column(name = "reg_number", length = 20)
    private String regNumber;
    @Column(length = 50, nullable = false)
    private String model;
}
