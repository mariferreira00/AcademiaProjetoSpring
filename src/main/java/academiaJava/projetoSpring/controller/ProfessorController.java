package academiaJava.projetoSpring.controller;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academiaJava.projetoSpring.model.Professor;


@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {
	private List<Professor> professores = new ArrayList<Professor>();
	
	@PostMapping("/post")
	public String criarProfessor(@RequestBody Professor professor) {
		professores.add(professor);
		return "Professor cadastrado com sucesso!";
	}

	@GetMapping("/get")
	public List<Professor> viewProfessores() {
		return professores;
	}

	@GetMapping("/get/{id}")
	public Professor getProfessor(@PathVariable("id") int id) {
		Professor wanted = null;
		for (Professor wtd : professores) {
			if (wtd.getId() == id) {
				wanted = wtd;
			}
		}
		return wanted;
	}


	@PutMapping("/put/{id}")
	public void attProfessor(@PathVariable("id") int id, @RequestBody Professor professor) {
		for (int i = 0; i < professores.size(); i++) {
			Professor wtd = professores.get(i);
			if (wtd.getId() == id) {
				professores.set(i, professor);
				System.out.println("Os dados do professor foram ATUALIZADOS com sucesso!");
			}
		}

	}

	@DeleteMapping("/delete/{id}")
	public void apagarProfessor(@PathVariable("id") int id) {
		int i = -1;
		Professor wanted = null;
		for (Professor wtd : professores) {
			if (wtd.getId() == id) {
				i = professores.indexOf(wtd);
				wanted = wtd;
				break;
			}
		}
		professores.remove(i);
	}

}


