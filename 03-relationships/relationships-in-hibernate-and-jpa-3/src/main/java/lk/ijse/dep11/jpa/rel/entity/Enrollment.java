package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enrollment")
public class Enrollment implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", columnDefinition = "VARCHAR(10)")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", columnDefinition = "VARCHAR(10)",
            nullable = false)
    private Course course;

    @Column(nullable = false)
    private String coordinator;
    @Column(nullable = false)
    private Date date;
}
