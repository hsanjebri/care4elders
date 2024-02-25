package tn.care4elders.clinivia.entity;
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
    private Long IdTask;

    private String taskTitle;

    @Temporal(TemporalType.DATE)
    private Date taskStartDate;

    @Temporal(TemporalType.DATE)
    private Date taskEndDate;

    private String taskDescription;

    private boolean taskStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

<<<<<<< HEAD
    @ManyToOne
    User user;



=======
>>>>>>> a843e8eccfccdcbfcac1d537bf0a2f524a844873
}
