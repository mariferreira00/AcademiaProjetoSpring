package academiaJava.projetoSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

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

@GroupSequence({Professor.class})
public class Professor{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "O CPF é obrigatório, por favor, informe um CPF!")
	@Length(min = 11, max = 14, message = "O CPF deverá ter entre {min} e {max} caracteres")
	private String cpf;	
	@NotBlank(message = "O campo NOME é obrigatório, por favor, informe um nome!")
	@Length(min = 3, max = 35, message = "O nome deverá ter no mínimo {min} e no máximo {max} caracteres")
	private String nome;
	@Min(18)
	private int idade;
	@NotBlank(message = "O campo SALÁRIO é obrigatório, por favor, informe um salário!")
	@Min(1800)
	private double salario;

}