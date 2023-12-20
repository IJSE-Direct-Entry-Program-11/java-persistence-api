package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "athlete_trainer")
public class AthleteTrainer implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "athlete_id", referencedColumnName = "id", columnDefinition = "VARCHAR(20)")
    private Athlete athlete;
    @OneToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id", unique = true, nullable = false,
            columnDefinition = "VARCHAR(20)")
    private PersonalTrainer trainer;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false, columnDefinition = "DECIMAL(8,2)")
    private BigDecimal contract;
}
