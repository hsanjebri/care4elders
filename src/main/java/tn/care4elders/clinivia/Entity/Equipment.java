package tn.care4elders.clinivia.Entity;
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
    private Long IdEquipment;

    private String itemName;
    private String category;
    private int quantity;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    private float price;

    private String detail;


    @ManyToOne
    Patient patient;

}