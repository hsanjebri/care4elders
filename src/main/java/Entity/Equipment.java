package Entity;
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
    private Integer itemId;

    private String itemName;
    private String category;
    private int quantity;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    private int price;
    private String detail;
}