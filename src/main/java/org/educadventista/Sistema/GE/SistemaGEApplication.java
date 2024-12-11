package org.educadventista.Sistema.GE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.educadventista.Sistema.GE")  // Certifique-se de que o pacote está sendo escaneado
public class SistemaGEApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaGEApplication.class, args);
	}

}
