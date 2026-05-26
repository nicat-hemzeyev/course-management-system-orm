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
                description = "Bazardüzü_IT_Kursları",
                contact =
                @Contact(
                        name = "Nicat Hemzeyev",
                        email = "hemzeyevnicat25@gmail.com"
                )

        )

)
public class OpenApiConfig {

}
