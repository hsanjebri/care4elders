package Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    IdPayment ;
    private Date paymentCreatedAt;

    private String paymentDescription;

    private float paymentAmount;

    //////status hedhi tji enumeration     PENDING, IN_PROGRESS, DELIVERED
    private float paymentVerified;

    @Temporal(TemporalType.DATE)
    private Date paymentExpiredAt;
    @Enumerated(EnumType.STRING)
    private PaymentM paymentMethod;


    @ManyToOne
    Patient patient;
}
