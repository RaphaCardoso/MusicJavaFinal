package br.com.Musics.sistema.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Entidade indicando que é Objeto
@Data // Gera automaicamente o getts ande setters
@NoArgsConstructor // Não recebe argumentos
public class Usuario {


	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String lastName;
	private String nick;
	private String pais;
	private String genero;
	private String musicaFav;
	private String senha;
	
}
