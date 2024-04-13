package br.com.Musics.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.Musics.sistema.Function.ContinuosReprodution;


@SpringBootApplication
public class SistemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
		
        ContinuosReprodution reprodution  = new ContinuosReprodution(ARQUIVO_MUSICA, false);
        reprodution.start();
	}

	private static final String ARQUIVO_MUSICA = "src/main/java/Musics/Almost Barely - Letting Go.mp3";
	
}
