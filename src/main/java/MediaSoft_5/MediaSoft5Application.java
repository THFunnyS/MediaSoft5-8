package MediaSoft_5;

import MediaSoft_5.Services.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediaSoft5Application {

	public static void main(String[] args) {
		SpringApplication.run(MediaSoft5Application.class, args);
	}
	@Bean
	CommandLineRunner run(AppService appService){
		return args -> {
			appService.test();
		};
	}

}
