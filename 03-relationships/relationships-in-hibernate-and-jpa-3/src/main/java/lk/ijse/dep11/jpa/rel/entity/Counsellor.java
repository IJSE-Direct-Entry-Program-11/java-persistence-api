package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "counsellor")
public class Counsellor {
    @Id
    private int id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 20)
    private String contact;
}
