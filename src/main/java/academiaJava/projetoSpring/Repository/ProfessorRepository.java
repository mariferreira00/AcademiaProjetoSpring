package academiaJava.projetoSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academiaJava.projetoSpring.model.Professor;



public interface ProfessorRepository extends JpaRepository <Professor, Integer> {

}