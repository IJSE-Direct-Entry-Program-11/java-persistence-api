package lk.ijse.dep11.app.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
@Entity
public class Movie implements Serializable {
    @Id
    private String id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String category;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "movieSet")
    private Set<Actor> actorSet;

    public Movie(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
