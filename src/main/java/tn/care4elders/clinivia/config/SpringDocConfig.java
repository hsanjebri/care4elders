package tn.care4elders.clinivia.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        return new Contact().name("Equipe ASI II")
                .email("*************@esprit.tn")
                .url("https://www.linkedin.com/in//");
    }

    @Bean
    public GroupedOpenApi medicinePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Medicine Management API")
                .pathsToMatch("/api/medicines/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi prescriptionPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Prescription Management API")
                .pathsToMatch("/api/prescriptions/**")
                .pathsToExclude("**")

                .build();
    }

    @Bean
    public GroupedOpenApi equipmentPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Equipment Management API")
                .pathsToMatch("/api/equipments/**")
                .pathsToExclude("**")

                .build();
    }

    @Bean
    public GroupedOpenApi customGroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("Custom Group")
                .pathsToMatch("/api/custom/**")
                .pathsToExclude("**")

                .build();
    }

    @Bean
    public GroupedOpenApi allPublicApi() {
        return GroupedOpenApi.builder()
                .group("All Public APIs")
                .pathsToMatch("/api/**")
                .pathsToExclude("/api/admin/**")

                .build();
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("Admin APIs")
                .pathsToMatch("/api/admin/**")
                .pathsToExclude("**")

                .build();
    }

    @Bean
    public GroupedOpenApi authenticatedApi() {
        return GroupedOpenApi.builder()
                .group("Authenticated APIs")
                .pathsToMatch("/api/**")
                .pathsToExclude("/api/public/**")

                .build();
    }
    @Bean
    public GroupedOpenApi userPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only User Management API")
                .pathsToMatch("/api/User/**")
                .pathsToExclude("**")
                .build();
    }

}


