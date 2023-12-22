package lk.ijse.dep11.jpa.queries.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NamedNativeQuery(name = "findAuthors",
        query = "SELECT * FROM author",
        resultClass = Author.class)
@NamedNativeQuery(name = "findAuthorsByName",
        query = "SELECT * FROM author WHERE name LIKE CONCAT(:name, '%')",
        resultClass = Author.class)
@NamedNativeQuery(name = "findAuthorsByContact",
        query = "SELECT * FROM author WHERE contact = ?1",
        resultClass = Author.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
public class Author implements Serializable {
    @Id
    private String id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String contact;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "author")
    private Set<Book> bookSet = new HashSet<>();

    public Author(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
}
