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
<<<<<<< HEAD
    Patient patient;

    @ManyToOne
    User user;
=======
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
>>>>>>> f3fbe0b539a83b2e7f2879c24731565a30e2d4cc

}
