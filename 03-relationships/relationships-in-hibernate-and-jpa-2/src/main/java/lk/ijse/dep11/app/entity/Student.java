package lk.ijse.dep11.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @EmbeddedId
    @AttributeOverride(name = "firstName", column = @Column(name = "first_name", length = 50))
    @AttributeOverride(name = "lastName", column = @Column(name = "last_name", length = 50))
    private StudentPK studentPK;
    @Column(length = 20, nullable = false)
    private String contact;

    public Student(String firstName, String lastName, String contact) {
        this.studentPK = new StudentPK(firstName, lastName);
        this.contact = contact;
    }
}
