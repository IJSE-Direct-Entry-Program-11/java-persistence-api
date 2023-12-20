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
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @Column(length = 10)
    private String id;
    @Column(nullable = false, length = 50)
    private String description;
    @Column(nullable = false, length = 50)
    private String duration;
}
