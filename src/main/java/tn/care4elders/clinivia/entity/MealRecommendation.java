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
public class MealRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdRecommendation;

    private String recommendedMeal;

    @Temporal(TemporalType.DATE)
    private Date recommendationDate;

    private String Ingredients ;

    private double calories;    
    private double protein;
    private double carbohydrates;
    private double fat;
    private double cholesterol;


    @ManyToOne
    @JoinColumn(name = "plan_id")
    private DietPlan dietPlan;

}
