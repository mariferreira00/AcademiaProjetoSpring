package academiaJava.projetoSpring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	public Aluno postAluno(@Valid @RequestBody Aluno aluno) {
		return this.alunoRepository.save(aluno);

	}

	@GetMapping("/get")
	public List<Aluno> getAlunos() {
		return this.alunoRepository.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<Aluno> getAluno(@PathVariable("id") int id) {
		return this.alunoRepository.findById(id);
	}

	@PutMapping("/put/{id}")
	public String attAluno(@RequestBody Aluno alunoN, @PathVariable("id") int id) {

		Optional<Aluno> alunoAnt = this.alunoRepository.findById(id);
		if (alunoAnt.isPresent()) {
			alunoRepository.delete(alunoAnt.get());
			Aluno aluno = alunoAnt.get();
			aluno.setNome(alunoN.getNome());
			aluno.setCurso(alunoN.getCurso());
			aluno.setIdade(alunoN.getIdade());
			aluno.setCpf(alunoN.getCpf());
			alunoRepository.save(aluno);

			return "Os dados do aluno foram atualizados com sucesso!";
		} else {
			return "Ops... Não existe nenhum aluno com este id em nosso sistema, por favor, tente novamente!";
		}
	}

	@DeleteMapping("/delete/{id}")
	public String deleteAluno(@PathVariable("id") int id) {

		Optional<Aluno> alunoFind = this.alunoRepository.findById(id);

		if (alunoFind.isPresent()) {
			alunoRepository.delete(alunoFind.get());

			return "O aluno informado foi excluido com sucesso!";
		} else {

			return "Ops... Não existe nenhum aluno com este id em nosso sistema, por favor, tente novamente!";
		}

	}
	

	
}
