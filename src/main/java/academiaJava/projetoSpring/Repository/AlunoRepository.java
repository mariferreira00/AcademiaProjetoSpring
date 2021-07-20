package academiaJava.projetoSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import academiaJava.projetoSpring.model.Aluno;



public interface AlunoRepository extends JpaRepository <Aluno, Integer> {

	
}