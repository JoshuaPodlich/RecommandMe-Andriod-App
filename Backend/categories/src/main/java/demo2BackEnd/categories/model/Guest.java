package demo2BackEnd.categories.model;

import javax.persistence.*;
import java.io.File;
import java.util.UUID;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    UUID guest_id = UUID.randomUUID();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(UUID guest_id) {
        this.guest_id = guest_id;
    }
}
