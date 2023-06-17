package co.edu.usbcali.tiendaapp.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    private static final String URL_USB = "https://usbcali.edu.co/";

    private final BuildProperties buildProperties;

    public OpenAPIConfiguration(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("API Tienda App")
                                .version(buildProperties.getVersion())
                                .description("API reference for developers")
                                .termsOfService(URL_USB)
                                .contact(
                                        new Contact()
                                                .email("raulandres462@gmail.com")
                                                .name("Universidad de San Buenaventura Cali USB")
                                                .url(URL_USB))
                                .license(
                                        new License()
                                                .name("MIT License")
                                                .url(URL_USB)
                                )
                );

    }

}
