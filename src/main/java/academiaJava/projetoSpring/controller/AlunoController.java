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
import academiaJava.projetoSpring.model.Aluno;


@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@PostMapping("/post")
	public String criarAluno(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return "Aluno cadastrado com sucesso!";
	}

	@GetMapping("/get")
	public List<Aluno> exibirAlunos() {
		return alunos;
	}

	@GetMapping("/get/{id}")
	public Aluno exibirAluno(@PathVariable("id") int id) {
		Aluno wanted = null;
		for (Aluno wtd : alunos) {
			if (wtd.getId() == id) {
				wanted = wtd;
				System.out.println(wanted.toString());
			}
		}
		return wanted;
	}

	@PutMapping("/put/{id}")
	public void attAluno(@PathVariable("id") int id, @RequestBody Aluno aluno) {
		for (int i = 0; i < alunos.size(); i++) {
			Aluno wtd = alunos.get(i);
			if (wtd.getId() == id) {
				alunos.set(i, aluno);
				System.out.println("Os dados do aluno foram ATUALIZADOS com sucesso!");
			}
		}
	}

	@DeleteMapping("/delete/{id}")
	public void apagarAluno(@PathVariable("id") int id) {
		int i = -1;
		Aluno wanted = null;
		for (Aluno wtd : alunos) {
			if (wtd.getId() == id) {
				i = alunos.indexOf(wtd);
				wanted = wtd;
				break;
			}
		}
		alunos.remove(i);
	}



}
