package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Statistics {

    /**
     * Идентификатор пользователя
     */
    private Long id;

    /**
     * Количество прямых подопечных
     */
    private Long countOfMentees;

    /**
     * Средняя оценка, выставленная по фидбекам 1-2-1
     */
    private double avgGradeOneToOneFeedback;

    /**
     * Средняя оценка, выставленная по фидбекам
     */
    private double avgGradeFeedback;

    /**
     * Суммарное количество проведенных 1-2-1
     */
    private int completedOneToOne;

    /**
     * Суммарное количество оставленных фидбеков 1-2-1
     */
    private int countOfOneToOneFeedback;

    /**
     * Суммарное количество оставленных фидбеков
     */
    private int countOfFeedback;
}
