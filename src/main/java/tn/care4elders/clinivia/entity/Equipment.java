package tn.care4elders.clinivia.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String i_name;
    private String category;

    private int qty;

    @Temporal(TemporalType.DATE)
    private Date date;

    private float price;

    private String details;


    @ManyToOne
    Patient patient;

}