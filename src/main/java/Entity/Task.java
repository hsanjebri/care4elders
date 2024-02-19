package Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskTitle;

    @Temporal(TemporalType.DATE)
    private Date taskStartDate;

    @Temporal(TemporalType.DATE)
    private Date taskEndDate;

    private String taskDescription;

    private boolean taskStatus;
}
