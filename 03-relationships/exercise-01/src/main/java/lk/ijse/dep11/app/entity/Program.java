package lk.ijse.dep11.app.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "program")
public class Program implements Serializable {
    @Id
    private String code;
    @Column(nullable = false)
    private int duration;
    @Column(nullable = false)
    private String description;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "program")
    private Set<Batch> batchSet;

    @ManyToMany
    @JoinTable(name = "program_batch",
            joinColumns = @JoinColumn(name = "program_code", referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"))
    private Set<Module> moduleSet;

    public Program(String code, int duration, String description) {
        this.code = code;
        this.duration = duration;
        this.description = description;
    }
}
