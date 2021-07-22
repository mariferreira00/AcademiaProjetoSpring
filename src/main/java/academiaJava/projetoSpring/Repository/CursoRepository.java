package academiaJava.projetoSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academiaJava.projetoSpring.model.Curso;

public interface CursoRepository extends JpaRepository <Curso, Integer>{

}
