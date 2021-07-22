package academiaJava.projetoSpring.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResource {
	
	private Integer id;
	private String nome;
	private Integer cpf;
	private Integer idade;
	
	private CursoResource curso;
	

}
