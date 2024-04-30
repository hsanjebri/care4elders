package tn.care4elders.clinivia.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long IdDiet;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String patientName;

    private String dietType;

    private String planDescription;

@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<MealRecommendation> mealRecommendations;

    @ManyToOne
    Patient patient;


}
