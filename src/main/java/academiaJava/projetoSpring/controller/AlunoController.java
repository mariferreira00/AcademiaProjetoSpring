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

import academiaJava.projetoSpring.Repository.AlunoRepository;
import academiaJava.projetoSpring.model.Aluno;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
	

	@Autowired
	private AlunoRepository alunoRepository;

	
	@PostMapping("/post")
	public Aluno createAluno(@RequestBody Aluno aluno) {
		
		return this.alunoRepository.save(aluno);

	}
	
	@GetMapping("/get")
	public List<Aluno> getAluno() {
		return this.alunoRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
    public Optional<Aluno> getAlunos(@PathVariable("id") int id) {
		return this.alunoRepository.findById(id);
    	}
    
	@PutMapping("/update/{id}")
	public String attAluno(@RequestBody Aluno alunoNovo, @PathVariable("id") int id) {
		
		Optional<Aluno> alunoAnt = this.alunoRepository.findById(id);
		if (alunoAnt.isPresent()) {
			alunoRepository.delete(alunoAnt.get());
			Aluno aluno = alunoAnt.get();
			aluno.setNome(alunoNovo.getNome());
			aluno.setIdade(alunoNovo.getIdade());
			aluno.setNomeCurso(alunoNovo.getNomeCurso());
			alunoRepository.save(aluno);
			
			return "Os dados do aluno foram alterados com sucesso!";
		}else {
			return "Ops... Não encontramos nenhum aluno com este id em nosso sistema, tente novamente!";
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public  String deleteAluno(@PathVariable("id") int id) {
		
		Optional<Aluno> alunoEncontrado = this.alunoRepository.findById(id);
		
		if (alunoEncontrado.isPresent()) {
			alunoRepository.delete(alunoEncontrado.get());
			
			return "O Aluno selecionado foi excluído com sucesso!";
		}else {
			
			return "Ops... Não encontramos nenhum aluno com este id em nosso sistema, tente novamente!";
		}
		
	}
	

	
}