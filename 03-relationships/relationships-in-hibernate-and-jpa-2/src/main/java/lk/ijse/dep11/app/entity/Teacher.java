package lk.ijse.dep11.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
@IdClass(TeacherPK.class)
public class Teacher implements Serializable {
    @Id
    @Column(name = "first_name", length = 100)
    private String firstName;
    @Id
    @Column(name = "last_name", length = 150)
    private String lastName;
    @Id
    @Column(name = "class", length = 20)
    private String className;

    @Column(length = 20)
    private String contact;
}
