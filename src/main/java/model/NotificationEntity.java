package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "notification")
@Setter
@Getter
@NoArgsConstructor
public class NotificationEntity extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "minute")
    private int minute;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "one_to_one_meet_id", referencedColumnName = "id", nullable = false)
    private OneToOneMeetEntity oneToOneMeetEntity;

    public NotificationEntity(int minute) {
        this.minute = minute;
    }
}
