package tn.care4elders.clinivia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  Idfeedback;

    @Temporal(TemporalType.DATE)
    private Date feedbackCreatedAt;

    private String feedbackContent;

    private String feedbackTitle;



    private float feedbackRating;


    @ManyToOne
    Patient patient;
}
