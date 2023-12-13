package lk.ijse.dep11.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "batch")
public class Batch implements Serializable {
    @Id
    private int id;
    @Column(name = "commencing_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date commencingDate;
    @ManyToOne
    @JoinColumn(name = "program_code", referencedColumnName = "code", nullable = false)
    private Program program;

    @ManyToMany
    @JoinTable(name = "batch_student",
            joinColumns = @JoinColumn(name = "batch_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> studentSet;
}
