package titv.springboot.DevToolsEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevToolsExApplication {
	public static void main(String[] args) {
		SpringApplication.run(DevToolsExApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Xin chào nha Hữu Khang!";
	}
}
