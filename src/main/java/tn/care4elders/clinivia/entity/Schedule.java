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
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdScheules;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date startTime;

    @Temporal(TemporalType.DATE)
    private Date endTime;

    @ManyToOne
    User user;




}
