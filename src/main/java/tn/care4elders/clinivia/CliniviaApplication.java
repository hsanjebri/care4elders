package tn.care4elders.clinivia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.care4elders.clinivia.service.serviceImpl.DietPlanServiceImpl;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling

public class CliniviaApplication {


	public static void main(String[] args) {
		SpringApplication.run(CliniviaApplication.class, args);
//		PhoneCall phoneCall = new PhoneCall();
//		System.out.println("ggggggggggggggggg");
//		phoneCall.makeCall();


	}

}
