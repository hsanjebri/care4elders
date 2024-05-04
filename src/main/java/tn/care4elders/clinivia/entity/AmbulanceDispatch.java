package tn.care4elders.clinivia.entity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class AmbulanceDispatch {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long dispatchId;

        private boolean dispatchStatus;

        private String serialNumber;

        private String driverName;

        private String hospitalDestination;


        private int estimatedDuration;


        @OneToOne
        private Patient patient;

        @ManyToOne
        private User user;


}
