package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "athlete")
public class Athlete implements Serializable {
    @Id
    @Column(length = 20)
    private String id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private Date dob;
}
