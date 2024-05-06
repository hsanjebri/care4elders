package tn.care4elders.clinivia.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long idTask;

    private String title;

    @Temporal(TemporalType.DATE)
    private Date due_date;

    @Temporal(TemporalType.DATE)
    private Date taskEndDate;

    private String note;

    private String priority;

    private boolean done;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JsonIgnore 
    @JoinColumn(name = "user_id")
    private User user;

}
