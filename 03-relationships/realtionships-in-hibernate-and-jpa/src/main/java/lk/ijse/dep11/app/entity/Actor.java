package lk.ijse.dep11.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
@Entity
public class Actor implements Serializable {
    @Id
    private int id;
    @Column(nullable = false, length = 100)
    private String name;

    @ManyToMany
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name="actor_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> movieSet;

    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
