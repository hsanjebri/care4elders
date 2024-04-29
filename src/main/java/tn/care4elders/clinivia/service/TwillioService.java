package tn.care4elders.clinivia.service;

public interface  TwillioService {
    public void sendSms(String to, String from, String body);


    public void makeCall(String from, String to);
}
