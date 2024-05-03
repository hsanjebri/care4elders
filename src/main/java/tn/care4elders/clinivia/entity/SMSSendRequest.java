package tn.care4elders.clinivia.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class SMSSendRequest {
    private  String destinationSMSNumber ;
    private  String smsMessage ;

}
