package Entity;

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

public class FeedBacks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;
    private int patientId;
    @Temporal(TemporalType.DATE)

    private Date feedbackCreatedAt;
    private String feedbackContent;
    private String feedbackTitle;
    private boolean feedbackVerified;
    private float feedbackRating;

}
