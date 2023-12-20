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
@Table(name = "counselling")
public class Counselling implements Serializable {
    @Id
    @JoinColumn(name = "student_id", referencedColumnName = "id", columnDefinition = "VARCHAR(20)")
    @OneToOne
    private Student student;

    @ManyToOne
    @JoinColumn(name = "counsellor_id", referencedColumnName = "id", nullable = false)
    private Counsellor counsellor;

    @Column(nullable = false, name = "starting_date")
    private Date startingDate;
    @Column(nullable = false)
    private String reason;

}
