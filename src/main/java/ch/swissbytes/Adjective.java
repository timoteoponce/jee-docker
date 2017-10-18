package ch.swissbytes;

import javax.persistence.*;
import java.io.*;

@Entity
@Table(name = "ADJECTIVE")
public class Adjective implements Serializable {
    @Id
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
