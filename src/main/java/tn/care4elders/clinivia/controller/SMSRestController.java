package tn.care4elders.clinivia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.SMSSendRequest;
import tn.care4elders.clinivia.service.SMSService;

@RestController
@RequestMapping("/api/v1")
public class SMSRestController {
    @Autowired
    SMSService smsService ;
    @PostMapping("/sendSms")
    public String sendSms(@RequestBody SMSSendRequest smsSendRequest) {


     return smsService.sendSMS(smsSendRequest.getDestinationSMSNumber(), smsSendRequest.getSmsMessage());    }







}
