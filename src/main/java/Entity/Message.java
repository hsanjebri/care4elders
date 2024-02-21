package Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdMessage;

    @Temporal(TemporalType.DATE)
    private Date SentTime ;

    private String messageTitle;

    private String messageBody;

    @ManyToOne
    Patient patient;


    @ManyToOne
    User user;

}