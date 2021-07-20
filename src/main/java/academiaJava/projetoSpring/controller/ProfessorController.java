package academiaJava.projetoSpring.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academiaJava.projetoSpring.Repository.ProfessorRepository;
import academiaJava.projetoSpring.model.Professor;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;

	@PostMapping("/post")
	public Professor createProfessor(@RequestBody Professor professor) {

		return this.professorRepository.save(professor);

	}

	@GetMapping("/get")
	public List<Professor> viewProfessor() {
		return this.professorRepository.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<Professor> viewProfessor(@PathVariable("id") int id) {
		return this.professorRepository.findById(id);
	}
	
	@PutMapping("/put/{id}")
	public String attProfessor(@PathVariable("id") int id, @RequestBody Professor newProfessor ) {
		Optional<Professor> oldProfessor = this.professorRepository.findById(id);
		
		if(oldProfessor.isPresent()) {
			Professor professor = oldProfessor.get();
			professor.setId(newProfessor.getId());
			professor.setNome(newProfessor.getNome());
			professor.setIdade(newProfessor.getIdade());
			professor.setCpf(newProfessor.getCpf());
			professor.setSalario(newProfessor.getSalario());
			professorRepository.save(professor);
			
			return "Os dados do professor selecionado foram atualizados com sucesso!";
		} else {
			return "Ops... Não encontramos nenhum professor com este id em nosso sistema, por gavor, tente novamente!";
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public String apagarProfessor(@PathVariable("id") int id) {
		
		Optional<Professor> professorFind = this.professorRepository.findById(id);
		
		if(professorFind.isPresent()) {
			professorRepository.delete(professorFind.get());
			
			return "O professor selecionado foi excluído com sucesso!";
		} else {

			return "Ops... Não encontramos nenhum professor com este id em nosso sistema, por favor, tente novamente!";
		}
		
	}


}
