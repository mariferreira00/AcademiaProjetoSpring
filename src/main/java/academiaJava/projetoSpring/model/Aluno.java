package academiaJava.projetoSpring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table
public class Aluno {
	
	@Id
	private int id;
	private String cpf;	
	private String nome;
	private int idade;
	private String nomeCurso;
}