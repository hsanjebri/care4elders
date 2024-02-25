package tn.care4elders.clinivia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAspectJAutoProxy

public class CliniviaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliniviaApplication.class, args);
	}

}
