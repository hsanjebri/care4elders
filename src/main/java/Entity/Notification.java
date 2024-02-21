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
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long notificationId;

    String message;

    @Temporal(TemporalType.DATE)
    Date createdAt;

    boolean isRead;

    @ManyToOne
    Patient patient;


    @ManyToOne
    User user;


}
