package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "one_to_one_meet")
@NoArgsConstructor
@EqualsAndHashCode
public class OneToOneMeetEntity extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "oneToOneMeetEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<NotificationEntity> notifications = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "feedback_id")
    private FeedBackEntity feedBack;


}
