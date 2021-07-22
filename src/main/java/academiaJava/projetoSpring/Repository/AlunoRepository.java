package academiaJava.projetoSpring.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academiaJava.projetoSpring.model.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Integer> {

	
}