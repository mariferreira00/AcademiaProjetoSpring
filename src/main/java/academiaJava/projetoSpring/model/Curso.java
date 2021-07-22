package academiaJava.projetoSpring.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "tb_curso")
@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cod;
	
	@NotBlank(message = "É obrigatório informar um nome!")
	@Length(min = 3, max = 100, message = "O nome do curso deve ter entre {min} e {max} caracteres!")
	private String nome;
	


}
