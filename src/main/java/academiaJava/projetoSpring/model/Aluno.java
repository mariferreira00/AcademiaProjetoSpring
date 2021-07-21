package academiaJava.projetoSpring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity

@GroupSequence({Aluno.class})
public class Aluno {
	
	@Id
	private int id;
	@NotBlank(message = "O CPF é obrigatório!")
	@Max(14)
	private String cpf;	
	@NotBlank(message = "O campo NOME é obrigatório, por favor, informe um nome!")
	@Length(min = 3, max = 35, message = "O nome deverá ter no máximo {max} caracteres")
	private String nome;
	@NotBlank(message = "O campo Curso é obrigatório, por favor, informe o nome do curso!")
	private String nomeCurso;
	@Min(18)
	private int idade;


	
}