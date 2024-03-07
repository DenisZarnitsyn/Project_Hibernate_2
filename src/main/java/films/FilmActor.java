package films;

import customer.actor.staff.Actor;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "film_actor")
public class FilmActor {
    @Id
    @Column(name = "actor_id")
    private Short actorId;

    @Id
    @Column(name = "film_id")
    private Short filmId;

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id", insertable = false, updatable = false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    private Film film;

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdate;
}
