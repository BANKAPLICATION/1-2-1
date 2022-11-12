package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "goal")
public class GoalEntity extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goal_title")
    private String goalTitle;

    @Column(name = "prefer_date")
    private Date preferableDateToFinishGoal;

    @Column(name = "comment")
    private String comment;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "owner_id")
    private Long ownerId;

    @OneToMany(mappedBy = "goalEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SubGoalEntity> subGoals = new HashSet<>();

}
