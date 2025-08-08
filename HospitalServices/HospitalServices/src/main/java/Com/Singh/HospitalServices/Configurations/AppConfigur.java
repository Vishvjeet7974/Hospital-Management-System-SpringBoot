package Com.Singh.HospitalServices.Configurations;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigur {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
