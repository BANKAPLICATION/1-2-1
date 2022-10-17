package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "sub_goal")
public class SubGoalEntity extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goal_title")
    private String goalTitle;

    @Column(name = "prefer_date")
    private Date preferableDateToFinishGoal;

    @ManyToOne
    @JoinColumn(name = "goal_id", referencedColumnName = "id", nullable = false)
    private GoalEntity goalEntity;

}
