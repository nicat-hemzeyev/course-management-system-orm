package az.example.coursemanagementorm.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "COURSE MANAGEMENT SYSTEM",
                version = "1.0.0",
                description = "telebelerin kurslara yazilmasi",
                contact =
                @Contact(
                        name = "Nicat Hemzeyev",
                        url = "https://youtu.be/XtXaSfbCKRA?si=sAP9n5Lc_VCsWoiO",
                        email = "hemzeyevnicat25@gmail.com"
                )

        )

)
public class OpenApiConfig {

}
