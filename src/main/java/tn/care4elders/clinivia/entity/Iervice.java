package tn.care4elders.clinivia.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Iervice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long IdService ;

    private String serviceName;
    private String serviceDescription;
    private double servicePrice;


    @ManyToOne
    Patient patient;


    @ManyToOne
    User user;


}
