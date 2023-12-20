package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "module")
public class Module {
    @Id
    @Column(length = 10)
    private String code;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false)
    private int credits;

    @ManyToMany
    @JoinTable(name = "prerequisites_modules",
            joinColumns = @JoinColumn(name = "pre_code", referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "code", referencedColumnName = "code"))
    private Set<Module> preRequisitesModules = new HashSet<>();

    public Module(String code, String description, int credits) {
        this.code = code;
        this.description = description;
        this.credits = credits;
    }
}
