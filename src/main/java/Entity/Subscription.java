package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subscriptionID;
/////////?????
    private int subscriptionDuration;

    @Temporal(TemporalType.DATE)
    private Date subscriptionDateOfCreation;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    private float subscriptionFee;

    private boolean status;




    @OneToOne(mappedBy="subscription")
    private Patient patient;
}