package tn.care4elders.clinivia.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class SMSService {
    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID ;
    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN ;
    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String  OUTGOING_SMS_NUMBER ;

    public SMSService() {
        log.info("creating class smsService");
        log.info("account sid"+ACCOUNT_SID);

    }
    @PostConstruct
    private void setup(){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }

    public String sendSMS(String SmsNumber, String smsMessage){
        Message message =Message.creator(  new PhoneNumber(SmsNumber),
                new PhoneNumber(OUTGOING_SMS_NUMBER),smsMessage
                ).create();
return message.getStatus().toString();
    }

}
